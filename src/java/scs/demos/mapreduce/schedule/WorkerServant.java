package scs.demos.mapreduce.schedule;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import scs.core.ConnectionDescription;
import scs.core.IComponent;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.demos.bigtable.Sorter;
import scs.demos.bigtable.test.Reducer;
import scs.demos.mapreduce.Reporter;
import scs.demos.mapreduce.Task;
import scs.demos.mapreduce.TaskStatus;
import scs.demos.mapreduce.WorkerPOA;
import scs.demos.mapreduce.servant.MapReduceTask;
import scs.demos.mapreduce.servant.MapTask;
import scs.demos.mapreduce.servant.ReduceTask;
import scs.event_service.EventSink;


/**
 * Servant que implementa a interface scs::demos::mapreduce::Worker
 * @author Sand Luz Correa
 */

public class WorkerServant extends WorkerPOA {

	private Thread myself = null;
	private String nodeName = null;
	private ORB orb = null;
	private POA poa = null;
	private String configFileName = null;
	private IComponent channel;
	private Reporter reporter;
	private EventSink evSink;
	
	private IComponent workerComponent;
	private ConnectionDescription conns[];

	private String exception = null;
	private String[] operations = {"map","reduce", "join"};

	private class WorkerThread extends Thread{
		private Task task;
		private Any eventAny;
		private int id;
		private TaskStatus op;

		public WorkerThread(Task task) {
			this.task = task;
			this.eventAny = orb.create_any();
		}

		public void run() {
			try {
				
				id = task.getId(); 
				op = task.getStatus();  	
				eventAny.insert_long(id);
				MapReduceTask t = null;

				IReceptacles workerReceptacles = IReceptaclesHelper.narrow(workerComponent.getFacetByName("infoReceptacle"));
				conns = workerReceptacles.getConnections("Sorter");
				Sorter sorter = null;
				reporter.report(0, "ready to sort");
				for (int i = 0; i < conns.length; i++) {
					reporter.report(0, "calling sorter " + i);
					sorter = (Sorter)conns[i].objref;
				}
				assert sorter != null;
				
				if (op.value() == TaskStatus._MAP) {
					t = new MapTask(configFileName, reporter, poa, task, sorter);
				}
				else {                 		
					t = new ReduceTask(configFileName,reporter,poa,task, sorter);
				}			

				t.run();
				t = null;

			} catch (Exception e) {
				exception = LogError.getStackTrace(e);
				reporter.report(0,"WokerServant::run - TaskID= " + id +
						". Erro ao executar " + operations[op.value()] + ".\n" + 
						exception);
				task.setStatus(TaskStatus.ERROR);
			}
			evSink.push(eventAny);
		}	
	}

	public boolean start(String configFileName, String nodeName, IComponent channel, Reporter reporter, IComponent workerComponent) {
		try {

			this.configFileName = configFileName;
			this.nodeName = nodeName;
			this.channel = channel;
			this.reporter = reporter;
			this.workerComponent = workerComponent;

			String[] args = new String[1];
			args[0] = "inicio";	

			orb = ORB.init(args, null);
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();

			this.evSink = ((EventSink)this.channel.getFacet("scs::event_service::EventSink"));
			return true;

		} catch (Exception e) {
			exception = LogError.getStackTrace(e);
			reporter.report(0, "WorkerServant::start - Erro ao criar WorkerServant. \n" + exception);
			return false;
		}
	}


	public void execute (Task task){
		Thread exec = new WorkerThread(task);
		exec.start();
	}	     

	public boolean ping() {
		return myself.isAlive();
	}

	public String getNode() {
		return nodeName;
	}

}


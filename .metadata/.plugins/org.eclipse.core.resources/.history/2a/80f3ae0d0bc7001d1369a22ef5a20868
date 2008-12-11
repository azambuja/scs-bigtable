package scs.demos.mapreduce.servant;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import org.omg.PortableServer.POA;

import scs.demos.mapreduce.Reporter;
import scs.demos.mapreduce.FileSplit;
import scs.demos.mapreduce.IOMapReduceException;
import scs.demos.mapreduce.TaskStatus;
import scs.demos.mapreduce.Task;


/**
 * Classe abstrata que representa uma tarefa map ou reduce
 * @author Sand Luz Correa
*/

public abstract class MapReduceTask {

	protected FileSplit[] inputSplit = null;
        protected FileSplit[] outputSplit = null; 
        protected TaskStatus status = null;
        protected int id = 0;
        protected Properties conf = null;	
        protected Reporter reporter = null;
        protected String configFileName = null;
        protected POA poa = null;
        protected Task task = null;	
        
        public MapReduceTask(String configFileName, POA poa, Task task, Reporter reporter) throws IOException {
		try {
                        this.conf = new Properties(); 
        		this.conf.load(new FileInputStream(configFileName));
                        this.reporter = reporter;
                        this.configFileName = configFileName;
                        this.poa = poa;
                        this.id = task.getId();
                        this.status = task.getStatus();
                        this.task = task; 
     		} catch (IOException e) {
                        throw e;
		}
	}

	public abstract void run() throws IOMapReduceException;
       
}         


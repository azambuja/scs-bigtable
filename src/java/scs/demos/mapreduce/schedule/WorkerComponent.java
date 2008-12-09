package scs.demos.mapreduce.schedule;

import java.util.ArrayList;
import java.util.Properties;

import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import scs.core.ComponentId;
import scs.core.FacetDescription;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.servant.IComponentServant;
import scs.demos.mapreduce.Worker;
import scs.demos.mapreduce.WorkerHelper;

/**
 * Servant do IComponent que oferece a faceta scs::demos::mapreduce::Worker
 * 
 * @author Sand Luz Correa
*/
public class WorkerComponent extends IComponentServant {

	private WorkerServant workerServant = null;
	private Worker worker = null;
	private InfoServant infoServant = null;
	private IReceptacles info = null;


	private final static String IFACE_WORKER = "scs::demos::mapreduce::Worker";
	private final static String FACET_WORKER = "Worker";
	
	private static final String FACET_INFO = "infoReceptacle";
	private static final String IFACE_INFO = "scs::core::IReceptacles";
	
       	/* (non-Javadoc)
	 * @see SCS.servant.IComponentServant#createFacets()
	 */
	@Override
	protected ArrayList<FacetDescription> createFacets() {
		
		ArrayList<FacetDescription> facets = new ArrayList<FacetDescription>();
		FacetDescription fd = new FacetDescription();
		fd.interface_name = IFACE_WORKER;
		fd.name= FACET_WORKER;
		fd.facet_ref = getWorker();
		facets.add(fd);
		
		fd = new FacetDescription();
		fd.interface_name = IFACE_INFO;
		fd.name = FACET_INFO;
		fd.facet_ref = this.getInfo();
		facets.add(fd);

		return facets;
	}
	
	public IReceptacles getInfo() {
		this.infoServant = new InfoServant();

		try {
			this.info = IReceptaclesHelper.narrow(this._poa()
					.servant_to_reference(this.infoServant));
		} catch (ServantNotActive e) {
			e.printStackTrace();
		} catch (WrongPolicy e) {
			e.printStackTrace();
		}
		return this.info;
	}

	private Worker getWorker() {
	      if( this.workerServant == null ) {
			try {
				this.workerServant = new WorkerServant();
				this.worker = WorkerHelper.narrow(this._poa().servant_to_reference(this.workerServant));
			} catch (ServantNotActive e) {
				e.printStackTrace();
			} catch (WrongPolicy e) {
				e.printStackTrace();
			}
		}
		return this.worker;
	}

	@Override
	protected boolean doShutdown() {
		return true;
	}

	@Override
	protected boolean doStartup() {
		return true;
	}

}

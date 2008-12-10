package scs.demos.bigtable.servant;

// teste git

import java.util.ArrayList;

import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import scs.core.FacetDescription;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.servant.IComponentServant;
import scs.demos.bigtable.Config;
import scs.demos.bigtable.ConfigHelper;
import scs.demos.bigtable.Sorter;
import scs.demos.bigtable.SorterHelper;
import scs.demos.bigtable.servant.InfoServant;

/**
 * Este componente oferece as facetas para sort do par chave/valor para
 * o seu reducer especifico, alem da interface de configuracao do proprio componente
 * @author hubert
 *
 */
public class BigTableComponent extends IComponentServant {

	private final static String IFACE_SORTER = "scs::demos::bigtable::Sorter";
	private final static String FACET_SORTER = "Sorter";
	
	private final static String IFACE_CONFIG = "scs::demos::bigtable::Config";
	private final static String FACET_CONFIG = "Config";

	private static final String FACET_INFO = "infoReceptacle";
	private static final String IFACE_INFO = "scs::core::IReceptacles";

	private SorterServant sorterServant = null;
	private Sorter sorter = null;
	private ConfigServant configServant = null;
	private Config config = null;
	private InfoServant infoServant = null;
	private IReceptacles info = null;
	
	@Override
	protected ArrayList<FacetDescription> createFacets() {
		ArrayList<FacetDescription> facets = new ArrayList<FacetDescription>();
		FacetDescription fd = new FacetDescription();
		fd.interface_name = IFACE_SORTER;
		fd.name = FACET_SORTER;
		fd.facet_ref = getSorter();
		facets.add(fd);
		
		fd = new FacetDescription();
		fd.interface_name = IFACE_CONFIG;
		fd.name = FACET_CONFIG;
		fd.facet_ref = getConfig();
		facets.add(fd);

		fd = new FacetDescription();
		fd.interface_name = IFACE_INFO;
		fd.name = FACET_INFO;
		fd.facet_ref = this.getInfo();
		facets.add(fd);

		return facets;
	}

	@Override
	protected boolean doShutdown() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean doStartup() {
		// TODO Auto-generated method stub
		return true;
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
	
	private Sorter getSorter() {
		if (this.sorterServant == null) {
			try {
				this.sorterServant = new SorterServant(this);
				this.sorter = SorterHelper.narrow(this._poa()
						.servant_to_reference(this.sorterServant));
			} catch (ServantNotActive e) {
				e.printStackTrace();
			} catch (WrongPolicy e) {
				e.printStackTrace();
			}
		}
		return this.sorter;
	}
	
	private Config getConfig() {
		if (this.configServant == null) {
			try {
				this.configServant = new ConfigServant(this);
				this.config = ConfigHelper.narrow(this._poa()
						.servant_to_reference(this.configServant));
			} catch (ServantNotActive e) {
				e.printStackTrace();
			} catch (WrongPolicy e) {
				e.printStackTrace();
			}
		}
		return this.config;
	}
}

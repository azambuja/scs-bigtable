package scs.demos.bigtable.test.servant;

import java.util.ArrayList;

import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import scs.core.FacetDescription;
import scs.core.servant.IComponentServant;
import scs.demos.bigtable.test.Reducer;
import scs.demos.bigtable.test.ReducerHelper;

public class TestComponent extends IComponentServant {
	
	private final static String IFACE_REDUCER = "scs::demos::bigtable::test::Reducer";
	private final static String FACET_REDUCER = "Reducer";
	
	private ReducerServant reducerServant = null;
	private Reducer reducer = null;
	

	@Override
	protected ArrayList<FacetDescription> createFacets() {
		ArrayList<FacetDescription> facets = new ArrayList<FacetDescription>();
		FacetDescription fd = new FacetDescription();
		fd.interface_name = IFACE_REDUCER;
		fd.name = FACET_REDUCER;
		fd.facet_ref = getReducer();
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
	
	private Reducer getReducer() {
		if (this.reducerServant == null) {
			try {
				this.reducerServant = new ReducerServant(this);
				this.reducer = ReducerHelper.narrow(this._poa()
						.servant_to_reference(this.reducerServant));
			} catch (ServantNotActive e) {
				e.printStackTrace();
			} catch (WrongPolicy e) {
				e.printStackTrace();
			}
		}
		return this.reducer;
	}

}

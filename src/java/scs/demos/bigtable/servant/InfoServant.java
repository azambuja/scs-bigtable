package scs.demos.bigtable.servant;

import java.util.ArrayList;

import org.omg.CORBA.Object;

import scs.core.servant.IReceptaclesServant;
import scs.core.servant.Receptacle;

public class InfoServant extends IReceptaclesServant {

	@Override
	protected ArrayList<Receptacle> createReceptacles() {
		ArrayList<Receptacle> receptacles = new ArrayList<Receptacle>();

		Receptacle receptacle = new Receptacle("Reducer", "scs::demos::mapreduce::Reducer", true);
		receptacles.add(receptacle);

		return receptacles;
	}

	@Override
	protected int getConnectionLimit() {
		return 10;
	}

	@Override
	protected boolean isValidConnection(Object obj) {
		return true;
	}

}


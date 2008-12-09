package scs.demos.bigtable.servant;

import java.util.HashMap;

import scs.core.ConnectionDescription;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.InvalidName;
import scs.demos.bigtable.SorterPOA;
import scs.demos.bigtable.test.Reducer;

/**
 * 
 * Um sorter deve se conectar a um ou mais mappers e a todos os reducers.
 * Atraves de um hash consistente, conhecendo-se o numero total de reducers,
 * um sorter deve escolher sempre o mesmo reducer para dado valor de chave.
 * @author hubert
 *
 */
public class SorterServant extends SorterPOA {

	private BigTableComponent component;
	
	boolean started = false;
	ConnectionDescription conns[];
	private HashMap<Integer, Integer> groups; // former int defines char, latter defines the group

	public SorterServant(BigTableComponent component) {
		this.component = component;
	}

	@Override
	public void sort(String key, String values) {

		if (!started)
			start();
		
		// Passo direto cada chave par,valor para o reducer
		// deveria bufferizar?

		char ch = key.charAt(0);
		int i = groups.get(new Integer(ch)).intValue();
		
		System.out.println("enviando chave " + key + " para reducer " + i);
		
		if (conns[i].objref != null) {
			Reducer reducer = (Reducer)conns[i].objref;
			reducer.reduce(key, values);
		}

	}

	@Override
	public void start() {
		groups = new HashMap<Integer,Integer>();
		
		try {
			IReceptacles bigTableReceptacles = IReceptaclesHelper.narrow(component.getFacetByName("infoReceptacle"));
			conns = bigTableReceptacles.getConnections("Reducer");
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String constellation = "abcdefghijklmnopqrstuvwxyz0123456789";
		int symbols = constellation.length();
		int reducers = conns.length;
		
		for (int i = 0; i < constellation.length(); i++) {
			groups.put(new Integer(constellation.charAt(i)), (symbols / ((i > 0)?i:1) ) % reducers);
		}
		
		started = true;
	}

}

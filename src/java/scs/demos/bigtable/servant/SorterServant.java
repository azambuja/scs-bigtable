package scs.demos.bigtable.servant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.omg.CORBA.Any;

import scs.core.ConnectionDescription;
import scs.demos.bigtable.IteratorHolder;
import scs.demos.bigtable.KeysHolder;
import scs.demos.bigtable.SorterPOA;

/**
 * 
 * @author hubert
 *
 */
public class SorterServant extends SorterPOA {

	private BigTableComponent component;
	
	boolean started = false;
	ConnectionDescription conns[];
//	private HashMap<Integer, Integer> groups; // former int defines char, latter defines the group

	private HashMap<Any, ArrayList<Any>> rows = null;
	
	
	public SorterServant(BigTableComponent component) {
		this.component = component;
	}
	
	@Override
	public void get(Any key, IteratorHolder values) {
		// TODO Auto-generated method stub
		System.out.println("get called with key " + key.extract_string());
		
	}

	@Override
	public void put(Any key, Any value) {
		if (rows == null)
			rows = new HashMap<Any, ArrayList<Any>>();
		
		ArrayList<Any> values = rows.get(key);
		if (values == null)
			values = new ArrayList<Any>();
		
		values.add(value);
		
		rows.put(key, values);
		
		System.out.println("key: " + key.extract_string());
	}

	@Override
	public void getKeysOnRange(int reducerId, int numReducers,
			KeysHolder keys) {
		if (rows != null) {
			Set<Entry<Any,ArrayList<Any>>> keySet = rows.entrySet();
			
			ArrayList<String> keysArray = new ArrayList<String>();
			Iterator<Entry<Any,ArrayList<Any>>> it = keySet.iterator();
			while (it.hasNext()) {
				Entry<Any,ArrayList<Any>> entry = it.next();
				keysArray.add(entry.getKey().extract_string());
			}
			
			if (keysArray != null && keysArray.size() > 0)
				keys.value = keysArray.toArray(new String[keysArray.size()]);
		}	
	}

//	@Override
//	public void put(Any key, Any value) {
//		if (!started)
//			start();
		
		// Passo direto cada chave par,valor para o reducer
		// deveria bufferizar?
//
//		char ch = key.extract_string().charAt(0);
//		int i = 0;
//		try {
//			i = groups.get(new Integer(ch)).intValue();
//		}
//		catch (NumberFormatException e) {}
		
		
//		System.out.println("enviando chave " + key + " para reducer " + i);
			
//			if (conns[i].objref != null) {
//				Reducer reducer = (Reducer)conns[i].objref;
////				try {
//////					reducer.reduce(key, value);
////				} catch (IOMapReduceException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
//		
//	}

//	@Override
//	public void start() {
//		groups = new HashMap<Integer,Integer>();
//		
//		try {
//			IReceptacles bigTableReceptacles = IReceptaclesHelper.narrow(component.getFacetByName("infoReceptacle"));
//			conns = bigTableReceptacles.getConnections("Reducer");
//		} catch (InvalidName e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String constellation = "abcdefghijklmnopqrstuvwxyz0123456789";
//		int symbols = constellation.length();
//		int reducers = conns.length;
//		
//		for (int i = 0; i < constellation.length(); i++) {
//			groups.put(new Integer(constellation.charAt(i)), (symbols / ((i > 0)?i:1) ) % reducers);
//		}
//		
//		started = true;
//	}

}

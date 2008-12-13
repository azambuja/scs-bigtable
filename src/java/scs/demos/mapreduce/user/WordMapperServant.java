package scs.demos.mapreduce.user;

import org.omg.CORBA.Any;

import scs.demos.bigtable.Sorter;
import scs.demos.mapreduce.IOMapReduceException;
import scs.demos.mapreduce.MapperPOA;
import scs.demos.mapreduce.OutputCollector;
import scs.demos.mapreduce.Reporter;
import scs.demos.mapreduce.schedule.LogError;


/**
 * mapper utilizando o big table
 * @author hubert
 */

public class WordMapperServant extends MapperPOA {

	public void map(Any key, Any value, OutputCollector collector, Reporter reporter, Sorter sorter) throws IOMapReduceException {
		try {
			String s1 = value.extract_string();
			key.insert_string(s1);
			value.insert_string("1");
			sorter.put(key, value);
		} catch (Exception e) {
			String exception = LogError.getStackTrace(e);
			reporter.report(0,"WordMapperServant::map - " + exception);
			throw new IOMapReduceException();
		}
	}
}

package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/OutputCollectorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Usado por mappers and reducers para emitir pares <key,value> intermediarios
public interface OutputCollectorOperations 
{
  void collect (org.omg.CORBA.Any key, org.omg.CORBA.Any value) throws scs.demos.mapreduce.IOMapReduceException;
  void flush () throws scs.demos.mapreduce.IOMapReduceException;
  void close () throws scs.demos.mapreduce.IOMapReduceException;
} // interface OutputCollectorOperations

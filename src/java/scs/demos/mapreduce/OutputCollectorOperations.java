package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/OutputCollectorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


//Usado por mappers and reducers para emitir pares <key,value> intermediarios
public interface OutputCollectorOperations 
{
  void collect (org.omg.CORBA.Any key, org.omg.CORBA.Any value) throws scs.demos.mapreduce.IOMapReduceException;
  void flush () throws scs.demos.mapreduce.IOMapReduceException;
  void close () throws scs.demos.mapreduce.IOMapReduceException;
} // interface OutputCollectorOperations

package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/RecordWriterOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


//Define operacoes para escrever pares <key, value>
public interface RecordWriterOperations 
{
  void open (String confFileName, scs.demos.mapreduce.FileSplit fileSplit, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.IOMapReduceException;
  boolean write (org.omg.CORBA.Any key, org.omg.CORBA.Any value) throws scs.demos.mapreduce.IOMapReduceException;
  void close () throws scs.demos.mapreduce.IOMapReduceException;
  scs.demos.mapreduce.FileSplit getFileSplit ();
} // interface RecordWriterOperations

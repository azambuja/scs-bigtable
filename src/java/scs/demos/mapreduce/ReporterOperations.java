package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/ReporterOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


//Reporta log de mensagens de operacoes
public interface ReporterOperations 
{
  boolean open ();
  void report (int level, String message);
  void close ();
} // interface ReporterOperations

package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/PartitionerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


//Define a operacao para distribuir chaves para os reducers
public interface PartitionerOperations 
{
  int getPartition (org.omg.CORBA.Any key, org.omg.CORBA.Any value, int numPartitions);
} // interface PartitionerOperations

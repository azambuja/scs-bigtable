package scs.reasoning;


/**
* scs/reasoning/ReasoningOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public interface ReasoningOperations 
{
  void buildModel (String fileName) throws scs.reasoning.BuildClassifierException;
  String adjudicator (String[] metricsToLabel);
} // interface ReasoningOperations

package scs.auxiliar;


/**
* scs/auxiliar/ComponentPropertiesOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public interface ComponentPropertiesOperations 
{
  void setProperty (scs.execution_node.Property property) throws scs.auxiliar.ReadOnlyProperty;
  scs.execution_node.Property getProperty (String name) throws scs.auxiliar.UndefinedProperty;
  scs.execution_node.Property[] getProperties ();
} // interface ComponentPropertiesOperations

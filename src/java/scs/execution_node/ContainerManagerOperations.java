package scs.execution_node;


/**
* scs/execution_node/ContainerManagerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public interface ContainerManagerOperations 
{
  void registerContainer (String name, scs.core.IComponent ctr) throws scs.execution_node.ContainerAlreadyExists, scs.execution_node.InvalidContainer;
  void unregisterContainer (String name) throws scs.core.InvalidName;
} // interface ContainerManagerOperations
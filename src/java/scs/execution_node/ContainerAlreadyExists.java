package scs.execution_node;


/**
* scs/execution_node/ContainerAlreadyExists.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ContainerAlreadyExists extends org.omg.CORBA.UserException
{

  public ContainerAlreadyExists ()
  {
    super(ContainerAlreadyExistsHelper.id());
  } // ctor


  public ContainerAlreadyExists (String $reason)
  {
    super(ContainerAlreadyExistsHelper.id() + "  " + $reason);
  } // ctor

} // class ContainerAlreadyExists

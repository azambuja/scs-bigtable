package scs.container;


/**
* scs/container/ContainerHalted.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ContainerHalted extends org.omg.CORBA.UserException
{

  public ContainerHalted ()
  {
    super(ContainerHaltedHelper.id());
  } // ctor


  public ContainerHalted (String $reason)
  {
    super(ContainerHaltedHelper.id() + "  " + $reason);
  } // ctor

} // class ContainerHalted

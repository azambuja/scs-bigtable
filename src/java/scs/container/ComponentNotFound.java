package scs.container;


/**
* scs/container/ComponentNotFound.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ComponentNotFound extends org.omg.CORBA.UserException
{

  public ComponentNotFound ()
  {
    super(ComponentNotFoundHelper.id());
  } // ctor


  public ComponentNotFound (String $reason)
  {
    super(ComponentNotFoundHelper.id() + "  " + $reason);
  } // ctor

} // class ComponentNotFound

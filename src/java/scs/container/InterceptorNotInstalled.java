package scs.container;


/**
* scs/container/InterceptorNotInstalled.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public final class InterceptorNotInstalled extends org.omg.CORBA.UserException
{

  public InterceptorNotInstalled ()
  {
    super(InterceptorNotInstalledHelper.id());
  } // ctor


  public InterceptorNotInstalled (String $reason)
  {
    super(InterceptorNotInstalledHelper.id() + "  " + $reason);
  } // ctor

} // class InterceptorNotInstalled
package scs.core;


/**
* scs/core/StartupFailed.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Friday, December 12, 2008 6:43:10 PM BRST
*/

public final class StartupFailed extends org.omg.CORBA.UserException
{

  public StartupFailed ()
  {
    super(StartupFailedHelper.id());
  } // ctor


  public StartupFailed (String $reason)
  {
    super(StartupFailedHelper.id() + "  " + $reason);
  } // ctor

} // class StartupFailed

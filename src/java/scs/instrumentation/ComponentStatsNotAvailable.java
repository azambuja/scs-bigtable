package scs.instrumentation;


/**
* scs/instrumentation/ComponentStatsNotAvailable.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class ComponentStatsNotAvailable extends org.omg.CORBA.UserException
{

  public ComponentStatsNotAvailable ()
  {
    super(ComponentStatsNotAvailableHelper.id());
  } // ctor


  public ComponentStatsNotAvailable (String $reason)
  {
    super(ComponentStatsNotAvailableHelper.id() + "  " + $reason);
  } // ctor

} // class ComponentStatsNotAvailable
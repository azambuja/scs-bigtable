package scs.reasoning;


/**
* scs/reasoning/SystemStateValue.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class SystemStateValue implements org.omg.CORBA.portable.IDLEntity
{
  public boolean compliance = false;
  public scs.reasoning.MetricDescription rootCause[] = null;

  public SystemStateValue ()
  {
  } // ctor

  public SystemStateValue (boolean _compliance, scs.reasoning.MetricDescription[] _rootCause)
  {
    compliance = _compliance;
    rootCause = _rootCause;
  } // ctor

} // class SystemStateValue
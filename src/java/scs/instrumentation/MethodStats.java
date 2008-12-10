package scs.instrumentation;


/**
* scs/instrumentation/MethodStats.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class MethodStats implements org.omg.CORBA.portable.IDLEntity
{
  public String methodName = null;
  public int callsCount = (int)0;
  public long cpuTime = (long)0;
  public long elapsedTime = (long)0;

  public MethodStats ()
  {
  } // ctor

  public MethodStats (String _methodName, int _callsCount, long _cpuTime, long _elapsedTime)
  {
    methodName = _methodName;
    callsCount = _callsCount;
    cpuTime = _cpuTime;
    elapsedTime = _elapsedTime;
  } // ctor

} // class MethodStats
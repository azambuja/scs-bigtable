package scs.instrumentation;


/**
* scs/instrumentation/InterfaceStats.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Friday, December 12, 2008 6:43:13 PM BRST
*/

public final class InterfaceStats implements org.omg.CORBA.portable.IDLEntity
{
  public scs.instrumentation.MethodStats methodStatsCollection[] = null;
  public String interfaceName = null;

  public InterfaceStats ()
  {
  } // ctor

  public InterfaceStats (scs.instrumentation.MethodStats[] _methodStatsCollection, String _interfaceName)
  {
    methodStatsCollection = _methodStatsCollection;
    interfaceName = _interfaceName;
  } // ctor

} // class InterfaceStats

package scs.instrumentation;

/**
* scs/instrumentation/NetworkStatsNotAvailableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class NetworkStatsNotAvailableHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.instrumentation.NetworkStatsNotAvailable value = null;

  public NetworkStatsNotAvailableHolder ()
  {
  }

  public NetworkStatsNotAvailableHolder (scs.instrumentation.NetworkStatsNotAvailable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.instrumentation.NetworkStatsNotAvailableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.instrumentation.NetworkStatsNotAvailableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.instrumentation.NetworkStatsNotAvailableHelper.type ();
  }

}
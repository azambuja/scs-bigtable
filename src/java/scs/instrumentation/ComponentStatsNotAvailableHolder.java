package scs.instrumentation;

/**
* scs/instrumentation/ComponentStatsNotAvailableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ComponentStatsNotAvailableHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.instrumentation.ComponentStatsNotAvailable value = null;

  public ComponentStatsNotAvailableHolder ()
  {
  }

  public ComponentStatsNotAvailableHolder (scs.instrumentation.ComponentStatsNotAvailable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.instrumentation.ComponentStatsNotAvailableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.instrumentation.ComponentStatsNotAvailableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.instrumentation.ComponentStatsNotAvailableHelper.type ();
  }

}

package scs.instrumentation;


/**
* scs/instrumentation/MethodStatsSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class MethodStatsSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.instrumentation.MethodStats value[] = null;

  public MethodStatsSeqHolder ()
  {
  }

  public MethodStatsSeqHolder (scs.instrumentation.MethodStats[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.instrumentation.MethodStatsSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.instrumentation.MethodStatsSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.instrumentation.MethodStatsSeqHelper.type ();
  }

}

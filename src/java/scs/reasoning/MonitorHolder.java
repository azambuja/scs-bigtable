package scs.reasoning;

/**
* scs/reasoning/MonitorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class MonitorHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.reasoning.Monitor value = null;

  public MonitorHolder ()
  {
  }

  public MonitorHolder (scs.reasoning.Monitor initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.reasoning.MonitorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.reasoning.MonitorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.reasoning.MonitorHelper.type ();
  }

}
package scs.core;


/**
* scs/core/ComponentIdSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Wednesday, December 10, 2008 9:40:10 AM BRST
*/

public final class ComponentIdSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.core.ComponentId value[] = null;

  public ComponentIdSeqHolder ()
  {
  }

  public ComponentIdSeqHolder (scs.core.ComponentId[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.core.ComponentIdSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.core.ComponentIdSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.core.ComponentIdSeqHelper.type ();
  }

}

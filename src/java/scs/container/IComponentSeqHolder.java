package scs.container;


/**
* scs/container/IComponentSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public final class IComponentSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.core.IComponent value[] = null;

  public IComponentSeqHolder ()
  {
  }

  public IComponentSeqHolder (scs.core.IComponent[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.container.IComponentSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.container.IComponentSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.container.IComponentSeqHelper.type ();
  }

}

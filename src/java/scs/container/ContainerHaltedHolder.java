package scs.container;

/**
* scs/container/ContainerHaltedHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ContainerHaltedHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.container.ContainerHalted value = null;

  public ContainerHaltedHolder ()
  {
  }

  public ContainerHaltedHolder (scs.container.ContainerHalted initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.container.ContainerHaltedHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.container.ContainerHaltedHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.container.ContainerHaltedHelper.type ();
  }

}

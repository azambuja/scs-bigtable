package scs.demos.philosopher;

/**
* scs/demos/philosopher/ForkHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/philosopher.idl
* Wednesday, December 10, 2008 9:40:13 AM BRST
*/

public final class ForkHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.philosopher.Fork value = null;

  public ForkHolder ()
  {
  }

  public ForkHolder (scs.demos.philosopher.Fork initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.philosopher.ForkHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.philosopher.ForkHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.philosopher.ForkHelper.type ();
  }

}
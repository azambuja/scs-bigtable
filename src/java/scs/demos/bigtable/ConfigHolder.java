package scs.demos.bigtable;

/**
* scs/demos/bigtable/ConfigHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/

public final class ConfigHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.bigtable.Config value = null;

  public ConfigHolder ()
  {
  }

  public ConfigHolder (scs.demos.bigtable.Config initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.bigtable.ConfigHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.bigtable.ConfigHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.bigtable.ConfigHelper.type ();
  }

}

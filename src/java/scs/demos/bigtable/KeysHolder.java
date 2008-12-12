package scs.demos.bigtable;


/**
* scs/demos/bigtable/KeysHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Friday, December 12, 2008 6:43:15 PM BRST
*/

public final class KeysHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public KeysHolder ()
  {
  }

  public KeysHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.bigtable.KeysHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.bigtable.KeysHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.bigtable.KeysHelper.type ();
  }

}

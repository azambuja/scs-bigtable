package scs.demos.bigtable.test;

/**
* scs/demos/bigtable/test/ReducerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


// nao e pra ser string, string. Isso e so pra testar.
public final class ReducerHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.bigtable.test.Reducer value = null;

  public ReducerHolder ()
  {
  }

  public ReducerHolder (scs.demos.bigtable.test.Reducer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.bigtable.test.ReducerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.bigtable.test.ReducerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.bigtable.test.ReducerHelper.type ();
  }

}

package scs.demos.bigtable;

/**
* scs/demos/bigtable/SorterHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 6, 2008 8:01:09 PM BRST
*/

public final class SorterHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.bigtable.Sorter value = null;

  public SorterHolder ()
  {
  }

  public SorterHolder (scs.demos.bigtable.Sorter initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.bigtable.SorterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.bigtable.SorterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.bigtable.SorterHelper.type ();
  }

}

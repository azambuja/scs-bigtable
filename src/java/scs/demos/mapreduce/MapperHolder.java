package scs.demos.mapreduce;

/**
* scs/demos/mapreduce/MapperHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


// Define a operacao map
public final class MapperHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.Mapper value = null;

  public MapperHolder ()
  {
  }

  public MapperHolder (scs.demos.mapreduce.Mapper initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.MapperHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.MapperHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.MapperHelper.type ();
  }

}

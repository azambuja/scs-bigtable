package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/FileSplitsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/

public final class FileSplitsHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.FileSplit value[] = null;

  public FileSplitsHolder ()
  {
  }

  public FileSplitsHolder (scs.demos.mapreduce.FileSplit[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.FileSplitsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.FileSplitsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.FileSplitsHelper.type ();
  }

}

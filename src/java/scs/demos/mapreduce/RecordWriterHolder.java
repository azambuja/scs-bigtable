package scs.demos.mapreduce;

/**
* scs/demos/mapreduce/RecordWriterHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Define operacoes para escrever pares <key, value>
public final class RecordWriterHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.RecordWriter value = null;

  public RecordWriterHolder ()
  {
  }

  public RecordWriterHolder (scs.demos.mapreduce.RecordWriter initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.RecordWriterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.RecordWriterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.RecordWriterHelper.type ();
  }

}

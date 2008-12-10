package scs.demos.mapreduce;

/**
* scs/demos/mapreduce/OutputCollectorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Usado por mappers and reducers para emitir pares <key,value> intermediarios
public final class OutputCollectorHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.OutputCollector value = null;

  public OutputCollectorHolder ()
  {
  }

  public OutputCollectorHolder (scs.demos.mapreduce.OutputCollector initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.OutputCollectorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.OutputCollectorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.OutputCollectorHelper.type ();
  }

}
package scs.demos.mapreduce;

/**
* scs/demos/mapreduce/PropertiesExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class PropertiesExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.PropertiesException value = null;

  public PropertiesExceptionHolder ()
  {
  }

  public PropertiesExceptionHolder (scs.demos.mapreduce.PropertiesException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.PropertiesExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.PropertiesExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.PropertiesExceptionHelper.type ();
  }

}
package scs.demos.mapreduce;

/**
* scs/demos/mapreduce/ConectionToExecNodesExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class ConectionToExecNodesExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.mapreduce.ConectionToExecNodesException value = null;

  public ConectionToExecNodesExceptionHolder ()
  {
  }

  public ConectionToExecNodesExceptionHolder (scs.demos.mapreduce.ConectionToExecNodesException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.mapreduce.ConectionToExecNodesExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.mapreduce.ConectionToExecNodesExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.mapreduce.ConectionToExecNodesExceptionHelper.type ();
  }

}

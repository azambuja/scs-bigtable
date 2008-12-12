package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/WorkerInstantiationExceptionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/

abstract public class WorkerInstantiationExceptionHelper
{
  private static String  _id = "IDL:scs/demos/mapreduce/WorkerInstantiationException:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.mapreduce.WorkerInstantiationException that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.mapreduce.WorkerInstantiationException extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [0];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (scs.demos.mapreduce.WorkerInstantiationExceptionHelper.id (), "WorkerInstantiationException", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.mapreduce.WorkerInstantiationException read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.demos.mapreduce.WorkerInstantiationException value = new scs.demos.mapreduce.WorkerInstantiationException ();
    // read and discard the repository ID
    istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.mapreduce.WorkerInstantiationException value)
  {
    // write the repository ID
    ostream.write_string (id ());
  }

}

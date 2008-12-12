package scs.demos.philosopher;


/**
* scs/demos/philosopher/PhilosopherStateHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/philosopher.idl
* Friday, December 12, 2008 6:43:14 PM BRST
*/

abstract public class PhilosopherStateHelper
{
  private static String  _id = "IDL:scs/demos/philosopher/PhilosopherState:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.philosopher.PhilosopherState that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.philosopher.PhilosopherState extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (scs.demos.philosopher.PhilosopherStateHelper.id (), "PhilosopherState", new String[] { "EATING", "THINKING", "HUNGRY", "STARVING", "DEAD"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.philosopher.PhilosopherState read (org.omg.CORBA.portable.InputStream istream)
  {
    return scs.demos.philosopher.PhilosopherState.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.philosopher.PhilosopherState value)
  {
    ostream.write_long (value.value ());
  }

}

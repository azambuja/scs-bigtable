package scs.core;


/**
* scs/core/ConnectionDescriptionsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Wednesday, December 10, 2008 9:40:10 AM BRST
*/

abstract public class ConnectionDescriptionsHelper
{
  private static String  _id = "IDL:scs/core/ConnectionDescriptions:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.core.ConnectionDescription[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.core.ConnectionDescription[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = scs.core.ConnectionDescriptionHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (scs.core.ConnectionDescriptionsHelper.id (), "ConnectionDescriptions", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.core.ConnectionDescription[] read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.core.ConnectionDescription value[] = null;
    int _len0 = istream.read_long ();
    value = new scs.core.ConnectionDescription[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = scs.core.ConnectionDescriptionHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.core.ConnectionDescription[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      scs.core.ConnectionDescriptionHelper.write (ostream, value[_i0]);
  }

}

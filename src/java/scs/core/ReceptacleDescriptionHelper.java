package scs.core;


/**
* scs/core/ReceptacleDescriptionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Friday, December 12, 2008 6:43:10 PM BRST
*/

abstract public class ReceptacleDescriptionHelper
{
  private static String  _id = "IDL:scs/core/ReceptacleDescription/ReceptacleDescription:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.core.ReceptacleDescription that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.core.ReceptacleDescription extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "interface_name",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[2] = new org.omg.CORBA.StructMember (
            "is_multiplex",
            _tcOf_members0,
            null);
          _tcOf_members0 = scs.core.ConnectionDescriptionHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (scs.core.ConnectionDescriptionsHelper.id (), "ConnectionDescriptions", _tcOf_members0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "connections",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (scs.core.ReceptacleDescriptionHelper.id (), "ReceptacleDescription", _members0);
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

  public static scs.core.ReceptacleDescription read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.core.ReceptacleDescription value = new scs.core.ReceptacleDescription ();
    value.name = istream.read_string ();
    value.interface_name = istream.read_string ();
    value.is_multiplex = istream.read_boolean ();
    value.connections = scs.core.ConnectionDescriptionsHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.core.ReceptacleDescription value)
  {
    ostream.write_string (value.name);
    ostream.write_string (value.interface_name);
    ostream.write_boolean (value.is_multiplex);
    scs.core.ConnectionDescriptionsHelper.write (ostream, value.connections);
  }

}

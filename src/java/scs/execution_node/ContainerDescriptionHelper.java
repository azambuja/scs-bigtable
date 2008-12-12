package scs.execution_node;


/**
* scs/execution_node/ContainerDescriptionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

abstract public class ContainerDescriptionHelper
{
  private static String  _id = "IDL:scs/execution_node/ContainerDescription/ContainerDescription:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.execution_node.ContainerDescription that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.execution_node.ContainerDescription extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = scs.core.IComponentHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "container",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "container_name",
            _tcOf_members0,
            null);
          _tcOf_members0 = scs.core.IComponentHelper.type ();
          _members0[2] = new org.omg.CORBA.StructMember (
            "execution_node",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (scs.execution_node.ContainerDescriptionHelper.id (), "ContainerDescription", _members0);
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

  public static scs.execution_node.ContainerDescription read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.execution_node.ContainerDescription value = new scs.execution_node.ContainerDescription ();
    value.container = scs.core.IComponentHelper.read (istream);
    value.container_name = istream.read_string ();
    value.execution_node = scs.core.IComponentHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.execution_node.ContainerDescription value)
  {
    scs.core.IComponentHelper.write (ostream, value.container);
    ostream.write_string (value.container_name);
    scs.core.IComponentHelper.write (ostream, value.execution_node);
  }

}

package scs.reasoning;


/**
* scs/reasoning/DataCollectionPropertyHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

abstract public class DataCollectionPropertyHelper
{
  private static String  _id = "IDL:scs/reasoning/DataCollectionProperty/DataCollectionProperty:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.reasoning.DataCollectionProperty that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.reasoning.DataCollectionProperty extract (org.omg.CORBA.Any a)
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
            "trainingFlag",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "trainingFileName",
            _tcOf_members0,
            null);
          _tcOf_members0 = scs.core.IComponentHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (scs.container.IComponentSeqHelper.id (), "IComponentSeq", _tcOf_members0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "observablesContainers",
            _tcOf_members0,
            null);
          _tcOf_members0 = scs.instrumentation.InterfaceStatsHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (scs.instrumentation.InterfaceStatsSeqHelper.id (), "InterfaceStatsSeq", _tcOf_members0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "observablesInterfaces",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (scs.reasoning.DataCollectionPropertyHelper.id (), "DataCollectionProperty", _members0);
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

  public static scs.reasoning.DataCollectionProperty read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.reasoning.DataCollectionProperty value = new scs.reasoning.DataCollectionProperty ();
    value.trainingFlag = istream.read_string ();
    value.trainingFileName = istream.read_string ();
    value.observablesContainers = scs.container.IComponentSeqHelper.read (istream);
    value.observablesInterfaces = scs.instrumentation.InterfaceStatsSeqHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.reasoning.DataCollectionProperty value)
  {
    ostream.write_string (value.trainingFlag);
    ostream.write_string (value.trainingFileName);
    scs.container.IComponentSeqHelper.write (ostream, value.observablesContainers);
    scs.instrumentation.InterfaceStatsSeqHelper.write (ostream, value.observablesInterfaces);
  }

}

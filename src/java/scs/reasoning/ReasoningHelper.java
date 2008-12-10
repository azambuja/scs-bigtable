package scs.reasoning;


/**
* scs/reasoning/ReasoningHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

abstract public class ReasoningHelper
{
  private static String  _id = "IDL:scs/reasoning/Reasoning:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.reasoning.Reasoning that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.reasoning.Reasoning extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (scs.reasoning.ReasoningHelper.id (), "Reasoning");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.reasoning.Reasoning read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ReasoningStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.reasoning.Reasoning value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static scs.reasoning.Reasoning narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.reasoning.Reasoning)
      return (scs.reasoning.Reasoning)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.reasoning._ReasoningStub stub = new scs.reasoning._ReasoningStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static scs.reasoning.Reasoning unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.reasoning.Reasoning)
      return (scs.reasoning.Reasoning)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.reasoning._ReasoningStub stub = new scs.reasoning._ReasoningStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

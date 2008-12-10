package scs.auxiliar;


/**
* scs/auxiliar/ComponentPropertiesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

abstract public class ComponentPropertiesHelper
{
  private static String  _id = "IDL:scs/auxiliar/ComponentProperties:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.auxiliar.ComponentProperties that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.auxiliar.ComponentProperties extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (scs.auxiliar.ComponentPropertiesHelper.id (), "ComponentProperties");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.auxiliar.ComponentProperties read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ComponentPropertiesStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.auxiliar.ComponentProperties value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static scs.auxiliar.ComponentProperties narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.auxiliar.ComponentProperties)
      return (scs.auxiliar.ComponentProperties)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.auxiliar._ComponentPropertiesStub stub = new scs.auxiliar._ComponentPropertiesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static scs.auxiliar.ComponentProperties unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.auxiliar.ComponentProperties)
      return (scs.auxiliar.ComponentProperties)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.auxiliar._ComponentPropertiesStub stub = new scs.auxiliar._ComponentPropertiesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

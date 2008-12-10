package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/RecordReaderHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Define operacoes para ler pares <key, value>
abstract public class RecordReaderHelper
{
  private static String  _id = "IDL:scs/demos/mapreduce/RecordReader:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.mapreduce.RecordReader that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.mapreduce.RecordReader extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (scs.demos.mapreduce.RecordReaderHelper.id (), "RecordReader");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.mapreduce.RecordReader read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_RecordReaderStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.mapreduce.RecordReader value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static scs.demos.mapreduce.RecordReader narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.demos.mapreduce.RecordReader)
      return (scs.demos.mapreduce.RecordReader)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.demos.mapreduce._RecordReaderStub stub = new scs.demos.mapreduce._RecordReaderStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static scs.demos.mapreduce.RecordReader unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.demos.mapreduce.RecordReader)
      return (scs.demos.mapreduce.RecordReader)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.demos.mapreduce._RecordReaderStub stub = new scs.demos.mapreduce._RecordReaderStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

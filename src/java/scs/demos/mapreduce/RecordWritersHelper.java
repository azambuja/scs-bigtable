package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/RecordWritersHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/

abstract public class RecordWritersHelper
{
  private static String  _id = "IDL:scs/demos/mapreduce/RecordWriters:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.mapreduce.RecordWriter[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.mapreduce.RecordWriter[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = scs.demos.mapreduce.RecordWriterHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (scs.demos.mapreduce.RecordWritersHelper.id (), "RecordWriters", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.mapreduce.RecordWriter[] read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.demos.mapreduce.RecordWriter value[] = null;
    int _len0 = istream.read_long ();
    value = new scs.demos.mapreduce.RecordWriter[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = scs.demos.mapreduce.RecordWriterHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.mapreduce.RecordWriter[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      scs.demos.mapreduce.RecordWriterHelper.write (ostream, value[_i0]);
  }

}

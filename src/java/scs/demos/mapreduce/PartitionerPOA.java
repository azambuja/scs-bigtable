package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/PartitionerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Define a operacao para distribuir chaves para os reducers
public abstract class PartitionerPOA extends org.omg.PortableServer.Servant
 implements scs.demos.mapreduce.PartitionerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getPartition", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // scs/demos/mapreduce/Partitioner/getPartition
       {
         org.omg.CORBA.Any key = in.read_any ();
         org.omg.CORBA.Any value = in.read_any ();
         int numPartitions = in.read_long ();
         int $result = (int)0;
         $result = this.getPartition (key, value, numPartitions);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/mapreduce/Partitioner:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Partitioner _this() 
  {
    return PartitionerHelper.narrow(
    super._this_object());
  }

  public Partitioner _this(org.omg.CORBA.ORB orb) 
  {
    return PartitionerHelper.narrow(
    super._this_object(orb));
  }


} // class PartitionerPOA

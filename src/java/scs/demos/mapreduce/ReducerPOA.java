package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/ReducerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


// Define a operacao reduce
public abstract class ReducerPOA extends org.omg.PortableServer.Servant
 implements scs.demos.mapreduce.ReducerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("reduce", new java.lang.Integer (0));
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
       case 0:  // scs/demos/mapreduce/Reducer/reduce
       {
         try {
           scs.demos.mapreduce.OutputCollector collector = scs.demos.mapreduce.OutputCollectorHelper.read (in);
           scs.demos.mapreduce.Reporter reporter = scs.demos.mapreduce.ReporterHelper.read (in);
           scs.demos.bigtable.Sorter sorter = scs.demos.bigtable.SorterHelper.read (in);
           this.reduce (collector, reporter, sorter);
           out = $rh.createReply();
         } catch (scs.demos.mapreduce.IOMapReduceException $ex) {
           out = $rh.createExceptionReply ();
           scs.demos.mapreduce.IOMapReduceExceptionHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/mapreduce/Reducer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Reducer _this() 
  {
    return ReducerHelper.narrow(
    super._this_object());
  }

  public Reducer _this(org.omg.CORBA.ORB orb) 
  {
    return ReducerHelper.narrow(
    super._this_object(orb));
  }


} // class ReducerPOA

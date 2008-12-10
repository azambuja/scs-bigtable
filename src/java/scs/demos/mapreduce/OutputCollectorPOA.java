package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/OutputCollectorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Usado por mappers and reducers para emitir pares <key,value> intermediarios
public abstract class OutputCollectorPOA extends org.omg.PortableServer.Servant
 implements scs.demos.mapreduce.OutputCollectorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("collect", new java.lang.Integer (0));
    _methods.put ("flush", new java.lang.Integer (1));
    _methods.put ("close", new java.lang.Integer (2));
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
       case 0:  // scs/demos/mapreduce/OutputCollector/collect
       {
         try {
           org.omg.CORBA.Any key = in.read_any ();
           org.omg.CORBA.Any value = in.read_any ();
           this.collect (key, value);
           out = $rh.createReply();
         } catch (scs.demos.mapreduce.IOMapReduceException $ex) {
           out = $rh.createExceptionReply ();
           scs.demos.mapreduce.IOMapReduceExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // scs/demos/mapreduce/OutputCollector/flush
       {
         try {
           this.flush ();
           out = $rh.createReply();
         } catch (scs.demos.mapreduce.IOMapReduceException $ex) {
           out = $rh.createExceptionReply ();
           scs.demos.mapreduce.IOMapReduceExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // scs/demos/mapreduce/OutputCollector/close
       {
         try {
           this.close ();
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
    "IDL:scs/demos/mapreduce/OutputCollector:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public OutputCollector _this() 
  {
    return OutputCollectorHelper.narrow(
    super._this_object());
  }

  public OutputCollector _this(org.omg.CORBA.ORB orb) 
  {
    return OutputCollectorHelper.narrow(
    super._this_object(orb));
  }


} // class OutputCollectorPOA

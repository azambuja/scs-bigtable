package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/TaskPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/

public abstract class TaskPOA extends org.omg.PortableServer.Servant
 implements scs.demos.mapreduce.TaskOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getId", new java.lang.Integer (0));
    _methods.put ("setStatus", new java.lang.Integer (1));
    _methods.put ("setOutput", new java.lang.Integer (2));
    _methods.put ("getStatus", new java.lang.Integer (3));
    _methods.put ("getInput", new java.lang.Integer (4));
    _methods.put ("getOutput", new java.lang.Integer (5));
    _methods.put ("getReduceIndex", new java.lang.Integer (6));
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
       case 0:  // scs/demos/mapreduce/Task/getId
       {
         int $result = (int)0;
         $result = this.getId ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // scs/demos/mapreduce/Task/setStatus
       {
         scs.demos.mapreduce.TaskStatus status = scs.demos.mapreduce.TaskStatusHelper.read (in);
         this.setStatus (status);
         out = $rh.createReply();
         break;
       }

       case 2:  // scs/demos/mapreduce/Task/setOutput
       {
         scs.demos.mapreduce.FileSplit output[] = scs.demos.mapreduce.FileSplitsHelper.read (in);
         this.setOutput (output);
         out = $rh.createReply();
         break;
       }

       case 3:  // scs/demos/mapreduce/Task/getStatus
       {
         scs.demos.mapreduce.TaskStatus $result = null;
         $result = this.getStatus ();
         out = $rh.createReply();
         scs.demos.mapreduce.TaskStatusHelper.write (out, $result);
         break;
       }

       case 4:  // scs/demos/mapreduce/Task/getInput
       {
         scs.demos.mapreduce.FileSplit $result[] = null;
         $result = this.getInput ();
         out = $rh.createReply();
         scs.demos.mapreduce.FileSplitsHelper.write (out, $result);
         break;
       }

       case 5:  // scs/demos/mapreduce/Task/getOutput
       {
         scs.demos.mapreduce.FileSplit $result[] = null;
         $result = this.getOutput ();
         out = $rh.createReply();
         scs.demos.mapreduce.FileSplitsHelper.write (out, $result);
         break;
       }

       case 6:  // scs/demos/mapreduce/Task/getReduceIndex
       {
         int $result = (int)0;
         $result = this.getReduceIndex ();
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
    "IDL:scs/demos/mapreduce/Task:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Task _this() 
  {
    return TaskHelper.narrow(
    super._this_object());
  }

  public Task _this(org.omg.CORBA.ORB orb) 
  {
    return TaskHelper.narrow(
    super._this_object(orb));
  }


} // class TaskPOA

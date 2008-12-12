package scs.demos.philosopher;


/**
* scs/demos/philosopher/ObserverPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/philosopher.idl
* Friday, December 12, 2008 6:43:14 PM BRST
*/

public abstract class ObserverPOA extends org.omg.PortableServer.Servant
 implements scs.demos.philosopher.ObserverOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("push", new java.lang.Integer (0));
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
       case 0:  // scs/demos/philosopher/Observer/push
       {
         scs.demos.philosopher.StatusInfo info = scs.demos.philosopher.StatusInfoHelper.read (in);
         this.push (info);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/philosopher/Observer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Observer _this() 
  {
    return ObserverHelper.narrow(
    super._this_object());
  }

  public Observer _this(org.omg.CORBA.ORB orb) 
  {
    return ObserverHelper.narrow(
    super._this_object(orb));
  }


} // class ObserverPOA

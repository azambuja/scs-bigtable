package scs.demos.pingpong;


/**
* scs/demos/pingpong/PingPongPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/pingPong.idl
* Saturday, December 6, 2008 5:21:18 PM BRST
*/

public abstract class PingPongPOA extends org.omg.PortableServer.Servant
 implements scs.demos.pingpong.PingPongOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setId", new java.lang.Integer (0));
    _methods.put ("getId", new java.lang.Integer (1));
    _methods.put ("ping", new java.lang.Integer (2));
    _methods.put ("pong", new java.lang.Integer (3));
    _methods.put ("start", new java.lang.Integer (4));
    _methods.put ("stop", new java.lang.Integer (5));
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
       case 0:  // scs/demos/pingpong/PingPong/setId
       {
         int identifier = in.read_long ();
         this.setId (identifier);
         out = $rh.createReply();
         break;
       }

       case 1:  // scs/demos/pingpong/PingPong/getId
       {
         int $result = (int)0;
         $result = this.getId ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // scs/demos/pingpong/PingPong/ping
       {
         this.ping ();
         out = $rh.createReply();
         break;
       }

       case 3:  // scs/demos/pingpong/PingPong/pong
       {
         this.pong ();
         out = $rh.createReply();
         break;
       }

       case 4:  // scs/demos/pingpong/PingPong/start
       {
         this.start ();
         out = $rh.createReply();
         break;
       }

       case 5:  // scs/demos/pingpong/PingPong/stop
       {
         this.stop ();
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
    "IDL:scs/demos/pingpong/PingPong:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public PingPong _this() 
  {
    return PingPongHelper.narrow(
    super._this_object());
  }

  public PingPong _this(org.omg.CORBA.ORB orb) 
  {
    return PingPongHelper.narrow(
    super._this_object(orb));
  }


} // class PingPongPOA

package scs.event_service;


/**
* scs/event_service/EventSinkPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public abstract class EventSinkPOA extends org.omg.PortableServer.Servant
 implements scs.event_service.EventSinkOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("push", new java.lang.Integer (0));
    _methods.put ("disconnect", new java.lang.Integer (1));
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
       case 0:  // scs/event_service/EventSink/push
       {
         org.omg.CORBA.Any ev = scs.event_service.EventHelper.read (in);
         this.push (ev);
         out = $rh.createReply();
         break;
       }

       case 1:  // scs/event_service/EventSink/disconnect
       {
         this.disconnect ();
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
    "IDL:scs/event_service/EventSink:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public EventSink _this() 
  {
    return EventSinkHelper.narrow(
    super._this_object());
  }

  public EventSink _this(org.omg.CORBA.ORB orb) 
  {
    return EventSinkHelper.narrow(
    super._this_object(orb));
  }


} // class EventSinkPOA

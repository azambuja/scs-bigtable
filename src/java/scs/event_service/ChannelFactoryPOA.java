package scs.event_service;


/**
* scs/event_service/ChannelFactoryPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public abstract class ChannelFactoryPOA extends org.omg.PortableServer.Servant
 implements scs.event_service.ChannelFactoryOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("create", new java.lang.Integer (0));
    _methods.put ("destroy", new java.lang.Integer (1));
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
       case 0:  // scs/event_service/ChannelFactory/create
       {
         try {
           String name = in.read_string ();
           scs.core.IComponent $result = null;
           $result = this.create (name);
           out = $rh.createReply();
           scs.core.IComponentHelper.write (out, $result);
         } catch (scs.event_service.NameAlreadyInUse $ex) {
           out = $rh.createExceptionReply ();
           scs.event_service.NameAlreadyInUseHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // scs/event_service/ChannelFactory/destroy
       {
         try {
           String name = in.read_string ();
           this.destroy (name);
           out = $rh.createReply();
         } catch (scs.event_service.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           scs.event_service.InvalidNameHelper.write (out, $ex);
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
    "IDL:scs/event_service/ChannelFactory:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ChannelFactory _this() 
  {
    return ChannelFactoryHelper.narrow(
    super._this_object());
  }

  public ChannelFactory _this(org.omg.CORBA.ORB orb) 
  {
    return ChannelFactoryHelper.narrow(
    super._this_object(orb));
  }


} // class ChannelFactoryPOA
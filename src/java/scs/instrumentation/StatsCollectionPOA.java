package scs.instrumentation;


/**
* scs/instrumentation/StatsCollectionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.instrumentation.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public abstract class StatsCollectionPOA extends org.omg.PortableServer.Servant
 implements scs.instrumentation.StatsCollectionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getInterfaceStats", new java.lang.Integer (0));
    _methods.put ("getComponentsStats", new java.lang.Integer (1));
    _methods.put ("getContainerStats", new java.lang.Integer (2));
    _methods.put ("getIOStats", new java.lang.Integer (3));
    _methods.put ("getNetworkStats", new java.lang.Integer (4));
    _methods.put ("subscribeMethodNotification", new java.lang.Integer (5));
    _methods.put ("cancelMethodNotification", new java.lang.Integer (6));
    _methods.put ("subscribeContainerNotification", new java.lang.Integer (7));
    _methods.put ("cancelContainerNotification", new java.lang.Integer (8));
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
       case 0:  // scs/instrumentation/StatsCollection/getInterfaceStats
       {
         try {
           String interfaceName = in.read_string ();
           scs.instrumentation.MethodStats $result[] = null;
           $result = this.getInterfaceStats (interfaceName);
           out = $rh.createReply();
           scs.instrumentation.MethodStatsSeqHelper.write (out, $result);
         } catch (scs.instrumentation.InterfaceStatsNotAvailable $ex) {
           out = $rh.createExceptionReply ();
           scs.instrumentation.InterfaceStatsNotAvailableHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // scs/instrumentation/StatsCollection/getComponentsStats
       {
         try {
           scs.instrumentation.InterfaceStats $result[] = null;
           $result = this.getComponentsStats ();
           out = $rh.createReply();
           scs.instrumentation.InterfaceStatsSeqHelper.write (out, $result);
         } catch (scs.instrumentation.ComponentStatsNotAvailable $ex) {
           out = $rh.createExceptionReply ();
           scs.instrumentation.ComponentStatsNotAvailableHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // scs/instrumentation/StatsCollection/getContainerStats
       {
         scs.instrumentation.ContainerStats $result = null;
         $result = this.getContainerStats ();
         out = $rh.createReply();
         scs.instrumentation.ContainerStatsHelper.write (out, $result);
         break;
       }

       case 3:  // scs/instrumentation/StatsCollection/getIOStats
       {
         try {
           scs.instrumentation.SystemIOStats $result = null;
           $result = this.getIOStats ();
           out = $rh.createReply();
           scs.instrumentation.SystemIOStatsHelper.write (out, $result);
         } catch (scs.instrumentation.IOStatsNotAvailable $ex) {
           out = $rh.createExceptionReply ();
           scs.instrumentation.IOStatsNotAvailableHelper.write (out, $ex);
         }
         break;
       }

       case 4:  // scs/instrumentation/StatsCollection/getNetworkStats
       {
         try {
           scs.instrumentation.SystemNetworkStats $result = null;
           $result = this.getNetworkStats ();
           out = $rh.createReply();
           scs.instrumentation.SystemNetworkStatsHelper.write (out, $result);
         } catch (scs.instrumentation.NetworkStatsNotAvailable $ex) {
           out = $rh.createExceptionReply ();
           scs.instrumentation.NetworkStatsNotAvailableHelper.write (out, $ex);
         }
         break;
       }

       case 5:  // scs/instrumentation/StatsCollection/subscribeMethodNotification
       {
         String clientName = in.read_string ();
         String ifname = in.read_string ();
         String method = in.read_string ();
         scs.event_service.EventSink sink = scs.event_service.EventSinkHelper.read (in);
         boolean $result = false;
         $result = this.subscribeMethodNotification (clientName, ifname, method, sink);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // scs/instrumentation/StatsCollection/cancelMethodNotification
       {
         String clientName = in.read_string ();
         String ifname = in.read_string ();
         String method = in.read_string ();
         this.cancelMethodNotification (clientName, ifname, method);
         out = $rh.createReply();
         break;
       }

       case 7:  // scs/instrumentation/StatsCollection/subscribeContainerNotification
       {
         String clientName = in.read_string ();
         scs.event_service.EventSink sink = scs.event_service.EventSinkHelper.read (in);
         boolean $result = false;
         $result = this.subscribeContainerNotification (clientName, sink);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // scs/instrumentation/StatsCollection/cancelContainerNotification
       {
         String clientName = in.read_string ();
         this.cancelContainerNotification (clientName);
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
    "IDL:scs/instrumentation/StatsCollection:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public StatsCollection _this() 
  {
    return StatsCollectionHelper.narrow(
    super._this_object());
  }

  public StatsCollection _this(org.omg.CORBA.ORB orb) 
  {
    return StatsCollectionHelper.narrow(
    super._this_object(orb));
  }


} // class StatsCollectionPOA

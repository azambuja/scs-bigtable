package scs.event_service;


/**
* scs/event_service/ChannelManagementPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public class ChannelManagementPOATie extends ChannelManagementPOA
{

  // Constructors

  public ChannelManagementPOATie ( scs.event_service.ChannelManagementOperations delegate ) {
      this._impl = delegate;
  }
  public ChannelManagementPOATie ( scs.event_service.ChannelManagementOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.event_service.ChannelManagementOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.event_service.ChannelManagementOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public boolean subscribeChannel (String clientName, String channelName, scs.event_service.EventSink sink)
  {
    return _impl.subscribeChannel(clientName, channelName, sink);
  } // subscribeChannel

  public void cancelChannel (String clientName, String channelName)
  {
    _impl.cancelChannel(clientName, channelName);
  } // cancelChannel

  public void notifyChannel (String channelName, org.omg.CORBA.Any ev)
  {
    _impl.notifyChannel(channelName, ev);
  } // notifyChannel

  private scs.event_service.ChannelManagementOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ChannelManagementPOATie
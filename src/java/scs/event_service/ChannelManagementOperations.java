package scs.event_service;


/**
* scs/event_service/ChannelManagementOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Friday, December 12, 2008 6:43:11 PM BRST
*/

public interface ChannelManagementOperations 
{
  boolean subscribeChannel (String clientName, String channelName, scs.event_service.EventSink sink);
  void cancelChannel (String clientName, String channelName);
  void notifyChannel (String channelName, org.omg.CORBA.Any ev);
} // interface ChannelManagementOperations

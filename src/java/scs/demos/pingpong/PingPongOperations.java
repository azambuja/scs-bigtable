package scs.demos.pingpong;


/**
* scs/demos/pingpong/PingPongOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/pingPong.idl
* Saturday, December 6, 2008 5:21:18 PM BRST
*/

public interface PingPongOperations 
{
  void setId (int identifier);
  int getId ();
  void ping ();
  void pong ();
  void start ();
  void stop ();
} // interface PingPongOperations

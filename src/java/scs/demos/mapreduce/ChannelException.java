package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/ChannelException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class ChannelException extends org.omg.CORBA.UserException
{

  public ChannelException ()
  {
    super(ChannelExceptionHelper.id());
  } // ctor


  public ChannelException (String $reason)
  {
    super(ChannelExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class ChannelException

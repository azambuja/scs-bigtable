package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/IOMapReduceException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class IOMapReduceException extends org.omg.CORBA.UserException
{

  public IOMapReduceException ()
  {
    super(IOMapReduceExceptionHelper.id());
  } // ctor


  public IOMapReduceException (String $reason)
  {
    super(IOMapReduceExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class IOMapReduceException
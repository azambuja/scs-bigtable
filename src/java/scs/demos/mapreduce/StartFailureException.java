package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/StartFailureException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class StartFailureException extends org.omg.CORBA.UserException
{

  public StartFailureException ()
  {
    super(StartFailureExceptionHelper.id());
  } // ctor


  public StartFailureException (String $reason)
  {
    super(StartFailureExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class StartFailureException

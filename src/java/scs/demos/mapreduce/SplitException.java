package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/SplitException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/

public final class SplitException extends org.omg.CORBA.UserException
{

  public SplitException ()
  {
    super(SplitExceptionHelper.id());
  } // ctor


  public SplitException (String $reason)
  {
    super(SplitExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class SplitException
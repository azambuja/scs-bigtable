package scs.reasoning;


/**
* scs/reasoning/FileNotFound.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class FileNotFound extends org.omg.CORBA.UserException
{

  public FileNotFound ()
  {
    super(FileNotFoundHelper.id());
  } // ctor


  public FileNotFound (String $reason)
  {
    super(FileNotFoundHelper.id() + "  " + $reason);
  } // ctor

} // class FileNotFound

package scs.event_service;


/**
* scs/event_service/InvalidName.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public final class InvalidName extends org.omg.CORBA.UserException
{
  public String name = null;

  public InvalidName ()
  {
    super(InvalidNameHelper.id());
  } // ctor

  public InvalidName (String _name)
  {
    super(InvalidNameHelper.id());
    name = _name;
  } // ctor


  public InvalidName (String $reason, String _name)
  {
    super(InvalidNameHelper.id() + "  " + $reason);
    name = _name;
  } // ctor

} // class InvalidName
package scs.core;


/**
* scs/core/ComponentId.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Wednesday, December 10, 2008 9:40:10 AM BRST
*/

public final class ComponentId implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public int version = (int)0;

  public ComponentId ()
  {
  } // ctor

  public ComponentId (String _name, int _version)
  {
    name = _name;
    version = _version;
  } // ctor

} // class ComponentId
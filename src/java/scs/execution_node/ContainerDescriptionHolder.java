package scs.execution_node;

/**
* scs/execution_node/ContainerDescriptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public final class ContainerDescriptionHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.execution_node.ContainerDescription value = null;

  public ContainerDescriptionHolder ()
  {
  }

  public ContainerDescriptionHolder (scs.execution_node.ContainerDescription initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.execution_node.ContainerDescriptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.execution_node.ContainerDescriptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.execution_node.ContainerDescriptionHelper.type ();
  }

}
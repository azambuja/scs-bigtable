package scs.execution_node;


/**
* scs/execution_node/ContainerDescriptionSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public final class ContainerDescriptionSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.execution_node.ContainerDescription value[] = null;

  public ContainerDescriptionSeqHolder ()
  {
  }

  public ContainerDescriptionSeqHolder (scs.execution_node.ContainerDescription[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.execution_node.ContainerDescriptionSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.execution_node.ContainerDescriptionSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.execution_node.ContainerDescriptionSeqHelper.type ();
  }

}

package scs.reasoning;


/**
* scs/reasoning/DataCollectionProperty.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class DataCollectionProperty implements org.omg.CORBA.portable.IDLEntity
{
  public String trainingFlag = null;
  public String trainingFileName = null;
  public scs.core.IComponent observablesContainers[] = null;
  public scs.instrumentation.InterfaceStats observablesInterfaces[] = null;

  public DataCollectionProperty ()
  {
  } // ctor

  public DataCollectionProperty (String _trainingFlag, String _trainingFileName, scs.core.IComponent[] _observablesContainers, scs.instrumentation.InterfaceStats[] _observablesInterfaces)
  {
    trainingFlag = _trainingFlag;
    trainingFileName = _trainingFileName;
    observablesContainers = _observablesContainers;
    observablesInterfaces = _observablesInterfaces;
  } // ctor

} // class DataCollectionProperty
package scs.reasoning;


/**
* scs/reasoning/DataCollectionFailure.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Friday, December 12, 2008 6:43:13 PM BRST
*/

public final class DataCollectionFailure extends org.omg.CORBA.UserException
{

  public DataCollectionFailure ()
  {
    super(DataCollectionFailureHelper.id());
  } // ctor


  public DataCollectionFailure (String $reason)
  {
    super(DataCollectionFailureHelper.id() + "  " + $reason);
  } // ctor

} // class DataCollectionFailure

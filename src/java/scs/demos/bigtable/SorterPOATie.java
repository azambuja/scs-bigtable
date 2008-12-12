package scs.demos.bigtable;


/**
* scs/demos/bigtable/SorterPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Friday, December 12, 2008 4:48:32 PM BRST
*/

public class SorterPOATie extends SorterPOA
{

  // Constructors

  public SorterPOATie ( scs.demos.bigtable.SorterOperations delegate ) {
      this._impl = delegate;
  }
  public SorterPOATie ( scs.demos.bigtable.SorterOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.bigtable.SorterOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.bigtable.SorterOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void put (org.omg.CORBA.Any key, org.omg.CORBA.Any value)
  {
    _impl.put(key, value);
  } // put

  public void get (org.omg.CORBA.Any key, scs.demos.bigtable.IteratorHolder values)
  {
    _impl.get(key, values);
  } // get

  public void getKeysOnRange (int reducerId, int numReducers, scs.demos.bigtable.KeysHolder keys)
  {
    _impl.getKeysOnRange(reducerId, numReducers, keys);
  } // getKeysOnRange

  private scs.demos.bigtable.SorterOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class SorterPOATie

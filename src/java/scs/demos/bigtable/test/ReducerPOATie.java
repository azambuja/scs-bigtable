package scs.demos.bigtable.test;


/**
* scs/demos/bigtable/test/ReducerPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Wednesday, December 10, 2008 11:06:00 PM BRST
*/


// nao e pra ser string, string. Isso e so pra testar.
public class ReducerPOATie extends ReducerPOA
{

  // Constructors

  public ReducerPOATie ( scs.demos.bigtable.test.ReducerOperations delegate ) {
      this._impl = delegate;
  }
  public ReducerPOATie ( scs.demos.bigtable.test.ReducerOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.bigtable.test.ReducerOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.bigtable.test.ReducerOperations delegate ) {
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
  public void reduce (String key, String values)
  {
    _impl.reduce(key, values);
  } // reduce

  private scs.demos.bigtable.test.ReducerOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ReducerPOATie

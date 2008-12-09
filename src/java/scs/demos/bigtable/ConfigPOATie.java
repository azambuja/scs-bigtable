package scs.demos.bigtable;


/**
* scs/demos/bigtable/ConfigPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 6, 2008 8:01:09 PM BRST
*/

public class ConfigPOATie extends ConfigPOA
{

  // Constructors

  public ConfigPOATie ( scs.demos.bigtable.ConfigOperations delegate ) {
      this._impl = delegate;
  }
  public ConfigPOATie ( scs.demos.bigtable.ConfigOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.bigtable.ConfigOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.bigtable.ConfigOperations delegate ) {
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
  public void setName (String name)
  {
    _impl.setName(name);
  } // setName

  public void addReducer (org.omg.CORBA.Any reducer)
  {
    _impl.addReducer(reducer);
  } // addReducer

  private scs.demos.bigtable.ConfigOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ConfigPOATie

package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/MapperPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


// Define a operacao map
public class MapperPOATie extends MapperPOA
{

  // Constructors

  public MapperPOATie ( scs.demos.mapreduce.MapperOperations delegate ) {
      this._impl = delegate;
  }
  public MapperPOATie ( scs.demos.mapreduce.MapperOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.mapreduce.MapperOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.mapreduce.MapperOperations delegate ) {
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
  public void map (org.omg.CORBA.Any key, org.omg.CORBA.Any value, scs.demos.mapreduce.OutputCollector collector, scs.demos.mapreduce.Reporter reporter, scs.demos.bigtable.Sorter sorter) throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.map(key, value, collector, reporter, sorter);
  } // map

  private scs.demos.mapreduce.MapperOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class MapperPOATie

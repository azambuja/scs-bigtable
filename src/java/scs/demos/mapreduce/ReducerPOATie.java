package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/ReducerPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


// Define a operacao reduce
public class ReducerPOATie extends ReducerPOA
{

  // Constructors

  public ReducerPOATie ( scs.demos.mapreduce.ReducerOperations delegate ) {
      this._impl = delegate;
  }
  public ReducerPOATie ( scs.demos.mapreduce.ReducerOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.mapreduce.ReducerOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.mapreduce.ReducerOperations delegate ) {
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
  public void reduce (org.omg.CORBA.Any key, org.omg.CORBA.Any[] values, scs.demos.mapreduce.OutputCollector collector, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.reduce(key, values, collector, reporter);
  } // reduce

  private scs.demos.mapreduce.ReducerOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ReducerPOATie

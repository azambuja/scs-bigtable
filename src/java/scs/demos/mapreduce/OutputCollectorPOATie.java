package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/OutputCollectorPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Usado por mappers and reducers para emitir pares <key,value> intermediarios
public class OutputCollectorPOATie extends OutputCollectorPOA
{

  // Constructors

  public OutputCollectorPOATie ( scs.demos.mapreduce.OutputCollectorOperations delegate ) {
      this._impl = delegate;
  }
  public OutputCollectorPOATie ( scs.demos.mapreduce.OutputCollectorOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.mapreduce.OutputCollectorOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.mapreduce.OutputCollectorOperations delegate ) {
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
  public void collect (org.omg.CORBA.Any key, org.omg.CORBA.Any value) throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.collect(key, value);
  } // collect

  public void flush () throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.flush();
  } // flush

  public void close () throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.close();
  } // close

  private scs.demos.mapreduce.OutputCollectorOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class OutputCollectorPOATie
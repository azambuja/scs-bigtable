package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/RecordReaderPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


//Define operacoes para ler pares <key, value>
public class RecordReaderPOATie extends RecordReaderPOA
{

  // Constructors

  public RecordReaderPOATie ( scs.demos.mapreduce.RecordReaderOperations delegate ) {
      this._impl = delegate;
  }
  public RecordReaderPOATie ( scs.demos.mapreduce.RecordReaderOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.mapreduce.RecordReaderOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.mapreduce.RecordReaderOperations delegate ) {
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
  public void open (String confFileName, scs.demos.mapreduce.FileSplit fileSplit, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.open(confFileName, fileSplit, reporter);
  } // open

  public boolean next (org.omg.CORBA.AnyHolder key, org.omg.CORBA.AnyHolder value) throws scs.demos.mapreduce.IOMapReduceException
  {
    return _impl.next(key, value);
  } // next

  public void close () throws scs.demos.mapreduce.IOMapReduceException
  {
    _impl.close();
  } // close

  public scs.demos.mapreduce.FileSplit getFileSplit ()
  {
    return _impl.getFileSplit();
  } // getFileSplit

  private scs.demos.mapreduce.RecordReaderOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class RecordReaderPOATie
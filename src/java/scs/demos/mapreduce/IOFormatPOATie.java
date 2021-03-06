package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/IOFormatPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/


//Descreve a entrada-saida do processo mapreduce
public class IOFormatPOATie extends IOFormatPOA
{

  // Constructors

  public IOFormatPOATie ( scs.demos.mapreduce.IOFormatOperations delegate ) {
      this._impl = delegate;
  }
  public IOFormatPOATie ( scs.demos.mapreduce.IOFormatOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public scs.demos.mapreduce.IOFormatOperations _delegate() {
      return this._impl;
  }
  public void _delegate (scs.demos.mapreduce.IOFormatOperations delegate ) {
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
  public scs.demos.mapreduce.RecordReader getRecordReader (scs.demos.mapreduce.TaskStatus status) throws scs.demos.mapreduce.IOFormatException
  {
    return _impl.getRecordReader(status);
  } // getRecordReader

  public scs.demos.mapreduce.RecordWriter getRecordWriter (scs.demos.mapreduce.TaskStatus status) throws scs.demos.mapreduce.IOFormatException
  {
    return _impl.getRecordWriter(status);
  } // getRecordWriter

  public scs.demos.mapreduce.FileSplit[] getSplits (String confFileName, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.SplitException
  {
    return _impl.getSplits(confFileName, reporter);
  } // getSplits

  private scs.demos.mapreduce.IOFormatOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class IOFormatPOATie

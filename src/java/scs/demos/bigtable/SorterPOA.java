package scs.demos.bigtable;


/**
* scs/demos/bigtable/SorterPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/

public abstract class SorterPOA extends org.omg.PortableServer.Servant
 implements scs.demos.bigtable.SorterOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("put", new java.lang.Integer (0));
    _methods.put ("get", new java.lang.Integer (1));
    _methods.put ("getEntriesOnRange", new java.lang.Integer (2));
    _methods.put ("setNumberOfReducers", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // scs/demos/bigtable/Sorter/put
       {
         org.omg.CORBA.Any key = in.read_any ();
         org.omg.CORBA.Any value = in.read_any ();
         this.put (key, value);
         out = $rh.createReply();
         break;
       }

       case 1:  // scs/demos/bigtable/Sorter/get
       {
         org.omg.CORBA.Any key = in.read_any ();
         scs.demos.bigtable.IteratorHolder values = new scs.demos.bigtable.IteratorHolder ();
         this.get (key, values);
         out = $rh.createReply();
         scs.demos.bigtable.IteratorHelper.write (out, values.value);
         break;
       }


  //void getKeysOnRange(in long reducerId, out Keys keys);
       case 2:  // scs/demos/bigtable/Sorter/getEntriesOnRange
       {
         scs.demos.bigtable.AllEntriesHolder allEntries = new scs.demos.bigtable.AllEntriesHolder ();
         this.getEntriesOnRange (allEntries);
         out = $rh.createReply();
         scs.demos.bigtable.AllEntriesHelper.write (out, allEntries.value);
         break;
       }

       case 3:  // scs/demos/bigtable/Sorter/setNumberOfReducers
       {
         int numReducers = in.read_long ();
         this.setNumberOfReducers (numReducers);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/bigtable/Sorter:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Sorter _this() 
  {
    return SorterHelper.narrow(
    super._this_object());
  }

  public Sorter _this(org.omg.CORBA.ORB orb) 
  {
    return SorterHelper.narrow(
    super._this_object(orb));
  }


} // class SorterPOA

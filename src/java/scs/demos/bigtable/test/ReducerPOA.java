package scs.demos.bigtable.test;


/**
* scs/demos/bigtable/test/ReducerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Wednesday, December 10, 2008 11:06:00 PM BRST
*/


// nao e pra ser string, string. Isso e so pra testar.
public abstract class ReducerPOA extends org.omg.PortableServer.Servant
 implements scs.demos.bigtable.test.ReducerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("reduce", new java.lang.Integer (0));
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
       case 0:  // scs/demos/bigtable/test/Reducer/reduce
       {
         String key = in.read_string ();
         String values = in.read_string ();
         this.reduce (key, values);
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
    "IDL:scs/demos/bigtable/test/Reducer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Reducer _this() 
  {
    return ReducerHelper.narrow(
    super._this_object());
  }

  public Reducer _this(org.omg.CORBA.ORB orb) 
  {
    return ReducerHelper.narrow(
    super._this_object(orb));
  }


} // class ReducerPOA

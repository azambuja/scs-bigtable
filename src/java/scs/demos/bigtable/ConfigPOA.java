package scs.demos.bigtable;


/**
* scs/demos/bigtable/ConfigPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Wednesday, December 10, 2008 11:06:00 PM BRST
*/

public abstract class ConfigPOA extends org.omg.PortableServer.Servant
 implements scs.demos.bigtable.ConfigOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setName", new java.lang.Integer (0));
    _methods.put ("addReducer", new java.lang.Integer (1));
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
       case 0:  // scs/demos/bigtable/Config/setName
       {
         String name = in.read_string ();
         this.setName (name);
         out = $rh.createReply();
         break;
       }

       case 1:  // scs/demos/bigtable/Config/addReducer
       {
         org.omg.CORBA.Any reducer = in.read_any ();
         this.addReducer (reducer);
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
    "IDL:scs/demos/bigtable/Config:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Config _this() 
  {
    return ConfigHelper.narrow(
    super._this_object());
  }

  public Config _this(org.omg.CORBA.ORB orb) 
  {
    return ConfigHelper.narrow(
    super._this_object(orb));
  }


} // class ConfigPOA

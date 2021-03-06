package scs.auxiliar;


/**
* scs/auxiliar/_ComponentPropertiesStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public class _ComponentPropertiesStub extends org.omg.CORBA.portable.ObjectImpl implements scs.auxiliar.ComponentProperties
{

  public void setProperty (scs.execution_node.Property property) throws scs.auxiliar.ReadOnlyProperty
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setProperty", true);
                scs.execution_node.PropertyHelper.write ($out, property);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/auxiliar/ReadOnlyProperty:1.0"))
                    throw scs.auxiliar.ReadOnlyPropertyHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setProperty (property        );
            } finally {
                _releaseReply ($in);
            }
  } // setProperty

  public scs.execution_node.Property getProperty (String name) throws scs.auxiliar.UndefinedProperty
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getProperty", true);
                $out.write_string (name);
                $in = _invoke ($out);
                scs.execution_node.Property $result = scs.execution_node.PropertyHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/auxiliar/UndefinedProperty:1.0"))
                    throw scs.auxiliar.UndefinedPropertyHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getProperty (name        );
            } finally {
                _releaseReply ($in);
            }
  } // getProperty

  public scs.execution_node.Property[] getProperties ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getProperties", true);
                $in = _invoke ($out);
                scs.execution_node.Property $result[] = scs.execution_node.PropertySeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getProperties (        );
            } finally {
                _releaseReply ($in);
            }
  } // getProperties

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/auxiliar/ComponentProperties:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _ComponentPropertiesStub

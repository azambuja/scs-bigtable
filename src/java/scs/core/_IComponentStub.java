package scs.core;


/**
* scs/core/_IComponentStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/scs.idl
* Wednesday, December 10, 2008 9:40:10 AM BRST
*/

public class _IComponentStub extends org.omg.CORBA.portable.ObjectImpl implements scs.core.IComponent
{

  public void startup () throws scs.core.StartupFailed
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("startup", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/core/StartupFailed:1.0"))
                    throw scs.core.StartupFailedHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                startup (        );
            } finally {
                _releaseReply ($in);
            }
  } // startup

  public void shutdown () throws scs.core.ShutdownFailed
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("shutdown", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/core/ShutdownFailed:1.0"))
                    throw scs.core.ShutdownFailedHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                shutdown (        );
            } finally {
                _releaseReply ($in);
            }
  } // shutdown

  public org.omg.CORBA.Object getFacet (String facet_interface)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getFacet", true);
                $out.write_string (facet_interface);
                $in = _invoke ($out);
                org.omg.CORBA.Object $result = org.omg.CORBA.ObjectHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getFacet (facet_interface        );
            } finally {
                _releaseReply ($in);
            }
  } // getFacet

  public org.omg.CORBA.Object getFacetByName (String facet)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getFacetByName", true);
                $out.write_string (facet);
                $in = _invoke ($out);
                org.omg.CORBA.Object $result = org.omg.CORBA.ObjectHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getFacetByName (facet        );
            } finally {
                _releaseReply ($in);
            }
  } // getFacetByName

  public scs.core.ComponentId getComponentId ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getComponentId", true);
                $in = _invoke ($out);
                scs.core.ComponentId $result = scs.core.ComponentIdHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getComponentId (        );
            } finally {
                _releaseReply ($in);
            }
  } // getComponentId

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/core/IComponent:1.0"};

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
} // class _IComponentStub

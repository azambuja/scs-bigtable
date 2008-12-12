package scs.container;


/**
* scs/container/_ComponentInterceptionStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public class _ComponentInterceptionStub extends org.omg.CORBA.portable.ObjectImpl implements scs.container.ComponentInterception
{


  // The same goes for positions above the list's current size.
  public scs.container.ComponentHandle loadInterceptor (scs.core.ComponentId id, String[] args, int position, String type) throws scs.container.ListLockFail, scs.container.ComponentNotFound, scs.container.ComponentAlreadyLoaded, scs.container.LoadFailure
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("loadInterceptor", true);
                scs.core.ComponentIdHelper.write ($out, id);
                scs.container.StringSeqHelper.write ($out, args);
                $out.write_ulong (position);
                $out.write_string (type);
                $in = _invoke ($out);
                scs.container.ComponentHandle $result = scs.container.ComponentHandleHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/container/ListLockFail:1.0"))
                    throw scs.container.ListLockFailHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ComponentNotFound:1.0"))
                    throw scs.container.ComponentNotFoundHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ComponentAlreadyLoaded:1.0"))
                    throw scs.container.ComponentAlreadyLoadedHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/LoadFailure:1.0"))
                    throw scs.container.LoadFailureHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return loadInterceptor (id, args, position, type        );
            } finally {
                _releaseReply ($in);
            }
  } // loadInterceptor

  public void unloadInterceptor (scs.container.ComponentHandle handle) throws scs.container.InterceptorNotInstalled, scs.container.ListLockFail, scs.container.ComponentNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unloadInterceptor", true);
                scs.container.ComponentHandleHelper.write ($out, handle);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/container/InterceptorNotInstalled:1.0"))
                    throw scs.container.InterceptorNotInstalledHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ListLockFail:1.0"))
                    throw scs.container.ListLockFailHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ComponentNotFound:1.0"))
                    throw scs.container.ComponentNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unloadInterceptor (handle        );
            } finally {
                _releaseReply ($in);
            }
  } // unloadInterceptor

  public void changePosition (int instance_id, int position) throws scs.container.InterceptorNotInstalled, scs.container.ListLockFail, scs.container.ComponentNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("changePosition", true);
                $out.write_ulong (instance_id);
                $out.write_ulong (position);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/container/InterceptorNotInstalled:1.0"))
                    throw scs.container.InterceptorNotInstalledHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ListLockFail:1.0"))
                    throw scs.container.ListLockFailHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ComponentNotFound:1.0"))
                    throw scs.container.ComponentNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                changePosition (instance_id, position        );
            } finally {
                _releaseReply ($in);
            }
  } // changePosition

  public int getInterceptorPosition (int instance_id) throws scs.container.InterceptorNotInstalled, scs.container.ListLockFail, scs.container.ComponentNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getInterceptorPosition", true);
                $out.write_ulong (instance_id);
                $in = _invoke ($out);
                int $result = $in.read_ulong ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/container/InterceptorNotInstalled:1.0"))
                    throw scs.container.InterceptorNotInstalledHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ListLockFail:1.0"))
                    throw scs.container.ListLockFailHelper.read ($in);
                else if (_id.equals ("IDL:scs/container/ComponentNotFound:1.0"))
                    throw scs.container.ComponentNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getInterceptorPosition (instance_id        );
            } finally {
                _releaseReply ($in);
            }
  } // getInterceptorPosition

  public int[] getClientInterceptorsOrder ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getClientInterceptorsOrder", true);
                $in = _invoke ($out);
                int $result[] = scs.container.InterceptorIdsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getClientInterceptorsOrder (        );
            } finally {
                _releaseReply ($in);
            }
  } // getClientInterceptorsOrder

  public int[] getServerInterceptorsOrder ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getServerInterceptorsOrder", true);
                $in = _invoke ($out);
                int $result[] = scs.container.InterceptorIdsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getServerInterceptorsOrder (        );
            } finally {
                _releaseReply ($in);
            }
  } // getServerInterceptorsOrder

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/container/ComponentInterception:1.0"};

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
} // class _ComponentInterceptionStub

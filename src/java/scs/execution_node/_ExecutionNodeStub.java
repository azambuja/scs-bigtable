package scs.execution_node;


/**
* scs/execution_node/_ExecutionNodeStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Wednesday, December 10, 2008 9:40:11 AM BRST
*/

public class _ExecutionNodeStub extends org.omg.CORBA.portable.ObjectImpl implements scs.execution_node.ExecutionNode
{

  public scs.core.IComponent startContainer (String container_name, scs.execution_node.Property[] props) throws scs.execution_node.ContainerAlreadyExists, scs.execution_node.InvalidProperty
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("startContainer", true);
                $out.write_string (container_name);
                scs.execution_node.PropertySeqHelper.write ($out, props);
                $in = _invoke ($out);
                scs.core.IComponent $result = scs.core.IComponentHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/execution_node/ContainerAlreadyExists:1.0"))
                    throw scs.execution_node.ContainerAlreadyExistsHelper.read ($in);
                else if (_id.equals ("IDL:scs/execution_node/InvalidProperty:1.0"))
                    throw scs.execution_node.InvalidPropertyHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return startContainer (container_name, props        );
            } finally {
                _releaseReply ($in);
            }
  } // startContainer

  public void stopContainer (String container_name) throws scs.core.InvalidName
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("stopContainer", true);
                $out.write_string (container_name);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/core/InvalidName:1.0"))
                    throw scs.core.InvalidNameHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                stopContainer (container_name        );
            } finally {
                _releaseReply ($in);
            }
  } // stopContainer

  public scs.core.IComponent getContainer (String container_name)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getContainer", true);
                $out.write_string (container_name);
                $in = _invoke ($out);
                scs.core.IComponent $result = scs.core.IComponentHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getContainer (container_name        );
            } finally {
                _releaseReply ($in);
            }
  } // getContainer

  public scs.execution_node.ContainerDescription[] getContainers ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getContainers", true);
                $in = _invoke ($out);
                scs.execution_node.ContainerDescription $result[] = scs.execution_node.ContainerDescriptionSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getContainers (        );
            } finally {
                _releaseReply ($in);
            }
  } // getContainers

  public String getName ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getName", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getName (        );
            } finally {
                _releaseReply ($in);
            }
  } // getName

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/execution_node/ExecutionNode:1.0"};

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
} // class _ExecutionNodeStub

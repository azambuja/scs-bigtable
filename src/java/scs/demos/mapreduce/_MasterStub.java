package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/_MasterStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Friday, December 12, 2008 6:43:16 PM BRST
*/

public class _MasterStub extends org.omg.CORBA.portable.ObjectImpl implements scs.demos.mapreduce.Master
{

  public void start (String confFileName, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.PropertiesException, scs.demos.mapreduce.ConectionToExecNodesException, scs.demos.mapreduce.ChannelException, scs.demos.mapreduce.WorkerInstantiationException, scs.demos.mapreduce.TaskInstantiationException, scs.demos.mapreduce.StartFailureException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("start", true);
                $out.write_string (confFileName);
                scs.demos.mapreduce.ReporterHelper.write ($out, reporter);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/demos/mapreduce/PropertiesException:1.0"))
                    throw scs.demos.mapreduce.PropertiesExceptionHelper.read ($in);
                else if (_id.equals ("IDL:scs/demos/mapreduce/ConectionToExecNodesException:1.0"))
                    throw scs.demos.mapreduce.ConectionToExecNodesExceptionHelper.read ($in);
                else if (_id.equals ("IDL:scs/demos/mapreduce/ChannelException:1.0"))
                    throw scs.demos.mapreduce.ChannelExceptionHelper.read ($in);
                else if (_id.equals ("IDL:scs/demos/mapreduce/WorkerInstantiationException:1.0"))
                    throw scs.demos.mapreduce.WorkerInstantiationExceptionHelper.read ($in);
                else if (_id.equals ("IDL:scs/demos/mapreduce/TaskInstantiationException:1.0"))
                    throw scs.demos.mapreduce.TaskInstantiationExceptionHelper.read ($in);
                else if (_id.equals ("IDL:scs/demos/mapreduce/StartFailureException:1.0"))
                    throw scs.demos.mapreduce.StartFailureExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                start (confFileName, reporter        );
            } finally {
                _releaseReply ($in);
            }
  } // start

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/mapreduce/Master:1.0"};

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
} // class _MasterStub

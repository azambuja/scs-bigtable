package scs.demos.mapreduce;


/**
* scs/demos/mapreduce/_ReducerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/mapReduce.idl
* Wednesday, December 10, 2008 9:40:14 AM BRST
*/


// Define a operacao reduce
public class _ReducerStub extends org.omg.CORBA.portable.ObjectImpl implements scs.demos.mapreduce.Reducer
{

  public void reduce (org.omg.CORBA.Any key, org.omg.CORBA.Any[] values, scs.demos.mapreduce.OutputCollector collector, scs.demos.mapreduce.Reporter reporter) throws scs.demos.mapreduce.IOMapReduceException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("reduce", true);
                $out.write_any (key);
                scs.demos.mapreduce.IteratorHelper.write ($out, values);
                scs.demos.mapreduce.OutputCollectorHelper.write ($out, collector);
                scs.demos.mapreduce.ReporterHelper.write ($out, reporter);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:scs/demos/mapreduce/IOMapReduceException:1.0"))
                    throw scs.demos.mapreduce.IOMapReduceExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                reduce (key, values, collector, reporter        );
            } finally {
                _releaseReply ($in);
            }
  } // reduce

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/demos/mapreduce/Reducer:1.0"};

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
} // class _ReducerStub

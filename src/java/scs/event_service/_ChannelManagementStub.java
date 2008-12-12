package scs.event_service;


/**
* scs/event_service/_ChannelManagementStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/events.idl
* Friday, December 12, 2008 6:43:11 PM BRST
*/

public class _ChannelManagementStub extends org.omg.CORBA.portable.ObjectImpl implements scs.event_service.ChannelManagement
{

  public boolean subscribeChannel (String clientName, String channelName, scs.event_service.EventSink sink)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subscribeChannel", true);
                $out.write_string (clientName);
                $out.write_string (channelName);
                scs.event_service.EventSinkHelper.write ($out, sink);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return subscribeChannel (clientName, channelName, sink        );
            } finally {
                _releaseReply ($in);
            }
  } // subscribeChannel

  public void cancelChannel (String clientName, String channelName)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cancelChannel", true);
                $out.write_string (clientName);
                $out.write_string (channelName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                cancelChannel (clientName, channelName        );
            } finally {
                _releaseReply ($in);
            }
  } // cancelChannel

  public void notifyChannel (String channelName, org.omg.CORBA.Any ev)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notifyChannel", true);
                $out.write_string (channelName);
                scs.event_service.EventHelper.write ($out, ev);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                notifyChannel (channelName, ev        );
            } finally {
                _releaseReply ($in);
            }
  } // notifyChannel

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:scs/event_service/ChannelManagement:1.0"};

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
} // class _ChannelManagementStub

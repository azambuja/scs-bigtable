package scs.reasoning;


/**
* scs/reasoning/MetricDescription.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/reasoning.idl
* Wednesday, December 10, 2008 9:40:12 AM BRST
*/

public final class MetricDescription implements org.omg.CORBA.portable.IDLEntity
{
  public String metricName = null;
  public double metricValue = (double)0;

  public MetricDescription ()
  {
  } // ctor

  public MetricDescription (String _metricName, double _metricValue)
  {
    metricName = _metricName;
    metricValue = _metricValue;
  } // ctor

} // class MetricDescription
package scs.container;


/**
* scs/container/ComponentLoaderOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/deployment.idl
* Friday, December 12, 2008 6:43:12 PM BRST
*/

public interface ComponentLoaderOperations 
{
  scs.container.ComponentHandle load (scs.core.ComponentId id, String[] args) throws scs.container.ComponentNotFound, scs.container.ComponentAlreadyLoaded, scs.container.LoadFailure;
  void unload (scs.container.ComponentHandle handle) throws scs.container.ComponentNotFound;
  scs.core.ComponentId[] getInstalledComponents ();
} // interface ComponentLoaderOperations

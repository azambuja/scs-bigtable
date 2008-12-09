local oil		= require "oil"
local oo		= require "loop.base"
local comp	= require "loop.component.base"
local port	= require "loop.component.base"
local scs		= require "scs.core.base"

local orb = oil.orb or oil.init()

orb:loadidlfile("../../../../idl/hello.idl")

--------------------------------------------------------------------------------
-- Hello Facet
--------------------------------------------------------------------------------

local HelloImplementation = oo.class{}

function HelloImplementation:sayHi()
  print("Hello World!")
end

--------------------------------------------------------------------------------
-- Component Factory
--------------------------------------------------------------------------------

-- LOOP template and factory
local HelloFactory = comp.Template{
  Hello				= port.Facet,
  IComponent	= port.Facet,
}{
  Hello 		  = HelloImplementation,
  IComponent	= scs.Component,
}

local descriptions = {}
descriptions.IComponent	= {}
descriptions.Hello		  = {}

-- facet descriptions
descriptions.IComponent.name			      = "IComponent"
descriptions.IComponent.interface_name	= "IDL:scs/core/IComponent:1.0"
descriptions.Hello.name					        = "Hello"
descriptions.Hello.interface_name		    = "IDL:scs/demos/helloworld/Hello:1.0"

-- component id
componentId = { name = "Hello", version = 1.0 }

-- SCS factory
local Factory = oo.class{
  helloFactory = HelloFactory,
  descriptions = descriptions,
  componentId = componentId
}

-- Exporting
function Factory:create(arg)
  local helloInstance = scs.newComponent(self.helloFactory, self.descriptions, self.componentId)
  return helloInstance.IComponent
end

return Factory

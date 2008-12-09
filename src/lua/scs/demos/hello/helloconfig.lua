oil = require "oil"

-- OiL configuration
local orb = oil.init({host = "localhost", port = 20287})
oil.orb = orb

orb:loadidlfile("../../../../../idl/deployment.idl")
orb:loadidlfile("../../../../../idl/repository.idl")
orb:loadidlfile("../../../../../idl/hello.idl")

oil.main(function()
	local lua_name = "lua"
	local path = "../../execution_node/"
	-- assumes there's an execution node already running
	local EN = orb:newproxy(assert(oil.readfrom(path .. "execution_node.ior")))
	EN:startup()
	local enFacet = EN:getFacet("IDL:scs/execution_node/ExecutionNode:1.0")
	enFacet = orb:narrow(enFacet)

    -- creating container
	local containerName = "ComponentContainer"
	local containerPropertySeq = { { name = "language" , value = "lua", read_only = true } }
	local CC = enFacet:startContainer(containerName, containerPropertySeq)
	CC:startup()

	-- obtaining ComponentLoader facet
	local clFacet = CC:getFacet("IDL:scs/container/ComponentLoader:1.0")
	clFacet = orb:narrow(clFacet)

	-- loading component Repository
	print("loading component Repository...")
	local componentId = { name = "ComponentRepository", version = 1.0 }

	local cpnRepoHandle = clFacet:load(componentId, {})
	local CR = cpnRepoHandle.cmp

    -- starting it up and obtaining component repository facet
	CR:startup()
	local crFacet = CR:getFacet("IDL:scs/repository/ComponentRepository:1.0")
	crFacet = orb:narrow(crFacet)

	-- Installing Hello
	local componentId = { name = "Hello", version = 1.0 }
	local entry_point = "Hello1.Hello"
	local shared = true
	local helloFile = io.open("Hello.lua", "r"):read("*a")
	local helloHelpInfo = "Let´s say hi to the world!"
	local extension = "lua"

	crFacet:install(componentId, entry_point, shared, helloFile, helloHelpInfo, extension)

	-- connecting component repository to container's receptacle named ComponentRepository
	local recepFacet = CC:getFacetByName("IReceptacles")
	recepFacet = orb:narrow(recepFacet)
	local conId = recepFacet:connect("ComponentRepository", crFacet)

 	print("Finished configuration process.")

	-- loading Hello
	local helloHandle = clFacet:load(componentId, {})
	helloHandle.cmp:startup()
	local hello = helloHandle.cmp:getFacetByName("Hello")
	hello = orb:narrow(hello)
	hello:sayHi()
	print("Hello said!")
end)

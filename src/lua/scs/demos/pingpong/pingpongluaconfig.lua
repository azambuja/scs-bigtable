oil = require "oil"

-- OiL configuration
local orb = oil.init({host = "localhost", port = 20287})
oil.orb = orb

orb:loadidlfile("../../../../../idl/deployment.idl")
orb:loadidlfile("../../../../../idl/repository.idl")
orb:loadidlfile("../../../../../idl/pingPong.idl")

oil.main(function()
	local lua_name = "lua"
	local path = "../../execution_node/"
	-- creating a new Execution Node
	-- it opens a new prompt window
--[[
	os.execute("start " .. lua_name .. " " .. path .. "ExecutionNode.lua")
	oil.sleep(1)
--]]
	local EN = orb:newproxy(assert(oil.readfrom(path .. "execution_node.ior")))
	local status, err = oil.pcall(EN.startup, EN)
	if not status then
		print(err)
		return
	end

	local status, enFacet = oil.pcall(EN.getFacet, EN, "IDL:scs/execution_node/ExecutionNode:1.0")
	if not status then
		print("[PingPong] Error while calling getFacet(IDL:scs/execution_node/ExecutionNode:1.0)")
		print("[PingPong] Error: " .. enFacet)
		return
	end
	enFacet = orb:narrow(enFacet)

    -- creating container
	local containerName = "ComponentContainer"
	local containerPropertySeq = { { name = "language" , value = "lua", read_only = false }, { name = "machine", value = lua_name, read_only = false } }

	local status, CC = oil.pcall(enFacet.startContainer, enFacet, containerName, containerPropertySeq)
	if not status then
			print("[PingPong] Error while calling startContainer!")
			print("[PingPong] Error: " .. CC)
			return
	end

	CC:startup()
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
	local helpFacet = CR:getFacet("IDL:scs/auxiliar/ComponentHelp:1.0")
	helpFacet = orb:narrow(helpFacet)

	-- Installing PingPong
	local componentId = { name = "PingPong", version = 1.0 }
	local entry_point = "PingPong1.PingPong"
	local shared = true
	local ppFile = io.open("PingPong.lua", "r"):read("*a")
	local ppHelp_info = "This component pings and pongs!"
	local extension = "lua"

	crFacet:install(componentId, entry_point, shared, ppFile, ppHelp_info, extension)

	-- connecting component repository to container's receptacle named ComponentRepository
	local recepFacet = CC:getFacetByName("IReceptacles")
	recepFacet = orb:narrow(recepFacet)
	local conId = recepFacet:connect("ComponentRepository", crFacet)
	local helpConId = recepFacet:connect("ComponentHelpRecept", helpFacet)

	-- writing container ior
-- 	oil.writeto("container.ior", oil.tostring(CC))
 	print("Finished configuration process.")

	-- loading pingpongs
	local arg1 = {}
	local arg2 = {}
	table.insert(arg1, "1")
	table.insert(arg2, "2")
	local pp1Handle = clFacet:load({ name = "PingPong", version = 1.0 }, arg1)
	pp1Handle.cmp:startup()
	local pp2Handle = clFacet:load({ name = "PingPong", version = 1.0 }, arg2)
	pp2Handle.cmp:startup()
	local pp1Rec = pp1Handle.cmp:getFacetByName("IReceptacles")
	pp1Rec = orb:narrow(pp1Rec)
	local pp2Rec = pp2Handle.cmp:getFacetByName("IReceptacles")
	pp2Rec = orb:narrow(pp2Rec)
	local pp1 = pp1Handle.cmp:getFacetByName("PingPong")
	pp1 = orb:narrow(pp1)
 	local pp2 = pp2Handle.cmp:getFacetByName("PingPong")
	pp2 = orb:narrow(pp2)

	-- connecting them
	pp1Rec:connect("PingPongRec", pp2)
	pp2Rec:connect("PingPongRec", pp1)

	-- starting one pingpong
 	pp2:start()

	print("Pings and Pongs started!")
end)

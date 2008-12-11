package scs.demos.bigtable.app;

import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.SystemException;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import scs.container.ComponentAlreadyLoaded;
import scs.container.ComponentCollection;
import scs.container.ComponentCollectionHelper;
import scs.container.ComponentHandle;
import scs.container.ComponentLoader;
import scs.container.ComponentLoaderHelper;
import scs.container.ComponentNotFound;
import scs.container.LoadFailure;
import scs.core.AlreadyConnected;
import scs.core.ComponentId;
import scs.core.ExceededConnectionLimit;
import scs.core.IComponent;
import scs.core.IComponentHelper;
import scs.core.IReceptacles;
import scs.core.IReceptaclesHelper;
import scs.core.InvalidConnection;
import scs.core.InvalidName;
import scs.core.StartupFailed;
import scs.demos.bigtable.Sorter;
import scs.demos.bigtable.SorterHelper;
import scs.demos.bigtable.test.Reducer;
import scs.demos.bigtable.test.ReducerHelper;
import scs.execution_node.ContainerAlreadyExists;
import scs.execution_node.ExecutionNode;
import scs.execution_node.ExecutionNodeHelper;
import scs.execution_node.InvalidProperty;
import scs.execution_node.Property;

public class BigTableTester {

	private static final String EXEC_NODE_NAME = "ExecutionNode";
	private static final String EXEC_NODE_FACET = "scs::execution_node::ExecutionNode";
	private static final String CONTAINER_NAME = "BigTableContainer";

	private ExecutionNode execNode = null;
	private ORB orb = null;
	private POA poa = null;

	private ComponentLoader loader = null;
	private IComponent bigTableComponent = null;
	private Sorter sorter;

	private IComponent testComponent = null;
	private Reducer reducer;


	public BigTableTester(String[] args) {
		if (!initialize(args))
			System.err.println("Erro ao iniciar a aplicacao");
		System.out.println("BigTableTester inciado");


	}

	/**
	 * Cria um container no ExecutionNode
	 */
	private boolean createContainer(String name, ExecutionNode execNode) {
		try {
			Property prop = new Property();
			prop.name = "language";
			prop.value = "java";
			Property propSeq[] = { prop };
			IComponent container = execNode.startContainer(name, propSeq);

			if (container == null) {
				return false;
			}

		} catch (ContainerAlreadyExists e) {
			System.err.println("Ja existe um container com este nome.");
			return false;
		}
		catch (InvalidProperty e) {
			System.err.println("Propriedade invalida!");
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	private boolean initialize(String[] args) {
		String host= null;
		String port = null;
		String corbaname = null;

		try {
			orb = ORB.init(args, null);
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
		} catch (org.omg.CORBA.ORBPackage.InvalidName e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AdapterInactive e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("BigTableTester: Initializing..");
		
//		execNode = new ExecutionNode[1];

		//		for (int i = 0; i < execNode.length; i++) {
		host = "localhost";
		port = "1050"; 
		corbaname = "corbaname::" + host + ":" + port + "#"	+ EXEC_NODE_NAME + "-127.0.1.1";

		System.out.println("BigTableTester: Conectando ao execution node " + corbaname);
		try {
			org.omg.CORBA.Object obj = orb.string_to_object(corbaname);
			System.out.println("BigTableTester: 1 Conectando ao execution node " + corbaname);
			IComponent execNodeComp = IComponentHelper.narrow(obj);
			System.out.println("BigTableTester: 2 Conectando ao execution node " + corbaname);
			execNodeComp.startup();
			System.out.println("BigTableTester: 3 Conectando ao execution node " + corbaname);
			Object ob = execNodeComp.getFacet(EXEC_NODE_FACET);
			System.out.println("BigTableTester: 4 Conectando ao execution node " + corbaname);
			execNode = ExecutionNodeHelper.narrow(ob);
			System.out.println("BigTableTester: 5 Conectando ao execution node " + corbaname);
		} catch (SystemException ex) {
			System.err.println("Erro ao conectar com o ExecutionNode " + corbaname);
			System.exit(1);
		} catch (StartupFailed e) {
			System.err.println("Startup do ExecutionNode " + corbaname + "falhou.");
			System.exit(1);
		}

		System.out.println("BigTableTester: Connected to execution node");
		
		if (!this.createContainer(CONTAINER_NAME, execNode)) {
			System.err.println("Erro criando o container em " + corbaname);
			return false;
		}

		IComponent container;
		container = execNode.getContainer(CONTAINER_NAME);

		try {
			container.startup();
		} catch (StartupFailed e) {
			System.out.println("Erro no startup do container em " + corbaname);
			System.exit(1);
		}

		System.out.println("BigTableTester: Calling components..");

		// Instanciacao dos componentes...

		loader = ComponentLoaderHelper.narrow(container
				.getFacet("scs::container::ComponentLoader"));
		if (loader == null) {
			System.out.println("Erro ao retornar faceta loader em " + corbaname);
			return false;
		}

		Object componentCollection = container
		.getFacet("scs::container::ComponentCollection");
		ComponentCollection components = ComponentCollectionHelper
		.narrow(componentCollection);

		// Instantiate Big Table
		ComponentId bigTableCompId = new ComponentId();
		bigTableCompId.name = "BigTable";
		bigTableCompId.version = 1;

		ComponentHandle bigTableHandle = null;

		bigTableHandle = createHandle(loader, bigTableCompId);
		
		bigTableComponent = bigTableHandle.cmp;

		sorter = SorterHelper.narrow(bigTableComponent.getFacetByName("Sorter"));

		// Instantiate Test Component (future MapReduce reducer)
		ComponentId testCompId = new ComponentId();
		testCompId.name = "Test";
		testCompId.version = 1;
		
		ComponentHandle testHandle = null;
		
		int i = 0;
		while (i++ < 3) {
			// Create and connect components
			// Instanciando 3 reducers, por exemplo
			testHandle = createHandle(loader, testCompId);
			
			testComponent = testHandle.cmp;
			
			reducer = ReducerHelper.narrow(testComponent.getFacetByName("Reducer"));
	
			System.out.println("BigTableTester: Connecting components..");
	
			// Conectando os componentes...
	
			try {
				IReceptacles bigTableReceptacles = IReceptaclesHelper.narrow(bigTableComponent.getFacetByName("infoReceptacle"));
				bigTableReceptacles.connect("Reducer", reducer);
			} catch (InvalidName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidConnection e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlreadyConnected e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceededConnectionLimit e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		System.out.println("BigTableTester initialized");
		return true;
	}

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			BigTableTester app = new BigTableTester(args);

			app.run(args);

			System.out.println("Digite c para parar os componentes");
			System.out.print(">");
			while (System.in.read() != (int)'c');

			app.stop();
			long end = System.currentTimeMillis();
			System.out.println("Tempo total de execucao:" + (end - start));
		} catch (SystemException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * * @throws InterruptedException
	 * * 
	 * */
	public void run(String[] args) throws InterruptedException {
		System.out.println("iniciando aplicacao...");

		// quem deve chamar esses sort sao os mappers, pela interface Sorter
		
//		sorter.sort("a", "teste1table");
//		sorter.sort("b", "teste2table");
//		sorter.sort("c", "teste3table");
//		sorter.sort("d", "teste4table");
//		sorter.sort("e", "teste1table");
//		sorter.sort("f", "teste2table");
//		sorter.sort("g", "teste3table");
//		sorter.sort("h", "teste4table");
//		sorter.sort("i", "teste1table");
//		sorter.sort("j", "teste2table");
//		sorter.sort("k", "teste3table");
//		sorter.sort("l", "teste4table");
//		sorter.sort("m", "teste1table");
//		sorter.sort("n", "teste2table");
//		sorter.sort("o", "teste3table");
//		sorter.sort("p", "teste4table");
//		sorter.sort("q", "teste1table");
//		sorter.sort("r", "teste2table");
//		sorter.sort("s", "teste3table");
//		sorter.sort("t", "teste4table");
//		sorter.sort("u", "teste1table");
//		sorter.sort("v", "teste2table");
//		sorter.sort("w", "teste3table");
//		sorter.sort("x", "teste4table");
//		sorter.sort("y", "teste2table");
//		sorter.sort("z", "teste3table");
//		sorter.sort("0", "teste4table");
//		sorter.sort("1", "teste1table");
//		sorter.sort("2", "teste2table");
//		sorter.sort("3", "teste3table");
//		sorter.sort("4", "teste4table");
//		sorter.sort("5", "teste4table");
//		sorter.sort("6", "teste2table");
//		sorter.sort("7", "teste3table");
//		sorter.sort("8", "teste4table");
//		sorter.sort("9", "teste1table");

	}

	public void stop() {
		try{
//			for(int i = 0; i < execNode.length; i++) {
				execNode.stopContainer(CONTAINER_NAME); 
//			}
			Thread.sleep(1000);
		} catch (Exception e ) {
			System.err.println("Erro ao finalizar container");
		}
	}

	/**
	 *  Cria um componente no container associado ao loader
	 */
	private ComponentHandle createHandle(ComponentLoader loader, ComponentId compId){
		ComponentHandle handle = null;
		try {
			handle = loader.load(compId, new String[] { "" });
			handle.cmp.startup();
		} catch (ComponentNotFound e) {
			e.printStackTrace();
			System.err.println("LogApp::createHandle - Componente " + compId.name + " nao encontrado.");
		} catch (ComponentAlreadyLoaded e) {
			e.printStackTrace();
			System.err.println("LogApp::createHandle - Componente " + compId.name + " ja foi criado.");
		} catch (LoadFailure e) {
			e.printStackTrace();
			System.err.println("LogApp::createHandle - Erro ao carregar componente " + compId.name + ".\n");
		} catch (StartupFailed e) {
			e.printStackTrace();
			System.err.println("LogApp::createHandle - Startup do componente " + compId.name + " falhou.\n" );
		}
		return handle;
	}

}
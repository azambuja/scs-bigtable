package scs.core.servant;

import org.omg.CORBA.ORB;

/**
 * Classe utilit�ria que cria uma thread para execu��o do ORB 
 * sem bloquear a thread principal da aplica��o
 * 
 * @author Eduardo Fonseca e Luiz Marques
 *
 */
public class OrbRunner extends Thread {
	ORB orb;
	
	public OrbRunner(ORB orb) {
		this.orb = orb;
	}

	@Override
	public void run() {
		this.orb.run();
	}

}


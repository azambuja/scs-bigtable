package scs.event_service.servant;

/**
 * Classe auxiliar usada na sincroniza��o das opera��es que envolvem o estado de
 * uma conex�o.
 * 
 * @author Eduardo Fonseca/Luiz Marques
 *
 */
public class ConnectionStatus {
	
	private boolean connected = false;

	public ConnectionStatus(boolean flag) { this.connected = flag; }
	
	public boolean isConnected() { return this.connected; }
	
	public void setConnected(boolean flag) { this.connected = flag; }
}

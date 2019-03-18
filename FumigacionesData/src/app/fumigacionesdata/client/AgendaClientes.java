package app.fumigacionesdata.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;

public class AgendaClientes {
	 private ArrayList<Cliente> clienteStock;
	 private static AgendaClientes instance=new AgendaClientes();
	 
	 private AgendaClientes() {
	  clienteStock= new ArrayList<Cliente>();//lista de clientes registrados
	 }
	 public static AgendaClientes getInstance() {
		 return instance;
	 }
	 
	public void iniciarCliente(ArrayList<Cliente> result) {
			//Inicializa el clienteStock con los clientes almacenados anteriormente
		for(Cliente a:result) {
			clienteStock.add(a);
		}
				
		}
	public void remove(Cliente actual) {
		clienteStock.remove(actual);
	}
	public void add(Cliente persona) {
		clienteStock.add(persona);
	}
	public int getIndice(Cliente persona) {
		return clienteStock.indexOf(persona);
	}
	public ArrayList<Cliente> getClientes(){
		return clienteStock;
	}

}

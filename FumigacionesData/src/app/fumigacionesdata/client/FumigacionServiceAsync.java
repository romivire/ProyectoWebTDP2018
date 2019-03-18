package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FumigacionServiceAsync {
	
	void buscarFumigacion(AsyncCallback<ArrayList<Fumigacion>> callback);
	void buscarContador(AsyncCallback<Integer> callback);
	void buscarHtasStock(AsyncCallback<Map<Integer, Integer[]>> callback);
	void buscarClientes(AsyncCallback<ArrayList<Cliente>> callback);
	
	void finHtasStock(Map<Integer, Integer[]> htas, AsyncCallback<Void> callback);
	void finContador(Integer cont, AsyncCallback<Void> callback);
	void finFumStock(ArrayList<Fumigacion> fum, AsyncCallback<Void> callback);
	void finClienteStock(ArrayList<Cliente> clientes, AsyncCallback<Void> callback);
}
package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Operaciones {
	//Atributos
	private FumigacionServiceAsync FumigacionSvc = GWT.create(FumigacionService.class);
	private GUI principal;
	private AgendaFumigaciones fum;
	private AgendaClientes cli;
	
	//Constructor
	public Operaciones(GUI g,AgendaFumigaciones f, AgendaClientes c){
    	principal=g; 
    	fum=f;
    	cli=c;
    }

	//Metodos
	public void iniciarPagina() {
		iniciarContador();
		iniciarFumStock();
		iniciarHtasStock();
		iniciarClientes();
	}
	public void finalizarPagina(ArrayList<Fumigacion> fum,Integer cont,Map<Integer,Integer[]> htas,ArrayList<Cliente> cli) {
		finalizarFumStock(fum);
		finalizarContador(cont);
		finalizarHtasStock(htas);
		finalizarClienteStock(cli);
	}
	

	//Metodos privados	
	//Realizan las RPC para obtener los datos almacenados, al iniciar la aplicacion
	private void iniciarHtasStock() {
		//Inicializa el service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }
		  
		  //Setea el callback object.
		  AsyncCallback<Map<Integer,Integer[]>> callback = new AsyncCallback<Map<Integer,Integer[]>>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");
		   
		    }
		    public void onSuccess(Map<Integer,Integer[]> result) {
		    	fum.iniciarHtasStock(result);
		    }
		  };

		  // Realiza la llamada a FumigacionService
		  FumigacionSvc.buscarHtasStock(callback);
	}
	private void iniciarContador() {
		// Inicializa service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }
		  
		  // Setea el callback object.
		  AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");		   
		    }

		    public void onSuccess(Integer result) {
		    	fum.iniciarContador(result);
		    }
		  };

		  // Realiza la llamada a FumigacionService
		  FumigacionSvc.buscarContador(callback);
	}
	private void iniciarFumStock() {
		//Inicializa service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }
		  
		  //Setea el callback object.
		  AsyncCallback<ArrayList<Fumigacion>> callback = new AsyncCallback<ArrayList<Fumigacion>>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");
		    }

		    public void onSuccess(ArrayList<Fumigacion> result) {
		    	fum.iniciarFumStock(result);
		    	principal.iniciarTablaFumigacion(result);
		    }
		  };

		  //Realiza la llamada a FumigacionService
		  FumigacionSvc.buscarFumigacion(callback);
	}
	private void iniciarClientes() {
		//Inicializa the service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }
		  
		  //Setea el callback object.
		  AsyncCallback<ArrayList<Cliente>> callback = new AsyncCallback<ArrayList<Cliente>>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");
		    }

		    public void onSuccess(ArrayList<Cliente> result) {
		    	cli.iniciarCliente(result);
		    	principal.iniciarTablaCliente(result);
		    }
		  };

		  //Realiza la llamada a FumigacionService
		  FumigacionSvc.buscarClientes(callback);
	}
	
	//Realizan las RPC pasando por parametro los datos vigentes hasta el momento de cerrar la aplicacion, para almacenarlos
	private void finalizarHtasStock(Map<Integer, Integer[]>htas) {
		//Inicializa el service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }

		  //Setea el the callback object.
		  AsyncCallback<Void> callback = new AsyncCallback<Void>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");		   
		    }

		    public void onSuccess(Void result) {		  
		    }
		  };

		  //Realiza la llamada a FumigacionService
		  FumigacionSvc.finHtasStock(htas,callback);
	}
	private void finalizarContador(Integer cont) {
		// Inicializa el service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }

		  // Set up the callback object.
		  AsyncCallback<Void> callback = new AsyncCallback<Void>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");		   
		    }

		    public void onSuccess(Void result) {
		    }
		  };

		  // Realiza la llamada a FumigacionService
		  FumigacionSvc.finContador(cont,callback);
	}
	private void finalizarClienteStock(ArrayList<Cliente> clientes) {
		// Inicializa el service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }

		  // Setea el callback object.
		  AsyncCallback<Void> callback = new AsyncCallback<Void>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la RPC");
		   
		    }

		    public void onSuccess(Void result) {
		    	
		    }
		  };

		  //Realiza la llamada a FumigacionService
		  FumigacionSvc.finClienteStock(clientes,callback);
	}
	private void finalizarFumStock(ArrayList<Fumigacion> fum) {
		// Inicializa el service proxy.
		  if (FumigacionSvc == null) {
			  FumigacionSvc = GWT.create(FumigacionService.class);
		  }

		  // Setea el callback object.
		  AsyncCallback<Void> callback = new AsyncCallback<Void>() {
		    public void onFailure(Throwable caught) {
		    	Window.alert("Error en la  RPC");	   
		    }

		    public void onSuccess(Void result) {
		    }
		  };

		  //Realiza la llamada a FumigacionService
		  FumigacionSvc.finFumStock(fum,callback);
	}

}



    
	
    
		
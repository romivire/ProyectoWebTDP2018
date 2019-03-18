package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class FumigacionesData implements EntryPoint{
	private AgendaFumigaciones f;
	 private AgendaClientes c;
	 private Operaciones o;
	 private DockPanel mainPanel;
	 
	public void onModuleLoad() {
		f=AgendaFumigaciones.getInstance();
		c=AgendaClientes.getInstance();
		GUI g=new GUI(f,c);
		o=new Operaciones(g,f,c);
		g.inicializarGUI();
		o.iniciarPagina();
		
		
		//Associate the Main panel with the HTML host page.
		mainPanel=g.getPanel();
	    RootPanel.get("tablaFumigaciones").add(mainPanel);
	   
	    Window.addCloseHandler(new CloseHandler<Window>() {
	        public void onClose(CloseEvent<Window> event) {
	            //Execute code when window closes!
	        	ArrayList<Fumigacion> fum=f.getFumigaciones();
	        	Integer cont=f.getContador();
	        	Map<Integer,Integer[]> htas=f.getHectareas();
	        	ArrayList<Cliente> cli=c.getClientes();
	        	o.finalizarPagina(fum, cont, htas, cli);
	        	
	        	
	        }
	    });
	};
	
}


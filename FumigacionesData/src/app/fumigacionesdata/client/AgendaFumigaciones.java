package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.client.Window;

public class AgendaFumigaciones {
	 private ArrayList<Fumigacion> fumStock;
	 private ArrayList<Integer> anosStock;
	 private Map<Integer,Integer[]> htasStock;
	 private int contadorH;
	 private static AgendaFumigaciones instance=new AgendaFumigaciones();
			
	 private AgendaFumigaciones() {
			   contadorH=0;//contador de total hectareas registradas
		       fumStock=new ArrayList<Fumigacion>();//lista de fumigaciones registradas
		       anosStock=new ArrayList<Integer>();//lista de los anos que se registraron fumigaciones alguna vez
		       htasStock=new HashMap<Integer,Integer[]>();//mapeo que contiene el ano y su correspondiente lista de meses donde se registran las hectareas registradas en cada mes
	
	 }
	 public static AgendaFumigaciones getInstance() {
		 return instance;
	 }
	
	public void iniciarHtasStock(Map<Integer, Integer[]> result) {
			//Asigna el htaStock con los datos almacenados previamente y agrega los anos que contiene a anosStock	
				for(Iterator<Integer> a=result.keySet().iterator();a.hasNext();) {
					int aux=a.next();
					anosStock.add(aux);
					Integer[] valor=result.get(aux);
					htasStock.put(aux, valor);
				}
		}
	public void iniciarContador(Integer result) {
			//Asigna el contador con el dato almacenado previamente	
				contadorH=result;	
		}
	public void iniciarFumStock(ArrayList<Fumigacion> result) {
			//Inicializa el fumStock con las fumigaciones almacenadas anteriormente
				for(Fumigacion a:result) {
					fumStock.add(a);
				}
			}
	public ArrayList<Integer> getAnios() {
		// TODO Auto-generated method stub
		ArrayList<Integer>anios=new ArrayList<Integer>();
		for(Integer a:anosStock) {
			anios.add(a);
		}
		return anios;
	}
	public void remover(Fumigacion actual) {
		// TODO Auto-generated method stub
		fumStock.remove(actual);
    	borrarHistorial(actual.getAno(),actual.getMes(),actual.getHectareas());
    	contadorH-=actual.getHectareas();
	}
	public void add(Fumigacion nueva) {
			// TODO Auto-generated method stub
		contadorH+=nueva.getHectareas();
		fumStock.add(nueva);
		agregarHistorial(nueva.getAno(),nueva.getMes(),nueva.getHectareas());
		if(!anosStock.contains(nueva.getAno())) {
			   anosStock.add(nueva.getAno());
		   }
		}
	public int getContador() {
		return contadorH;
	}
	public int getIndice(Fumigacion nueva) {
		// TODO Auto-generated method stub
		return fumStock.indexOf(nueva);
	}
	public Integer[] obtenerHtaAnio(int a) {
		// TODO Auto-generated method stub
		return htasStock.get(a);
	}
	public ArrayList<Fumigacion> getFumigaciones(){
		return fumStock;
	}
	public Map<Integer,Integer[]> getHectareas(){
		return htasStock;
	}
	
	private void agregarHistorial(int a,int m,int h) {
		//agrega al mapeo htasStock las hectareas agregadas, al mes indicado del ano indicado.Si no existe el ano, lo crea
			int aux;
			if(htasStock.containsKey(a)) {
				Integer[] listaAno=htasStock.get(a);
				aux=listaAno[m-1];
				aux+=h;
				listaAno[m-1]=aux;
			}
			else {//no existe el ano ingresado
				Integer[] nuevo= new Integer[12];
				for(int i=0;i<12;i++) {
					nuevo[i]=0;
				}
				nuevo[m-1]=h;
				htasStock.put(a,nuevo);
			}
		}
	private void borrarHistorial(int anoElegido, int mesElegido, int hectareasElegidas) {
		//elimina del mapeo htasStock las hectareas a elminar, del mes indicado, del ano indicado	
				Integer[] anoSeleccionado=htasStock.get(anoElegido);
				int datoAnterior=anoSeleccionado[mesElegido-1];
				int datoActual=datoAnterior-hectareasElegidas;
				anoSeleccionado[mesElegido-1]=datoActual;
			}

}

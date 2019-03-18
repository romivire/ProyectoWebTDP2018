package app.fumigacionesdata.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import app.fumigacionesdata.client.Cliente;
import app.fumigacionesdata.client.Fumigacion;
import app.fumigacionesdata.client.FumigacionService;

public class FumigacionServiceImpl extends RemoteServiceServlet implements FumigacionService {

	private File ficheroFumigacion=new File("C:\\Windows\\Temp\\Fumigaciones.txt");
	private File ficheroCliente=new File("C:\\Windows\\Temp\\Clientes.txt");
	private File ficheroHectareas=new File("C:\\Windows\\Temp\\Hectareas.txt");
	private File ficheroContador=new File("C:\\Windows\\Temp\\Contador.txt");
	
	public ArrayList<Fumigacion> buscarFumigacion() {
	//levanta del ficheroFumigacion la informacion mientras arma las Fumigaciones, para luego devolverlas en una lista	
		ArrayList<Fumigacion> info=new ArrayList<Fumigacion>();
		String cadena="";
		if(ficheroFumigacion.exists()) {
	        try {
				FileReader f = new FileReader(ficheroFumigacion);
		        BufferedReader b = new BufferedReader(f);
		        
		        while((cadena = b.readLine())!=null) {
					String aux="";
		
					int indicador=0;
					int ano=0;		
					int mes=0;		
					int dia=0;	
					int hta=0;	
					String cliente="";	
					String campo="";	
					String productos="";
					String anotaciones="";
		
					for(int j=0;j<cadena.length();j++) {
						char a=cadena.charAt(j);
						
						if(a!='.') {
							aux+=a;
						}
						else {
							if(a=='.') {
								 switch (indicador) {
							      case 0:
							         ano=Integer.parseInt(aux) ; 
							           break;
							      case 1:
							          mes=Integer.parseInt(aux);
							           break;
							      case 2:
							    	  dia=Integer.parseInt(aux);
							           break;
							      case 3:
							    	  hta=Integer.parseInt(aux);
							           break;
							      case 4:
							          cliente=aux;
							           break;
							      case 5:
							          campo=aux;
							           break;
							      case 6:
							          productos=aux;
							           break;
							      case 7:
							          anotaciones=aux;
							           break;				
								}
								 indicador++;
								 aux="";
							}
						}
							
					}
					Fumigacion nueva=new Fumigacion(ano,mes,dia,hta,cliente,campo,productos,anotaciones);
					if(campo.equals("")) {
						   campo="@";
					   }
					   if(productos.equals("")) {
						   productos="@";
					   }
					   if(anotaciones.equals("")) {
						   anotaciones="@";
					   }
					   nueva.setInfo(ano+"."+mes+"."+dia+"."+hta+"."+cliente+"."+campo+"."+productos+"."+anotaciones+".");
					   info.add(nueva);
		        }
		        b.close();
		        
		    }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
		}
		return info;
	}		
	public Integer buscarContador() {
	//levanta del ficheroContador el numero de hectareas registradas y lo devuelve
		int contador=0;
		if(ficheroContador.exists()) {
			try {
				FileReader f = new FileReader(ficheroContador);
		        BufferedReader b = new BufferedReader(f);
		        
		        String cadena="";
		        if((cadena=b.readLine())!=null) {
		        	contador=Integer.parseInt(cadena);
		        }
		        b.close();
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return contador;
	}
	public Map<Integer, Integer[]> buscarHtasStock() {
	//Levanta del fichero Hectareas la informacion de hectareas registradas segun los anos y meses, la almacena en el map y lo devuelve
		Map<Integer,Integer[]> anos=new HashMap<Integer,Integer[]>();
		if(ficheroHectareas.exists()) {
			try {
				FileReader f = new FileReader(ficheroHectareas);
		        BufferedReader b = new BufferedReader(f);
		        String cadena="";
		        while((cadena=b.readLine())!=null) {
		        	
		        	int anoClave=Integer.parseInt(cadena);
		        	
		        	Integer[] arreglo=new Integer[12];
				    for(int i=0;i<12;i++) {
				    	cadena=b.readLine();
				    	arreglo[i]=Integer.parseInt(cadena);
				    }
				    anos.put(anoClave, arreglo);
			       }
		        b.close();
		        
			}
		    catch(Exception e) {
		       e.printStackTrace();
		    }
		}
		return anos;
	}	
	public ArrayList<Cliente> buscarClientes() {
	//Levanta del ficheroCliente los datos de los clientes almacenados previamente, crea los clientes y los agregra a una lista que devuelve
		ArrayList<Cliente> info=new ArrayList<Cliente>();
		String cadena="";
		if(ficheroCliente.exists()) {
	        try {
				FileReader f = new FileReader(ficheroCliente);
		        BufferedReader b = new BufferedReader(f);
		        while((cadena = b.readLine())!=null) {
					String aux="";
		
					int indicador=0;
					int telefono=0;		
					String nombre="";	
					String apellido="";	
					String direccion="";
	
		
					for(int j=0;j<cadena.length();j++) {
						char a=cadena.charAt(j);
						
						if(a!='.') {
							aux+=a;
						}
						else {
							if(a=='.') {
								 switch (indicador) {
							      case 0:
							         nombre=aux ; 
							           break;
							      case 1:
							          apellido=aux;
							           break;
							      case 2:
							    	  telefono=Integer.parseInt(aux);
							           break;
							      case 3:
							    	 direccion=aux;;
							           break;				
								}
								 indicador++;
								 aux="";
							}
						}
							
					}
					Cliente nueva=new Cliente(nombre,apellido,telefono,direccion);
					if(direccion.equals("")) {
						   direccion="@";
					   }
					   nueva.setInfo(nombre+"."+apellido+"."+telefono+"."+direccion+".");
					info.add(nueva);
		        }
		        b.close();
		        
	       }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
		}
		return info;
	}

	public void finHtasStock(Map<Integer, Integer[]> htas) {
	//Almacena la info del mapeo en el ficheroHectareas
		try {
			ficheroHectareas.delete();
          //Si no Existe el fichero lo crea
           if(!ficheroHectareas.exists()){
               ficheroHectareas.createNewFile();
           }
          
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroHectareas,true), "utf-8"));
         
          for(Iterator<Integer> a=htas.keySet().iterator();a.hasNext();) {
        	 Integer anoActual=a.next();
        	 Fescribe.write(""+anoActual);
        	 Fescribe.newLine();
        	 Integer[] mesesActuales=htas.get(anoActual);
        	 for(int i=0;i<12;i++) {
        		 Fescribe.write(""+mesesActuales[i]);
        		 Fescribe.newLine();
        	 }
        	 
         }
          //Cierra el flujo de escritura
          Fescribe.close();
       } catch (Exception ex) {
          ex.printStackTrace();
       } 
		
	}
	public void finContador(Integer cont) {
	//Almacena en el ficheroContador el dato cont	
		try {
			ficheroContador.delete();
	          //Si no Existe el fichero lo crea
	           if(!ficheroContador.exists()){
	               ficheroContador.createNewFile();
	           }
	       
	          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroContador,true), "utf-8"));
	          Fescribe.write(""+cont);
	      
	          Fescribe.close();
	    } catch (Exception ex) {
	          //Captura un posible error le imprime en pantalla 
	          System.out.println(ex.getMessage());
	    }
	}
	public void finFumStock(ArrayList<Fumigacion> fum) {
	//Almacena la info de las fumigaciones registradas en el ficheroFumigaciones	
		try {
			ficheroFumigacion.delete();
          //Si no Existe el fichero lo crea
           if(!ficheroFumigacion.exists()){
               ficheroFumigacion.createNewFile();
           }
          
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroFumigacion,true), "utf-8"));
         for(Iterator<Fumigacion> a=fum.iterator();a.hasNext();) {
        	 Fumigacion actual=a.next();
        	 Fescribe.write(actual.getInfo());
        	 Fescribe.newLine();
         }

          //Cierra el flujo de escritura
          Fescribe.close();
       } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
          System.out.println(ex.getMessage());
       } 
	}
	public void finClienteStock(ArrayList<Cliente> cli) {
	//Almacena la info de los clientes registrados en el ficheroClientes	
		try {
			ficheroCliente.delete();
          //Si no Existe el fichero lo crea
           if(!ficheroCliente.exists()){
               ficheroCliente.createNewFile();
           }
          
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroCliente,true), "utf-8"));
         for(Iterator<Cliente> a=cli.iterator();a.hasNext();) {
        	 Cliente actual=a.next();
        	 Fescribe.write(actual.getInfo());
        	 Fescribe.newLine();
         }

          //Cierra el flujo de escritura
          Fescribe.close();
       } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
          System.out.println(ex.getMessage());
       } 
	}
	
}



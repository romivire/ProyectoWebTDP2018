package app.fumigacionesdata.client;

import java.io.Serializable;

public class Cliente implements Serializable {
	//Atributos
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String info;
	
	//Constructores
	public Cliente() {
		
	}
	public Cliente(String n,String a,int t,String d) {
		nombre=n;
		apellido=a;
		telefono=t;
		direccion=d;
		info="";
	}
	
	///Setter y getters
	public void setInfo(String s) {
		info=s;
	}
	public String getInfo() {
		return info;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getDireccion() {
		return direccion;
	}
}

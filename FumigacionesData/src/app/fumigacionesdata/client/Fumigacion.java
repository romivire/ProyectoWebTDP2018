package app.fumigacionesdata.client;

import java.io.Serializable;

public class Fumigacion implements Serializable{

	//Atributos
	private int ano;
	private int mes;
	private int dia;
	private int hectareas;
	private String cliente;
	private String campo;
	private String productos;
	private String anotaciones;
	private String info;

	//Constructores
	public Fumigacion() {
		
	}
	public Fumigacion(int an,int m,int d,int h,String cli,String cam,String p,String a) {
		ano=an;
		mes=m;
		dia=d;
		hectareas=h;
		cliente=cli;
		campo=cam;
		productos=p;
		anotaciones=a;
		info="";
	}
	
	//Setter y getters
	public void setInfo(String s) {
		info=s;
	}
	public String getInfo() {
		return info;
	}
	public int getAno() {
		return ano;
	}
	public int getMes() {
		return mes;
	}
	public int getDia() {
		return dia;
	}
	public int getHectareas() {
		return hectareas;
	}
	public String getCliente() {
		return cliente;
	}
	public String getCampo() {
		return campo;
	}
	public String getProductos() {
		return productos;
	}
	public String getAnotaciones() {
		return anotaciones;
	}
}

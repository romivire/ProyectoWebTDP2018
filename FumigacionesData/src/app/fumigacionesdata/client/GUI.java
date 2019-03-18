package app.fumigacionesdata.client;

import java.util.ArrayList;
import java.util.Date;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class GUI { 
	//Atributos de la GUI
	 private DockPanel mainPanel = new DockPanel();
	 private FlexTable tablaFumigacion= new FlexTable();
	 private  MenuBar menu = new MenuBar();
	 private HorizontalPanel addPanel = new HorizontalPanel();
	 private VerticalPanel addPanelaux1 = new VerticalPanel();
	 private VerticalPanel addPanelaux2 = new VerticalPanel();
	 private VerticalPanel addPanelaux3 = new VerticalPanel();
	 private Label fechaLabel= new Label("Fecha*");
	 private TextBox hectareasTextBox = new TextBox();
	 private Label hectareasLabel= new Label("Hectareas*");
	 private TextBox clienteTextBox = new TextBox();
	 private Label clienteLabel= new Label("Cliente*");
	 private TextBox campoTextBox = new TextBox();
	 private Label campoLabel= new Label("Campo");
	 private TextBox productosTextBox = new TextBox();
	 private Label productosLabel= new Label("Productos");
	 private TextArea anotacionesArea = new TextArea();
	 private Label anotacionesLabel= new Label("Anotaciones");
	 private Button agregarBotonFumigacion = new Button("Agregar");
	 private Label nombreLabel= new Label("Nombre*");
	 private TextBox nombreTextBox = new TextBox();
	 private Label apellidoLabel= new Label("Apellido*");
	 private TextBox apellidoTextBox = new TextBox();
	 private Label telefonoLabel= new Label("Telefono*");
	 private TextBox telefonoTextBox = new TextBox();
	 private Label direccionLabel= new Label("Direccion");
	 private TextBox direccionTextBox = new TextBox();
	 private Button agregarBotonCliente = new Button("Agregar");
	 private VerticalPanel addClientePanel = new VerticalPanel();
	 private VerticalPanel addClientePanelaux1 = new VerticalPanel();
	 private VerticalPanel addClientePanelaux2 = new VerticalPanel();
	 private HorizontalPanel addClientePanelaux3 = new HorizontalPanel();
	 private FlexTable tablaClientes= new FlexTable();
	 private VerticalPanel estadisticasPanel = new VerticalPanel();
	 private VerticalPanel estadisticasPanelaux1 = new VerticalPanel();
	 private VerticalPanel estadisticasPanelaux2 = new VerticalPanel();
	 private HorizontalPanel estadisticasPanelaux3 = new HorizontalPanel();
	 private Label htaTotal= new Label("Total de hectareas registradas: ");
	 private Label ano=new Label("Ano");
	 private Label enero=new Label("Enero");
	 private Label febrero=new Label("Febrero");
	 private Label marzo=new Label("Marzo");
	 private Label abril=new Label("Abril");
	 private Label mayo=new Label("Mayo");
	 private Label junio=new Label("Junio");
	 private Label julio=new Label("Julio");
	 private Label agosto=new Label("Agosto");
	 private Label septiembre=new Label("Septiembre");
	 private Label octubre=new Label("Octubre");
	 private Label noviembre=new Label("Noviembre");
	 private Label diciembre=new Label("Diciembre");
	 private TextBox eneroText = new TextBox();
	 private TextBox febreroText = new TextBox();
	 private TextBox marzoText = new TextBox();
	 private TextBox abrilText = new TextBox();
	 private TextBox mayoText = new TextBox();
	 private TextBox junioText = new TextBox();
	 private TextBox julioText = new TextBox();
	 private TextBox agostoText = new TextBox();
	 private TextBox septiembreText = new TextBox();
	 private TextBox octubreText = new TextBox();
	 private TextBox noviembreText = new TextBox();
	 private TextBox diciembreText = new TextBox();
	 private ListBox listaAnos = new ListBox();;
	 private Label totalXano= new Label("Total de hectareas en el ano: ");
	 private Label promedioXmes= new Label("Promedio de hectareas por mes en el ano: ");
	 private Label estadisticasLabel=new Label();
	 private DateBox dateBox = new DateBox();
	 private HorizontalPanel superiorPanel=new  HorizontalPanel();
	 private VerticalPanel superiorPanelaux=new  VerticalPanel();
	 private VerticalPanel panelAbout=new VerticalPanel();
	 private Label nombreA=new Label("Romina Vitacca - LU 116952");
	 private Label legajoA=new Label("LU 116952");
	 private Label cursadaA=new Label("Tecnologia de Programacion 2018");
	 private Label uniA=new Label("Universidad Nacional del Sur");
	 private Label titulo=new Label("FumigacionesData");
	 private Label fechaActualLabel=new Label();
	 private Label agregarFumigacionLabel1=new Label();
	 private Label agregarFumigacionLabel2=new Label();
	 private Label agregarClienteLabel1=new Label();
	 private Label agregarClienteLabel2=new Label();
	 private Image logo=new Image();

	 private AgendaFumigaciones f;
	 private AgendaClientes c;
	 	 
	 public GUI(AgendaFumigaciones fum,AgendaClientes cli) {
		 f=fum;
		 c=cli;
	 }

	 	public void inicializarGUI() {
	
		 crearMenu();
		 armarPanelSuperior();
	     armarPanelVerFumigaciones();
	     armarPanelAgregarFumigacion();
	     armarPanelGenerales();
	     armarPanelAgregarCliente();
	     armarPanelVerClientes();
	     armarPanelInferior();
	     
	    //Ensambla el panel principal
		    mainPanel.setSpacing(50);
		    mainPanel.getElement().getStyle().setBackgroundColor("#93B874");
		    mainPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		    mainPanel.add(tablaFumigacion,DockPanel.CENTER);
		    mainPanel.add(superiorPanel,DockPanel.NORTH);
		    mainPanel.add(menu,DockPanel.NORTH);
		    mainPanel.add(panelAbout,DockPanel.SOUTH);
		    mainPanel.setCellHorizontalAlignment(panelAbout, DockPanel.ALIGN_LEFT);
		    mainPanel.setCellHorizontalAlignment(menu, DockPanel.ALIGN_LEFT);
		    mainPanel.setCellHorizontalAlignment(superiorPanel, DockPanel.ALIGN_LEFT);
		    
	   //Associate the Main panel with the HTML host page.
		    RootPanel.get("tablaFumigaciones").add(mainPanel);		   
	    
	 }
	 	public void iniciarTablaCliente(ArrayList<Cliente> clienteStock) {
			//Inicializa la tabla de clientes con los datos almacenados previamente, al iniciar la aplicacion
						
			for(Cliente actual: clienteStock) {
				
				
				String dir=actual.getDireccion();
				
				if(dir.equals("@")) {
					 dir="";
				}
					
				int fila = tablaClientes.getRowCount();
				 tablaClientes.setText(fila, 0, ""+actual.getNombre());
				 tablaClientes.setText(fila, 1, ""+actual.getApellido());
				 tablaClientes.setText(fila, 2, ""+actual.getTelefono());
				 tablaClientes.setText(fila, 3, ""+dir);
				  
				 tablaClientes.getElement().getStyle().setBackgroundColor("white");
				 tablaClientes.getCellFormatter().addStyleName(fila, 0, "watchListNumericColumn");
				 tablaClientes.getCellFormatter().addStyleName(fila, 1, "watchListNumericColumn");
				 tablaClientes.getCellFormatter().addStyleName(fila, 2, "watchListNumericColumn");
				 tablaClientes.getCellFormatter().addStyleName(fila, 3, "watchListNumericColumn");
				 tablaClientes.getCellFormatter().addStyleName(fila, 4, "watchListRemoveColumn");


				  //Agrega un boton par remover al cliente de la tabla
				   Button removeStockButton = new Button("x");
				   
				   removeStockButton.addClickHandler(new ClickHandler() {
				        public void onClick(ClickEvent event) {
				        	int indice=c.getIndice(actual);
				        	tablaClientes.removeRow(indice+1);
				        	c.remove(actual);
				        	
				        }
				      });
				 tablaClientes.setWidget(fila, 4, removeStockButton);		
				}				
			}
		public void iniciarTablaFumigacion(ArrayList<Fumigacion> fum) {
			//Inicializa la tabla de fumigaciones con los datos almacenados previamente, al iniciar la aplicacion
			
				for( Fumigacion actual :fum) {
					
					//Fumigacion actual=a.next();
					String cam=actual.getCampo();
					String pro=actual.getProductos();
					String anot=actual.getAnotaciones();
					if(cam.equals("@")) {
						 cam="";
					}
					if(pro.equals("@")) {
						 pro="";
					}
					if(anot.equals("@")) {
						 anot="";
					}
					
					int fila = tablaFumigacion.getRowCount();
					String fecha=actual.getDia()+"-"+actual.getMes()+"-"+actual.getAno();
				   tablaFumigacion.setText(fila, 0, ""+fecha);
				   tablaFumigacion.setText(fila, 1, ""+actual.getHectareas());
				   tablaFumigacion.setText(fila, 2, ""+actual.getCliente());
				   tablaFumigacion.setText(fila, 3, ""+cam);
				   tablaFumigacion.setText(fila, 4, ""+pro);
				   tablaFumigacion.setText(fila, 5, ""+anot);

				   tablaFumigacion.getElement().getStyle().setBackgroundColor("white");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 0, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 1, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 2, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 3, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 4, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 5, "watchListNumericColumn");
				   tablaFumigacion.getCellFormatter().addStyleName(fila, 6, "watchListRemoveColumn");


					  //Agrega un boton para elminar la fumigacion de la tabla
					   Button removeStockButton = new Button("x");
					   removeStockButton.addClickHandler(new ClickHandler() {
					        public void onClick(ClickEvent event) {
					        	int indice=f.getIndice(actual);
					        	tablaFumigacion.removeRow(indice+1);
					        	f.remover(actual);
					        }
					      });
					tablaFumigacion.setWidget(fila, 6, removeStockButton);
				
					}
			}
		public DockPanel getPanel() {
				// TODO Auto-generated method stub
				return mainPanel;
			}
		
	 	private void crearMenu() {
			// Make a command that we will execute from all leaves.
		    //Comando para la opcion "Ver Fumigaciones"
			Command cmd1 = new Command() {
		      public void execute() {
		    	  mantenerComponentes();
		    	mainPanel.add(tablaFumigacion,DockPanel.CENTER);
		      }
		    };
		  //Comando para la opcion "Agregar Fumigacion"
		    Command cmd2 = new Command() {
			  public void execute() {
				  mantenerComponentes();				  
				mainPanel.add(addPanelaux3,DockPanel.CENTER);
			  }
			};
			//Comando para la opcion "Generales"
			Command cmd3 = new Command() {
				public void execute() {
					mantenerComponentes();
					ArrayList<Integer> anios=f.getAnios();
					htaTotal.setText("Total de hectareas registradas: "+f.getContador());
					anios.sort(null);
					listaAnos.clear();
					listaAnos.setVisibleItemCount(1);
					listaAnos.addItem("Seleccione ano");
				      for(Integer aux: anios) {
				    	  
				    	 listaAnos.addItem(""+ aux);
				      }
				      	eneroText.setText("");
						marzoText.setText("");
						febreroText.setText("");
						abrilText.setText("");
						mayoText.setText("");
						junioText.setText("");
						julioText.setText("");
						agostoText.setText("");
						septiembreText.setText("");
						octubreText.setText("");
						noviembreText.setText("");
						diciembreText.setText("");
					mainPanel.add(estadisticasPanel,DockPanel.CENTER);
				}
			};
			//Comando para la opcion "Agregar Cliente"
			 Command cmd4 = new Command() {
			      public void execute() {
			    	  mantenerComponentes();
			    	  mainPanel.add(addClientePanel,DockPanel.CENTER);
			      }
			 };
			//Comando para la opcion "Ver Cliente"
			 Command cmd5 = new Command() {
			      public void execute() {
			    	  mantenerComponentes();
			    	  mainPanel.add(tablaClientes,DockPanel.CENTER);
			      }
			 };
		    
		    //Crea menu bar
			menu.setAutoOpen(true);
		    menu.setWidth("1400px");
		    menu.setHeight("30px");

		    //Crea el menu de Fumigaciones
		    MenuBar fumigacionesMenu = new MenuBar(true);
		    menu.addItem(new MenuItem("Fumigaciones", fumigacionesMenu));
		      fumigacionesMenu.addItem("Ver Fumigaciones", cmd1);
		      fumigacionesMenu.addItem("Agregar Fumigacion", cmd2);
		    //Crea el menu de Estadisticas  
		     MenuBar estadisticasMenu = new MenuBar(true);
		     menu.addItem(new MenuItem("Estadisticas", estadisticasMenu));
		     estadisticasMenu.addItem("Generales", cmd3);
		   //Crea el menu de Contactos
		     MenuBar clientesMenu = new MenuBar(true);
		     menu.addItem(new MenuItem("Clientes", clientesMenu));
		     clientesMenu.addItem("Agregar cliente", cmd4);
		     clientesMenu.addItem("Ver clientes", cmd5);		    
		}		
		private void mantenerComponentes() {
		//Mantiene las componentes graficas comunes a todos las opciones de menu
			mainPanel.clear();
			mainPanel.add(superiorPanel,DockPanel.NORTH);
			mainPanel.add(menu,DockPanel.NORTH);
			mainPanel.add(panelAbout,DockPanel.SOUTH);
			mainPanel.setCellHorizontalAlignment(menu, DockPanel.ALIGN_LEFT);
			mainPanel.setCellHorizontalAlignment(panelAbout, DockPanel.ALIGN_LEFT);
			mainPanel.setCellHorizontalAlignment(superiorPanel, DockPanel.ALIGN_LEFT);		
		}
		private void armarPanelSuperior() {
			
			Date hoy=new Date();
			fechaActualLabel.setText("LA FECHA ACTUAL ES: "+hoy.getDate()+"-"+(hoy.getMonth()+1)+"-"+(hoy.getYear()+1900));
			fechaActualLabel.getElement().getStyle().setColor("white");
			fechaActualLabel.getElement().getStyle().setFontSize(30, Unit.PX);
			
			logo.setUrl("imagenes/logo.png");
			
			titulo.getElement().getStyle().setColor("white");
			titulo.getElement().getStyle().setFontSize(50, Unit.PX);
			
			superiorPanelaux.add(titulo);
			superiorPanelaux.add(fechaActualLabel);
			superiorPanelaux.setSpacing(10);
			superiorPanel.setHorizontalAlignment(superiorPanel.ALIGN_LEFT);
			superiorPanel.setVerticalAlignment(superiorPanel.ALIGN_MIDDLE);
			
			superiorPanel.setSize("1000px", "20px");
			superiorPanel.add(logo);
			superiorPanel.add(superiorPanelaux);		
		}
		private void armarPanelInferior() {
			nombreA.getElement().getStyle().setFontSize(20, Unit.PX);
			nombreA.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			legajoA.getElement().getStyle().setFontSize(20, Unit.PX);
			legajoA.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			cursadaA.getElement().getStyle().setFontSize(20, Unit.PX);
			cursadaA.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			uniA.getElement().getStyle().setFontSize(20, Unit.PX);
			uniA.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			
			panelAbout.setPixelSize(1400,75);			
			panelAbout.setHorizontalAlignment(panelAbout.ALIGN_LEFT);
			panelAbout.getElement().getStyle().setBackgroundColor("#f7f48c");
			panelAbout.add(nombreA);
			panelAbout.add(cursadaA);
			panelAbout.add(uniA);
		}
		private void armarPanelVerClientes() {
			tablaClientes.setText(0, 0, "Nombre");
			tablaClientes.setText(0, 1, "Apellido");
			tablaClientes.setText(0, 2, "Telefono");
			tablaClientes.setText(0, 3, "Direccion");
			tablaClientes.setText(0, 4, "Eliminar");
			
			tablaClientes.setCellPadding(15);
			tablaClientes.getRowFormatter().addStyleName(0,"tablaFumigacionHeader");
			tablaClientes.addStyleName("tablaFumigacion");
		}
		private void armarPanelAgregarCliente() {
			//Este panel se compone de un panel vertical que contiene labels y un panel horizontal, contenedor de dos paneles verticales
			nombreLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    nombreLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    apellidoLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    apellidoLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    telefonoLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    telefonoLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    direccionLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    direccionLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		   
		    agregarClienteLabel1.setText("Ingrese los datos del nuevo cliente");
		    agregarClienteLabel1.getElement().getStyle().setFontSize(35, Unit.PX);
		    agregarClienteLabel2.setText("*Complete los campos obligatorios");
		    agregarClienteLabel2.getElement().getStyle().setFontSize(15, Unit.PX);
		    
		    addClientePanel.setHorizontalAlignment(addClientePanel.ALIGN_CENTER);   
		    addClientePanel.setSpacing(10);
			
			addClientePanelaux1.add(nombreLabel);
			addClientePanelaux2.add(nombreTextBox);
			addClientePanelaux1.add(apellidoLabel);
			addClientePanelaux2.add(apellidoTextBox);
			addClientePanelaux1.add(telefonoLabel);
			addClientePanelaux2.add(telefonoTextBox);
			addClientePanelaux1.add(direccionLabel);
			addClientePanelaux2.add(direccionTextBox);
			addClientePanelaux2.add(agregarBotonCliente);
			
			addClientePanelaux1.setSpacing(15);
		    addClientePanelaux2.setSpacing(11);
		    anotacionesArea.setSize("170px", "70px");
		    		    
		    addClientePanelaux3.add(addClientePanelaux1);
		    addClientePanelaux3.add(addClientePanelaux2);
		    addClientePanel.getElement().getStyle().setBackgroundColor("#6c9fe6");
		    addClientePanel.add(agregarClienteLabel1);
		    addClientePanel.add(addClientePanelaux3);
		    addClientePanel.add(agregarClienteLabel2);
		    		    
			 //Listen para eventos del mouse para el boton de agregarCliente
			    agregarBotonCliente.addClickHandler(new ClickHandler() {
			      public void onClick(ClickEvent event) {
			        addCliente();
			      }
			    });
		}
		private void armarPanelGenerales() {
			//Este panel se compone de un panel vertical que contiene labels y un panel horizontal, contenedor de dos paneles verticales
			eneroText.setEnabled(false);
			marzoText.setEnabled(false);
			febreroText.setEnabled(false);
			abrilText.setEnabled(false);
			mayoText.setEnabled(false);
			junioText.setEnabled(false);
			julioText.setEnabled(false);
			agostoText.setEnabled(false);
			septiembreText.setEnabled(false);
			octubreText.setEnabled(false);
			noviembreText.setEnabled(false);
			diciembreText.setEnabled(false);
			
			listaAnos.addChangeHandler(new ChangeHandler() {

		        //ChangeHandler para el ListBox que contiene los años en la seccion estadisticas
		        public void onChange(ChangeEvent event) {
		            actulizarEstadisticas(listaAnos);
		        }
		        //actualiza los labels de estadisticas segun el año seleccionado
				private void actulizarEstadisticas(ListBox listaAnos) {
					String seleccionado=listaAnos.getValue(listaAnos.getSelectedIndex());
					if(!seleccionado.equals("Seleccione ano")) {
						int anoElegido=Integer.parseInt(seleccionado);
						actualizarEstadisticas(anoElegido);
					}
					else {
						eneroText.setText("");
						marzoText.setText("");
						febreroText.setText("");
						abrilText.setText("");
						mayoText.setText("");
						junioText.setText("");
						julioText.setText("");
						agostoText.setText("");
						septiembreText.setText("");
						octubreText.setText("");
						noviembreText.setText("");
						diciembreText.setText("");
						totalXano.setText("Total de hectareas en el ano: ");
						promedioXmes.setText("Promedio de hectareas por mes en el ano: ");
					}
				}
		    });
		    	  
			enero.getElement().getStyle().setBackgroundColor("#b1d9a6");
			enero.getElement().getStyle().setFontSize(20, Unit.PX);
		    febrero.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    febrero.getElement().getStyle().setFontSize(20, Unit.PX);
		    marzo.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    marzo.getElement().getStyle().setFontSize(20, Unit.PX);
		    abril.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    abril.getElement().getStyle().setFontSize(20, Unit.PX);
		    mayo.getElement().getStyle().setBackgroundColor("#b1d9a6");
			mayo.getElement().getStyle().setFontSize(20, Unit.PX);
		    junio.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    junio.getElement().getStyle().setFontSize(20, Unit.PX);
		    julio.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    julio.getElement().getStyle().setFontSize(20, Unit.PX);
		    agosto.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    agosto.getElement().getStyle().setFontSize(20, Unit.PX);
		    septiembre.getElement().getStyle().setBackgroundColor("#b1d9a6");
			septiembre.getElement().getStyle().setFontSize(20, Unit.PX);
		    octubre.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    octubre.getElement().getStyle().setFontSize(20, Unit.PX);
		    noviembre.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    noviembre.getElement().getStyle().setFontSize(20, Unit.PX);
		    diciembre.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    diciembre.getElement().getStyle().setFontSize(20, Unit.PX);
		    
		    ano.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    ano.getElement().getStyle().setFontSize(20, Unit.PX);
		   
		    estadisticasLabel.setText("Informacion sobre las fumigadas registradas");
		    estadisticasLabel.getElement().getStyle().setFontSize(35, Unit.PX);
		    htaTotal.getElement().getStyle().setFontSize(20, Unit.PX);
		    htaTotal.getElement().getStyle().setBackgroundColor("#f7f48c");
		    totalXano.getElement().getStyle().setFontSize(20, Unit.PX);
		    totalXano.getElement().getStyle().setBackgroundColor("#f7f48c");
		    promedioXmes.getElement().getStyle().setFontSize(20, Unit.PX);
		    promedioXmes.getElement().getStyle().setBackgroundColor("#f7f48c");
		    
		    estadisticasPanel.setHorizontalAlignment(estadisticasPanel.ALIGN_CENTER);   
		    estadisticasPanel.setSpacing(10);
		   	    
		    estadisticasPanelaux1.add(enero);
		    estadisticasPanelaux2.add(eneroText);
		    estadisticasPanelaux1.add(febrero);
		    estadisticasPanelaux2.add(febreroText);
		    estadisticasPanelaux1.add(marzo);
		    estadisticasPanelaux2.add(marzoText);
		    estadisticasPanelaux1.add(abril);
		    estadisticasPanelaux2.add(abrilText);
		    estadisticasPanelaux1.add(mayo);
		    estadisticasPanelaux2.add(mayoText);
		    estadisticasPanelaux1.add(junio);
		    estadisticasPanelaux2.add(junioText);
		    estadisticasPanelaux1.add(julio);
		    estadisticasPanelaux2.add(julioText);
		    estadisticasPanelaux1.add(agosto);
		    estadisticasPanelaux2.add(agostoText);
		    estadisticasPanelaux1.add(septiembre);
		    estadisticasPanelaux2.add(septiembreText);
		    estadisticasPanelaux1.add(octubre);
		    estadisticasPanelaux2.add(octubreText);
		    estadisticasPanelaux1.add(noviembre);
		    estadisticasPanelaux2.add(noviembreText);
		    estadisticasPanelaux1.add(diciembre);
		    estadisticasPanelaux2.add(diciembreText);
		    
		    estadisticasPanelaux1.setSpacing(15);
		    estadisticasPanelaux2.setSpacing(11);
		    
		    estadisticasPanelaux3.add(estadisticasPanelaux1);
		    estadisticasPanelaux3.add(estadisticasPanelaux2);
		    
		    estadisticasPanel.add(estadisticasLabel);
		    estadisticasPanel.add(htaTotal);
		    estadisticasPanel.add(ano);
		    estadisticasPanel.add(listaAnos);
		    estadisticasPanel.add(estadisticasPanelaux3);
		    estadisticasPanel.add(totalXano);
		    estadisticasPanel.add(promedioXmes);
		    
		    estadisticasPanel.getElement().getStyle().setBackgroundColor("#6c9fe6");
		}
		private void armarPanelVerFumigaciones() {
			//Este panel se compone de un panel vertical que contiene labels y un panel horizontal, contenedor de dos paneles verticales
			tablaFumigacion.setText(0, 0, "Fecha");
			tablaFumigacion.setText(0, 1, "Hectareas");
			tablaFumigacion.setText(0, 2, "Cliente");
			tablaFumigacion.setText(0, 3, "Campo");
			tablaFumigacion.setText(0, 4, "Productos");
			tablaFumigacion.setText(0, 5, "Anotaciones");
			tablaFumigacion.setText(0,6,"Eliminar");
			
			tablaFumigacion.setCellPadding(15);
			tablaFumigacion.getRowFormatter().getElement(0).getStyle().setBackgroundColor("#2062B8");
			tablaFumigacion.getRowFormatter().getElement(0).getStyle().setColor("white");
			tablaFumigacion.addStyleName("tablaFumigacion");		    
		}
		private void armarPanelAgregarFumigacion() {
			DateTimeFormat dateFormat = DateTimeFormat.getMediumDateFormat();
		    dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
		    dateBox.getDatePicker().setYearArrowsVisible(true);
					
		    fechaLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    fechaLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    hectareasLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    hectareasLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    clienteLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    clienteLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    campoLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    campoLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    productosLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    productosLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		    anotacionesLabel.getElement().getStyle().setBackgroundColor("#b1d9a6");
		    anotacionesLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		   
		    agregarFumigacionLabel1.setText("Ingrese los datos de la nueva fumigacion");
		    agregarFumigacionLabel1.getElement().getStyle().setFontSize(35, Unit.PX);
		    agregarFumigacionLabel2.setText("*Complete los campos obligatorios");
		    agregarFumigacionLabel2.getElement().getStyle().setFontSize(15, Unit.PX);
		    
		    addPanelaux3.setHorizontalAlignment(addPanelaux3.ALIGN_CENTER);   
		    addPanelaux3.setSpacing(10);
		    
		    addPanelaux1.add(fechaLabel);
			addPanelaux2.add(dateBox);
			addPanelaux1.add(hectareasLabel);
			addPanelaux2.add(hectareasTextBox);
			addPanelaux1.add(clienteLabel);
			addPanelaux2.add(clienteTextBox);
			addPanelaux1.add(campoLabel);
			addPanelaux2.add(campoTextBox);
			addPanelaux1.add(productosLabel);
			addPanelaux2.add(productosTextBox);
			addPanelaux1.add(anotacionesLabel);
			addPanelaux2.add(anotacionesArea);
			addPanelaux2.add(agregarBotonFumigacion);
			addPanelaux1.setSpacing(15);
			addPanelaux2.setSpacing(11);
			anotacionesArea.setSize("170px", "70px");
				    
				    
			addPanel.add(addPanelaux1);
			addPanel.add(addPanelaux2);
			addPanelaux3.add(agregarFumigacionLabel1);
			addPanelaux3.add(addPanel);
			addPanelaux3.add(agregarFumigacionLabel2);
			addPanelaux3.getElement().getStyle().setBackgroundColor("#6c9fe6");
				    
			//ClickHandler para el agregarBotonFumigacion.
			agregarBotonFumigacion.addClickHandler(new ClickHandler() {
				  public void onClick(ClickEvent event) {
				        addFumigacion();
				  }
			});
		}
		private void addFumigacion(){
			//Verifica que los datos ingresados sean correctos y en tal caso, los agrega a la tabla de fumigaciones y a los datos almacenados
			   Date fechaElegida=dateBox.getValue();
			   
			   String hta=hectareasTextBox.getValue().toUpperCase().trim();
			   String cliente=clienteTextBox.getText().toUpperCase().trim();
			   String campo=campoTextBox.getText().toUpperCase().trim();
			   String productos=productosTextBox.getText().toUpperCase().trim();
			   String anotaciones=anotacionesArea.getText().toUpperCase().trim();

			   Date fechaActual=new Date();
			   
			   if(fechaElegida==null||hta.isEmpty()||cliente.isEmpty()) {
				   Window.alert("Complete los campos obligatorios");
				   return;
			   }
			   if(hta.length()>4) {
				   Window.alert("El campo de Hectareas supera los caracteres");
				   return; 
			   }
			   if(cliente.length()>25) {
				   Window.alert("El campo de Cliente supera los caracteres");
				   return; 
			   }
			   if(campo.length()>15) {
				   Window.alert("El campo de Campo supera los caracteres");
				   return; 
			   }
			   if(productos.length()>45) {
				   Window.alert("El campo de Productos supera los caracteres");
				   return; 
			   }
			   if(anotaciones.length()>45) {
				   Window.alert("El campo de Anotaciones supera los caracteres");
				   return; 
			   }
			   //controla que sea un fecha que haya pasado
			   if(fechaActual.before(fechaElegida)) {
				   Window.alert("fecha invalida");
				   return;
			   }
			   //Controla que el textBox de hectareas contenga solamente numeros
			   if (!hta.matches("[0-9]*")) {
			        Window.alert("Ingrese un numero de hectareas valido");
			        return;
			   }
			 //Controla que el textBox de hectareas contenga una cadena del formato (letras-espacios-letras-espacios-letras)
			   if(!cliente.matches("[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*")) {
				   Window.alert("Ingrese un nombre de cliente valido");
			        return;
			   }
			   
			   int htas = Integer.parseInt(hta);
			   int ano=fechaElegida.getYear()+1900;
			   int mes=fechaElegida.getMonth()+1;
			   int dia=fechaElegida.getDate();
			   
			   int fila = tablaFumigacion.getRowCount();
			   tablaFumigacion.setText(fila, 0, ""+dia+"-"+mes+"-"+ano);
			   tablaFumigacion.setText(fila, 1, ""+htas);
			   tablaFumigacion.setText(fila, 2, ""+cliente);
			   tablaFumigacion.setText(fila, 3, ""+campo);
			   tablaFumigacion.setText(fila, 4, ""+productos);
			   tablaFumigacion.setText(fila, 5, ""+anotaciones);
			   
			   if(campo.equals("")) {
				   campo="@";
			   }
			   if(productos.equals("")) {
				   productos="@";
			   }
			   if(anotaciones.equals("")) {
				   anotaciones="@";
			   }
			   
			   Fumigacion nueva=new Fumigacion(ano,mes,dia,htas,cliente,campo,productos,anotaciones);
			   nueva.setInfo(ano+"."+mes+"."+dia+"."+htas+"."+cliente+"."+campo+"."+productos+"."+anotaciones+".");
			   f.add(nueva);
			  
			   tablaFumigacion.getElement().getStyle().setBackgroundColor("white");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 0, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 1, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 2, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 3, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 4, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila, 5, "watchListNumericColumn");
			   tablaFumigacion.getCellFormatter().addStyleName(fila,6,"watchListRemoveColumn");
	 			   
				  // Agrega un boton para borrar la fumigacion de la tabla y de los datos
				   Button removeStockButton = new Button("x");
				   //ClickHandler del boton removeStockButton
				   removeStockButton.addClickHandler(new ClickHandler() {
				        public void onClick(ClickEvent event) {
				        	int indice=f.getIndice(nueva);		     
				        	tablaFumigacion.removeRow(indice+1);
				        	f.remover(nueva);
				        }					
				      });
				   
			   tablaFumigacion.setWidget(fila, 6, removeStockButton);
			   
			//Vuelve a setear los label luego de agregar la fumigacion	
			   hectareasTextBox.setText("");
			   clienteTextBox.setText("");
			   campoTextBox.setText("");
			   productosTextBox.setText("");
			   anotacionesArea.setText("");
		}
		private void addCliente() {
			//Verifica que los datos ingresados sean correctos y en tal caso, los agrega a la tabla de clientes y a los datos almacenados
			 String nombre=nombreTextBox.getText().toUpperCase().trim();
			 String apellido=apellidoTextBox.getText().toUpperCase().trim();
			 String telefono=telefonoTextBox.getText().toUpperCase().trim();
			 String direccion=direccionTextBox.getText().toUpperCase().trim();
			 
			 if(nombre.isEmpty()||apellido.isEmpty()||telefono.isEmpty()) {
				   Window.alert("Complete los campos obligatorios");
				   return;
			}
			//Controla que el textBox de hectareas contenga una cadena del formato (letras-espacios-letras-espacios-letras)
			 if(!nombre.matches("[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*")) {
				   Window.alert("Ingrese un nombre valido");
			        return;
			 }
			//Controla que el textBox de hectareas contenga una cadena del formato (letras-espacios-letras-espacios-letras)
			 if(!apellido.matches("[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*[ \\t\\n\\x0b\\r\\f]*[A-Z]*")) {
				   Window.alert("Ingrese un apellido valido");
			        return;
			 }
			 if(!telefono.matches("[0-9]*")) {
				   Window.alert("Ingrese un telefono valido");
			        return;
			   }
			
		     int tel = Integer.parseInt(telefono);
		   	       
			 int fila = tablaClientes.getRowCount();
			 tablaClientes.setText(fila, 0, ""+nombre);
			 tablaClientes.setText(fila, 1, ""+apellido);
			 tablaClientes.setText(fila, 2, ""+telefono);
			 tablaClientes.setText(fila, 3, ""+direccion);
			 
			 if(direccion.equals("")) {
				 direccion="@";
			 }
			 
			 Cliente persona = new Cliente(nombre,apellido,tel,direccion);
			 persona.setInfo(nombre+"."+apellido+"."+telefono+"."+direccion);
			 c.add(persona);
			 
			 tablaClientes.getElement().getStyle().setBackgroundColor("white");
			 tablaClientes.getCellFormatter().addStyleName(fila, 0, "watchListNumericColumn");
			 tablaClientes.getCellFormatter().addStyleName(fila, 1, "watchListNumericColumn");
			 tablaClientes.getCellFormatter().addStyleName(fila, 2, "watchListNumericColumn");
			 tablaClientes.getCellFormatter().addStyleName(fila, 3, "watchListNumericColumn");
			 tablaClientes.getCellFormatter().addStyleName(fila, 4, "watchListRemoveColumn");

				  // Agrega boton para remover al cliente de la tabla de clientes y de los datos almacenados			 
				   Button removeStockButton = new Button("x");
				   
				   removeStockButton.addClickHandler(new ClickHandler() {
				        public void onClick(ClickEvent event) {
				        	int indice=c.getIndice(persona);	       		        	
				        	tablaClientes.removeRow(indice+1);
				        	c.remove(persona);
				        }
				      });
				   
			 tablaClientes.setWidget(fila, 4, removeStockButton);
			   
			//Vuelve a setear los label luego de agregar la fumigacion
			 nombreTextBox.setText("");
			 apellidoTextBox.setText("");
			 telefonoTextBox.setText("");
			 direccionTextBox.setText("");
		}
		private void actualizarEstadisticas(int a) {
		//Actualiza los label de las estadisticas con el ano seleccionado	
			Integer[] result= f.obtenerHtaAnio(a);
			
			eneroText.setText(""+result[0]);
			febreroText.setText(""+result[1]);
			marzoText.setText(""+result[2]);
			abrilText.setText(""+result[3]);
			mayoText.setText(""+result[4]);
			junioText.setText(""+result[5]);
			julioText.setText(""+result[6]);
			agostoText.setText(""+result[7]);
			septiembreText.setText(""+result[8]);
			octubreText.setText(""+result[9]);
			noviembreText.setText(""+result[10]);
			diciembreText.setText(""+result[11]);
			
			int contadorTotal=0;
			for(int i=0;i<12;i++) {
				contadorTotal+=result[i];
			}
			
			totalXano.setText("Total de hectareas en el ano: "+contadorTotal);
			promedioXmes.setText("Promedio de hectareas por mes en el ano: "+contadorTotal/12);
		}		
		
		
}

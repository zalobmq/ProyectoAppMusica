package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ArtistaDAO;
import dao.CancionDAO;
import dao.DiscoDAO;
import dao.GeneroDAO;
import dao.ListaDeReproduccionDAO;
import dao.UsuarioDAO;
import dao.SubscripcionDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelos.Cancion;
import modelos.Disco;
import modelos.ListaDeReproduccion;
import modelos.Usuario;

public class VentanaBuscarUsuarioController {

	private static  Usuario esteusuario;
	
	//-----
	@FXML
	private TableView<Disco> tablaDisco;
	
	@FXML
	private TableColumn<Disco, String> nombreDisco;
	@FXML
	private TableColumn<Disco, String> artistaDisco;
	@FXML
	private TableColumn<Disco, String> fechaProduccionDisco;
	
	//-----	
	@FXML
	private TableView<Cancion> tablaCancion;
	
	@FXML
	private TableColumn<Cancion, String> nombreCancion;
	@FXML
	private TableColumn<Cancion, String> duracionCancion;
	@FXML
	private TableColumn<Cancion, String> discoCancion;
	@FXML
	private TableColumn<Cancion, String> generoCancion;
	@FXML
	private TableColumn<Cancion, String> nºReproduciones;
	
	
	
	//-----	
	@FXML
	private TableView<ListaDeReproduccion> tablaLista;
	
	@FXML
	private TableColumn<ListaDeReproduccion, String> nombreListaRep;
	@FXML
	private TableColumn<ListaDeReproduccion, String> descripcionListaRep;
	@FXML
	private TableColumn<ListaDeReproduccion, String> CreadorListaRep;
	
	
	//  ObservableList<ListaDeReproduccion> listaReproduccion;
	//private ObservableList<Disco> listaDiscos;
	// private ObservableList<Cancion> listaCanciones;
	 
	
	@FXML
    protected void initialize () {
	 
	}
	
	public static void setUsuario (Usuario u) {
		
		esteusuario = u;	
    }
	
	private void configurarTablaCancion() {
		nombreCancion.setCellValueFactory(cadaCancion -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaCancion.getValue().getNombre());
            return v;
        });
		discoCancion.setCellValueFactory(cadaCancion -> {
            SimpleStringProperty v = new SimpleStringProperty();
            DiscoDAO d= new DiscoDAO();
            v.setValue(d.disco_x_id(cadaCancion.getValue().getId_disco()).getNombre());
            return v;
        });
		generoCancion.setCellValueFactory(cadaCancion -> {
            SimpleStringProperty v = new SimpleStringProperty();
            GeneroDAO g = new GeneroDAO();
            
            v.setValue(g.genero_x_id(cadaCancion.getValue().getId_genero()).getNombre());
            return v;
        });
		duracionCancion.setCellValueFactory(cadaCancion -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaCancion.getValue().getDuracion()+"");
            return v;
        });
		nºReproduciones.setCellValueFactory(cadaCancion -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaCancion.getValue().getnReproducciones()+"");
            return v;
        });
    }
	private void configurarTablaListaReproducciones() {
		nombreListaRep.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadalista.getValue().getNombre());
            return v;
        });
		descripcionListaRep.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadalista.getValue().getDescripcion());
            return v;
        });
		CreadorListaRep.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            UsuarioDAO u= new UsuarioDAO();
            //Busca un usuario en la BD con ese id y coje su nombre para la tabla.
            v.setValue(u.buscarUsuarioId(cadalista.getValue().getId_usuario()).getNombre());
            return v;
        });
	}
	
	private void configurarTablaDiscos() {
		
		nombreDisco.setCellValueFactory(cadaDisco -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaDisco.getValue().getNombre());
            return v;
        });
		artistaDisco.setCellValueFactory(cadaDisco -> {
            SimpleStringProperty v = new SimpleStringProperty();
            ArtistaDAO a=new ArtistaDAO();
            
            v.setValue(a.buscarArtistaId(cadaDisco.getValue().getId_Artista()).getNombre());
            return v;
        });
		fechaProduccionDisco.setCellValueFactory(cadaDisco -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaDisco.getValue().getFecha_produccion()+"");
            return v;
        });
	}
	
	public void MostrarTodosCanciones() {
		configurarTablaCancion();
		ObservableList<Cancion>listaCanciones = FXCollections.observableArrayList(CancionDAO.todas_las_canciones());
		tablaCancion.setItems(listaCanciones);
	}
	
	public void MostrarCancionesMenuDiscos(){
		
		if(tablaDisco.getSelectionModel().getSelectedItem() != null) {
		try {
			DiscoDAO discoSelec = new DiscoDAO(tablaDisco.getSelectionModel().getSelectedItem().getId());
			MostrarCancionesDiscoUsuario.setDisco(discoSelec);
			App.loadScene(new Stage(), "MostrarCancionesDiscoUsuario", "Canciones del disco");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void MostrarTodosDiscos() {
		configurarTablaDiscos();
		ObservableList<Disco> listaDiscos = FXCollections.observableArrayList(DiscoDAO.listaTodosDiscos());
		tablaDisco.setItems(listaDiscos);
	}
	
	public void MostrarTodosListasRep() {
		configurarTablaListaReproducciones();
		ObservableList<ListaDeReproduccion> listaReproduccion = FXCollections.observableArrayList(ListaDeReproduccionDAO.Mostrar_todos());
		//System.out.println("BUSCAR -LISTA  "+listaReproduccion.toString());
		tablaLista.setItems(listaReproduccion);	
	}
	
	public void SeguirLista() {
		
		if(tablaLista.getSelectionModel().getSelectedItem() != null) {
	ListaDeReproduccionDAO listaSelec = new ListaDeReproduccionDAO(tablaLista.getSelectionModel().getSelectedItem().getId());
	//System.out.println(esteusuario.getId());
	//System.out.println(listaSelec.getId());
	SubscripcionDAO sub=new SubscripcionDAO(esteusuario.getId(),listaSelec.getId());
	sub.añadirSub();
		}
	}
	public void DejarDeSegirLista() {
		if(tablaLista.getSelectionModel().getSelectedItem() != null) {
			ListaDeReproduccionDAO listaSelec = new ListaDeReproduccionDAO(tablaLista.getSelectionModel().getSelectedItem().getId());
			SubscripcionDAO sub=new SubscripcionDAO();
			sub.eliminarSub(esteusuario.getId(), listaSelec.getId());
			
		}
	}
	
	
}

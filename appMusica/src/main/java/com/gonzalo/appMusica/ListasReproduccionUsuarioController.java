package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ListaDeReproduccionDAO;
import dao.UsuarioDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelos.Cancion;
import modelos.ListaDeReproduccion;
import modelos.Usuario;


public class ListasReproduccionUsuarioController {

	 @FXML
	    private TableView<ListaDeReproduccion> tablaListarep;
	 
	 @FXML
	 private TableColumn<ListaDeReproduccion, String> nombre;
	 @FXML
	 private TableColumn<ListaDeReproduccion, String> descripcion;
	 @FXML
	 private TableColumn<ListaDeReproduccion, String> nombre_creador;
	 
	 private ObservableList<ListaDeReproduccion> listasRep;
	 
	 @FXML
	 private Button botonNuevaLista;
	 
	 @FXML
	 private Button btAñadir;
	 
	 @FXML
	 private Button btBorrar;
	 
	 @FXML
	 private Button btVerMiLista;

	 @FXML
	 private Button btVerListaSub;
	 
	 
	 private static  Usuario esteUsuario;
	 private ListaDeReproduccionDAO listaSelect;
	 
	 @FXML
	    protected void initialize () {
		// btVerMiLista.setDisable(true);
		// btVerListaSub.setDisable(true);

	 }
	 
	 //---------
	 public static void setUsuario (Usuario u) {
			
			esteUsuario = u;	
	    }
	 //---------
	 
	 private void configurarTabla() {
			nombre.setCellValueFactory(cadalista -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            v.setValue(cadalista.getValue().getNombre());
	            return v;
	        });
			descripcion.setCellValueFactory(cadalista -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            v.setValue(cadalista.getValue().getDescripcion());
	            return v;
	        });
			nombre_creador.setCellValueFactory(cadalista -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            UsuarioDAO u= new UsuarioDAO();
	            //Busca un usuario en la BD con ese id y coje su nombre para la tabla.
	            v.setValue(u.buscarUsuarioId(cadalista.getValue().getId_usuario()).getNombre());
	            return v;
	        });
	
		      
	    }
	 //---------
	 @FXML
		private void buttonMostrarMisListas() {
		 btVerMiLista.setDisable(false);	
		 btVerListaSub.setDisable(true);
		 btAñadir.setDisable(false);
		 btBorrar.setDisable(false);

		 configurarTabla();
			listasRep = FXCollections.observableArrayList(ListaDeReproduccionDAO.Mostrar_todas_mis_listas(esteUsuario));

			tablaListarep.setItems(listasRep);
			
			 
		}
	 //---------
	 @FXML
	    public void crearNueva() {
	    	
	    	try {
	    		/*
	    		Stage a = (Stage) botonNuevaLista.getScene().getWindow();
				App.closeScene(a);
				*/
				App.loadScene(new Stage(), "CrearPlaylist", "Nueva lista de reproduccion");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 @FXML
	    public void verLista() {
			if(tablaListarep.getSelectionModel().getSelectedItem() != null) {
		
	    	try {
	    		listaSelect = new ListaDeReproduccionDAO(tablaListarep.getSelectionModel().getSelectedItem().getId());
	    		VerListaRepController.setUsuario(listaSelect);
	    		MosTodasCancionesElegirController.setLista(listaSelect);
	    		
				App.loadScene(new Stage(), "VerListaRepUsuario", "lista de reproduccion ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    }
	 }
	 
	 public void verListaSub() {
			if(tablaListarep.getSelectionModel().getSelectedItem() != null) {
		
	    	try {
	    		listaSelect = new ListaDeReproduccionDAO(tablaListarep.getSelectionModel().getSelectedItem().getId());
	    		VerListaRepOtroController.setUsuario(listaSelect);
	    		MosTodasCancionesElegirController.setLista(listaSelect);
	    		
				App.loadScene(new Stage(), "VerListaRepOtroUsuario", "lista de reproduccion ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	    }
	 }
	 
	 
	 public void borrarLista() {
		 if(tablaListarep.getSelectionModel().getSelectedItem() != null) {
		listaSelect = new ListaDeReproduccionDAO(tablaListarep.getSelectionModel().getSelectedItem().getId());
		System.out.println(listaSelect);
		ListaDeReproduccionDAO listaBorrar = new ListaDeReproduccionDAO();
		listaBorrar.eliminar(listaSelect.getId());
		
		 }
	 }
	 
	 @FXML
		private void buttonMostrarListasSub() {
		 
		 btVerListaSub.setDisable(false);
		 btVerMiLista.setDisable(true);
		 btAñadir.setDisable(true);
		 btBorrar.setDisable(true);
		 

			configurarTabla();
			listasRep = FXCollections.observableArrayList(ListaDeReproduccionDAO.Mostrar_todos_Sub(esteUsuario));
			tablaListarep.setItems(listasRep);

		}
	 
	 
}

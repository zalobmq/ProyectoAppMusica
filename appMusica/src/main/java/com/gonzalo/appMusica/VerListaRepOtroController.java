package com.gonzalo.appMusica;

import java.io.IOException;

import dao.CancionDAO;
import dao.ContieneDAO;
import dao.DiscoDAO;
import dao.GeneroDAO;
import dao.ListaDeReproduccionDAO;
import dao.UsuarioDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelos.Cancion;
import modelos.ListaDeReproduccion;

public class VerListaRepOtroController {

private static  ListaDeReproduccion listaSelecion;
	
	@FXML
	private Label nombreLista;
	
	@FXML
	private Label descripcionLista;;
	
	@FXML
	private Label nombre_creadorLista;
	

	
	//--TABLA CANCIONES DE LA LISTA
	 @FXML
	    private TableView<Cancion> tablaListaCanciones;
	 
	 @FXML
	 private TableColumn<Cancion, String> nombre;
	 @FXML
	 private TableColumn<Cancion, String> disco;
	 @FXML
	 private TableColumn<Cancion, String> genero;
	 @FXML
	 private TableColumn<Cancion, String> duracion;
	 @FXML
	 private TableColumn<Cancion, String> nºReproduciones;
	 
	 
	 private ObservableList<Cancion> listaCanciones;
	 
	//----------
	
	 public static void setUsuario (ListaDeReproduccion list) {
			
		 listaSelecion = list;	
	    }
	 @FXML
		protected void initialize() {
		 
		 ListaDeReproduccionDAO l = new ListaDeReproduccionDAO();
		 UsuarioDAO u = new UsuarioDAO();
		 
		 System.out.println(listaSelecion.getId());
		 
		 l=l.Mostrar_lista_x_id(listaSelecion);
		 
		 u=u.buscarUsuarioId(l.getId_usuario());
		 nombreLista.setText(l.getNombre());
		 descripcionLista.setText(l.getDescripcion());
		 nombre_creadorLista.setText(u.getNombre());
		 configurarTabla();
			listaCanciones = FXCollections.observableArrayList(l.getLista());

			tablaListaCanciones.setItems(listaCanciones);
		}
	 
	 
	 private void configurarTabla() {
			nombre.setCellValueFactory(cadaCancion -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            v.setValue(cadaCancion.getValue().getNombre());
	            return v;
	        });
			disco.setCellValueFactory(cadaCancion -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            DiscoDAO d= new DiscoDAO();
	            v.setValue(d.disco_x_id(cadaCancion.getValue().getId_disco()).getNombre());
	            return v;
	        });
			genero.setCellValueFactory(cadaCancion -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            GeneroDAO g = new GeneroDAO();
	            
	            v.setValue(g.genero_x_id(cadaCancion.getValue().getId_genero()).getNombre());
	            return v;
	        });
			duracion.setCellValueFactory(cadaCancion -> {
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
	
	 public void reproducirCancion() {
		 if(tablaListaCanciones.getSelectionModel().getSelectedItem() != null) {
			 CancionDAO cancionSelect = new CancionDAO(tablaListaCanciones.getSelectionModel().getSelectedItem().getId());
			 
			int nrepBD= nRepBD(cancionSelect.getId());
			System.out.println(nrepBD);
			nrepBD++;
			System.out.println(nrepBD);
			CancionDAO c = new CancionDAO();
			c.añadirMasREP(nrepBD);
		 }
		
	 }
	 
	 private int nRepBD(int id) {
		 int result;
		 CancionDAO n=CancionDAO.cancion_x_id(id);
		 
		 result=n.getnReproducciones();
		 
		 
		 return result;
	 }
}

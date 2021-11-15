package com.gonzalo.appMusica;

import java.io.IOException;

import dao.CancionDAO;
import dao.ContieneDAO;
import dao.DiscoDAO;
import dao.GeneroDAO;
import dao.ListaDeReproduccionDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelos.Cancion;
import modelos.ListaDeReproduccion;

public class MosTodasCancionesElegirController {

	
	private static  ListaDeReproduccion listaSelecion;

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
		
		
		@FXML
	    protected void initialize () {
			MostrarTodosCanciones();
			
		}
		
		 public static void setLista (ListaDeReproduccion list) {
				
			 listaSelecion = list;	
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
		 public void MostrarTodosCanciones() {
				configurarTablaCancion();
				ObservableList<Cancion>listaCanciones = FXCollections.observableArrayList(CancionDAO.todas_las_canciones());
				tablaCancion.setItems(listaCanciones);
		}
		 
		 public void añadirCancion() {
			 try {
				 if(tablaCancion.getSelectionModel().getSelectedItem() != null) {
						CancionDAO cancionSelect = new CancionDAO(tablaCancion.getSelectionModel().getSelectedItem().getId());	 
						 ContieneDAO c = new ContieneDAO(listaSelecion.getId(),cancionSelect.getId());
						 c.añadir();
						 
				App.loadScene(new Stage(), "ListasRepUsuario", "lista de reproduccion ");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
}

		 



package com.gonzalo.appMusica;

import java.io.IOException;

import dao.CancionDAO;
import dao.DiscoDAO;
import dao.GeneroDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Artista;
import modelos.Cancion;
import modelos.Disco;
import modelos.Genero;

public class AñadirCancionArtistaContoller {

	
	
	private static  Disco estedisco;

	
	@FXML
	private TextField nombre;
	
	@FXML
	private TableView<Genero> tablaGenero;
	
	@FXML
	private TableColumn<Genero, String> nombreGenero;
	
	
	
	@FXML
	protected void initialize() {

		mostrarTodosGeneros();
		
	}
	
	public static void setDisco (Disco d) {
		
		estedisco = d;	
    }
	
	public void añadirOtra() {
		
		try {
			
			CancionDAO cancionNueva = new CancionDAO();
			cancionNueva.setNombre(nombre.getText());
			System.out.println(estedisco.getId());
			cancionNueva.setId_disco(estedisco.getId());
			if(tablaGenero.getSelectionModel().getSelectedItem() != null) {
				 GeneroDAO generoSelect = new GeneroDAO(tablaGenero.getSelectionModel().getSelectedItem().getId());
			cancionNueva.setId_genero(generoSelect.getId());
			}
			cancionNueva.añadir();
			
			
			App.loadScene(new Stage(), "AñadirCancionV2", "Añadir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void configurarTablaGenero() {
		
		nombreGenero.setCellValueFactory(cadaGenero -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaGenero.getValue().getNombre());
            return v;
        });
		
	}
	public void mostrarTodosGeneros() {
		configurarTablaGenero();
		ObservableList<Genero> listaGenero = FXCollections.observableArrayList(GeneroDAO.todas_los_generos());
		tablaGenero.setItems(listaGenero);
	}
	
	public void terminar() {
			try {
				
				CancionDAO cancionNueva = new CancionDAO();
				cancionNueva.setNombre(nombre.getText());
				cancionNueva.setId_disco(estedisco.getId());
				if(tablaGenero.getSelectionModel().getSelectedItem() != null) {
					 GeneroDAO generoSelect = new GeneroDAO(tablaGenero.getSelectionModel().getSelectedItem().getId());
				cancionNueva.setId_genero(generoSelect.getId());
				}
				cancionNueva.añadir();
			App.loadScene(new Stage(), "VentanaMisDiscosArtista", "Ventana Mis Discos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

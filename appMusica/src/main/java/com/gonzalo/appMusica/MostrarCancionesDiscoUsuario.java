package com.gonzalo.appMusica;

import dao.CancionDAO;
import dao.DiscoDAO;
import dao.GeneroDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelos.Cancion;
import modelos.Disco;
import modelos.Usuario;

public class MostrarCancionesDiscoUsuario {
	
	
	private static  Disco estedisco;
	
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
	
	public static void setDisco (Disco d) {
		
	estedisco = d;	
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
	ObservableList<Cancion> listaCanciones = FXCollections.observableArrayList(CancionDAO.lista_canciones_x_id_disco(estedisco.getId()));
	//System.out.println(listaCanciones.toString());
	tablaCancion.setItems(listaCanciones);
}
}

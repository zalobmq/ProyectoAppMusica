package com.gonzalo.appMusica;

import dao.DiscoDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelos.Artista;
import modelos.Disco;

public class VentanaDiscosArtistaController {

	private static  Artista esteartista;
	
	@FXML
	private TableView<Disco> tablaDisco;
	
	@FXML
	private TableColumn<Disco, String> nombreDisco;
	
	@FXML
	private TableColumn<Disco, String> fechaProduccionDisco;
	
	@FXML
	protected void initialize() {

	}
	
	public static void setArtista (Artista a) {
		
		esteartista = a;	
    }
	
	private void configurarTablaDiscos() {
		
		nombreDisco.setCellValueFactory(cadaDisco -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaDisco.getValue().getNombre());
            return v;
        });
		fechaProduccionDisco.setCellValueFactory(cadaDisco -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaDisco.getValue().getFecha_produccion()+"");
            return v;
        });
	}
	public void mostrarTodos() {
		configurarTablaDiscos();
		ObservableList<Disco>listaDiscos = FXCollections.observableArrayList(DiscoDAO.buscarPorArtista(esteartista.getId()));
		tablaDisco.setItems(listaDiscos);
	}
	
	
	
}

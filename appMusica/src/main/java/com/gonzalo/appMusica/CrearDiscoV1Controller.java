package com.gonzalo.appMusica;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import dao.DiscoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Artista;

public class CrearDiscoV1Controller {

	private static  Artista esteartista;
	
	@FXML
	private TextField nombre;
	
	@FXML
	private Button boton_siguiente;
	@FXML
	protected void initialize() {

	}
	
	public static void setArtista (Artista a) {
		
		esteartista = a;	
    }
	
	public void siguiente() {
		
		try {
			DiscoDAO discoNuevo = new DiscoDAO();
			discoNuevo.setNombre(nombre.getText());
			discoNuevo.setId_Artista(esteartista.getId());
			discoNuevo.setFecha_produccion(Date.valueOf(LocalDate.now()));
			discoNuevo.añadir();
			
			Stage a = (Stage) boton_siguiente.getScene().getWindow();
			App.closeScene(a);
			AñadirCancionArtistaContoller.setDisco(discoNuevo);
			App.loadScene(new Stage(), "AñadirCancionV2", "Añadir cancion ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

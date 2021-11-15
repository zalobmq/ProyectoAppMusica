package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AñadirCancionArtistaContoller {

	@FXML
	protected void initialize() {

	}
	
	public void añadirOtra() {
		
		try {
			App.loadScene(new Stage(), "AñadirCancionV2", "Añadir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void terminar() {
		
		try {
			App.loadScene(new Stage(), "VentanaMisDiscosArtista", "Ventana Mis Discos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

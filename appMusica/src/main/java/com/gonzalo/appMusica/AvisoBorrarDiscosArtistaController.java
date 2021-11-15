package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AvisoBorrarDiscosArtistaController {

	@FXML
	protected void initialize() {

	}
	
	public void si() {
		
		try {
			App.loadScene(new Stage(), "VentanaMisDiscosArtista", "Ventana Mis Discos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void no() {
		
		try {
			App.loadScene(new Stage(), "VentanaMisDiscosArtista", "Ventana Mis Discos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

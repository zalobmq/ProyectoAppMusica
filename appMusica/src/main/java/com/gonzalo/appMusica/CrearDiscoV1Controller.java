package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CrearDiscoV1Controller {

	@FXML
	private Button boton_siguiente;
	@FXML
	protected void initialize() {

	}
	
	public void siguiente() {
		
		try {
			Stage a = (Stage) boton_siguiente.getScene().getWindow();
			App.closeScene(a);
			App.loadScene(new Stage(), "AñadirCancionV2", "Añadir cancion ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

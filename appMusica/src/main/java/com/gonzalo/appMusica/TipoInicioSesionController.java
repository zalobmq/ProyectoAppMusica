package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class TipoInicioSesionController {

	
	@FXML
	protected void initialize() {

	}
	@FXML
	public void btArtista() {
		
		try {
			App.loadScene(new Stage(), "InicioSesionArtista", "InicioSesionArtista");
			App.closeScene(new Stage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	@FXML
	public void btUsuario() {
		try {
			App.loadScene(new Stage(), "InicioSesionUsuario", "InicioSesionUsuario");
			App.closeScene(new Stage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditarDiscoV1Controller {

	@FXML
	protected void initialize() {

	}
	public void nuevo() {
		
		try {
			App.loadScene(new Stage(), "CrearDiscoV1", "Nuevo disco");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

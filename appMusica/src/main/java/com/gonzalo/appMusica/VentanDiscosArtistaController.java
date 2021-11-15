package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class VentanDiscosArtistaController {

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
	
	public void borrar() {
		
		try {
			App.loadScene(new Stage(), "AvisoBorrarDiscoArtista", "** ATENCION **");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editar() {
		
		try {
			App.loadScene(new Stage(), "EditarDiscoV1", "Editar Disco");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

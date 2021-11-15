package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ArtistaDAO;
import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroArtistaController {


	@FXML
	private TextField usuario;
	@FXML
	private TextField nacionalidad;
	@FXML
	private TextField contraseña;
	
	@FXML
	protected void initialize() {
		
	}
	/*
	 * Crea un usuario con los datos introducidos y los añade a la BD.
	 */
	public void registro() {
		
		ArtistaDAO a = new ArtistaDAO();
		
		a.setNombre(usuario.getText());
		a.setNacionalidad(nacionalidad.getText());
		a.setContraseña(contraseña.getText());
		
		a.añadir();
		
		try {
			App.loadScene(new Stage(), "InicioSesionArtista", "Iniciar sesion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

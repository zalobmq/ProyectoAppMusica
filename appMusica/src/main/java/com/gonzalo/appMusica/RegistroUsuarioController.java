package com.gonzalo.appMusica;

import java.io.IOException;

import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistroUsuarioController {

	@FXML
	private TextField usuario;
	@FXML
	private TextField correo;
	@FXML
	private TextField contraseña;
	
	@FXML
	protected void initialize() {
		
	}
	/*
	 * Crea un usuario con los datos introducidos y los añade a la BD.
	 */
	public void registro() {
		
		UsuarioDAO u = new UsuarioDAO();
		
		u.setNombre(usuario.getText());
		u.setCorreo(correo.getText());
		u.setContraseña(contraseña.getText());
		
		u.añadir();
		
		try {
			App.loadScene(new Stage(), "InicioSesionUsuario", "Iniciar sesion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

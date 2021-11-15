package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ArtistaDAO;
import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Artista;
import modelos.Usuario;

public class InicioSesionUsuarioController {

	@FXML
    private TextField TextUsuario;
	
    @FXML
    private TextField TextContraseña;
    
    //private Usuario esteUsuario = new Usuario();
    
    
    @FXML
	protected void initialize() {

	}
    
    @FXML
    public void InicioSesion_ValidarUsuarioContraseña() {
    	
    	UsuarioDAO usuario = new UsuarioDAO();
    	
    	usuario.setNombre(TextUsuario.getText());
    	usuario.setContraseña(TextContraseña.getText());
    	
    	if(usuario.comprobarNombre_Contraseña(usuario)) {
    		
    		//EL USUARIO Y CONTRASEÑA SON VALIDOS -PASA A LA SIGUIENTA PANTALLA
    		try {
    			
    			VentanaPrincipalUsuarioController.setUsuario(usuario);
    			PerfilUsuarioController.setUsuario(usuario);
    			CrearPlaylistController.setUsuario(usuario);
    			ListasReproduccionUsuarioController.setUsuario(usuario);
    			VentanaBuscarUsuarioController.setUsuario(usuario);
    			ElegirFotoUsuarioController.setUsuario(usuario);
    			App.loadScene(new Stage(), "VentanaPrincipalUsuario", "Ventana Principal Usuario");
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}else {
    		
    		//VENTANA DE ERROR
    		try {
    			App.loadScene(new Stage(), "ErrorInicioSesion", "ErrorInicioSesion");
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}	
    }
    @FXML
    public void btRegistro() {
    	
    	try {
			App.loadScene(new Stage(), "RegistroUsuario", "Ventana de registro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
}

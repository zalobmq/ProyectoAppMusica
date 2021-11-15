package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ArtistaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Artista;
import modelos.Usuario;

public class InicioSesionArtistaController {
	@FXML
    private TextField TextUsuario;
	
    @FXML
    private TextField TextContraseña;
    
    
    @FXML
	protected void initialize() {

	}
    
    @FXML
    public void InicioSesion_ValidarUsuarioContraseña() {
    	
    	ArtistaDAO artista = new ArtistaDAO();
    	
    	artista.setNombre(TextUsuario.getText());
    	artista.setContraseña(TextContraseña.getText());
    	
    	if(artista.comprobarNombre_Contraseña(artista)) {
    		
    		//EL USUARIO Y CONTRASEÑA SON VALIDOS -PASA A LA SIGUIENTA PANTALLA
    		try {
    			
    			VentanaPrincipalArtistaController.setArtista(artista);
    			PerfilArtistaController.setArtista(artista);
    			App.loadScene(new Stage(), "VentanaPrincipalArtista", "Ventana Principal Artista");
    			
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
			App.loadScene(new Stage(), "RegistroArtista", "Ventana de registro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

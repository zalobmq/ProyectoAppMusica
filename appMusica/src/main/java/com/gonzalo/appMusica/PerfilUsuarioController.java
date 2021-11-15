package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelos.Usuario;

public class PerfilUsuarioController {


	@FXML
	private Label NombreUsuario;
	@FXML
	private Label CorreoUsuario;
	@FXML
	private ImageView imageView1;
	
	private static  Usuario esteUsuario;


	@FXML
	protected void initialize() {
		
		
		
		escribirNombreEnLabel(esteUsuario);
		escribirCorreoEnLabel(esteUsuario);
		
		Image a = new Image(App.class.getResourceAsStream(esteUsuario.getFoto()));	//COPIAR IMAGEN DE CARPETA RESOURCES
		/*Image a = new Image(esteUsuario.getFoto());		COPIAR IMAGEN CON RUTA 
		"https://www.tonica.la/__export/1604187665799/sites/debate/img/2020/10/31/avatar-portada.jpg_423682103.jpg"
		DESCE INTERNET
		*/
		imageView1.setImage(a);
		
	}
	
	public static void setUsuario (Usuario u) {
		
		esteUsuario = u;	
    }

		 
	@FXML
	private void escribirNombreEnLabel (Usuario u) {
	   // ArtistaDAO art= new ArtistaDAO(a.getNombre(),a.getContraseña());
	    
	   
	    
    	NombreUsuario.setText(u.getNombre());
	
	}
	@FXML
	private void escribirCorreoEnLabel (Usuario u) {
		CorreoUsuario.setText(u.getCorreo());	
	}
	
	public void cambiarFoto() {
		try {
			App.loadScene(new Stage(), "ElegirFotoUsuario", "Cambiar foto");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

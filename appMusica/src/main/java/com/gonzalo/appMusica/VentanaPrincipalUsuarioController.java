package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelos.Usuario;

public class VentanaPrincipalUsuarioController {

	//private static Usuario u;
		@FXML
		private Label NombreUsuario;
		private static  Usuario usuario;
		
		@FXML
		protected void initialize() {
			escribirEnLabel(usuario);
		}
		@FXML
		private void escribirEnLabel (Usuario u) {
		    
	    	NombreUsuario.setText(u.getNombre());
		
		}
		
		public static void setUsuario (Usuario u) {
			
	    	usuario = u;	
	    }
		
		public void MiBiblioteca() {
			try {
				App.loadScene(new Stage(), "ListasRepUsuario", "Listas Rep Usuario ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void buscar() {
			try {
				App.loadScene(new Stage(), "VentanaBuscarDelUsuario", "Buscar ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void miPerfil() {
			try {
				
				App.loadScene(new Stage(), "PerfilUsuario", "Perfil Usaurio");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

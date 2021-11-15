package com.gonzalo.appMusica;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelos.Artista;

public class VentanaPrincipalArtistaController {

	//private static Usuario u;
		@FXML
		private Label NombreArtista;
		private static  Artista artista;
		
		@FXML
		protected void initialize() {
			escribirEnLabel(artista);
		}
		@FXML
		private void escribirEnLabel (Artista a) {
		    
	    	NombreArtista.setText(a.getNombre());
		
		}
		
		public static void setArtista (Artista a) {
			
	    	artista = a;	
	    }
		
		public void misDiscos() {
		
			try {
				App.loadScene(new Stage(), "VentanaMisDiscosArtista", "Ventana Mis Discos");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		public void miPerfil() {
			try {
				
				App.loadScene(new Stage(), "PerfilArtista", "Perfil Artista");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

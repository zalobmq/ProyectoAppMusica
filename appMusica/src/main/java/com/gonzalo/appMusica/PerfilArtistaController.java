package com.gonzalo.appMusica;

import dao.ArtistaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelos.Artista;

public class PerfilArtistaController {

	@FXML
	private Label NombreArtista;
	@FXML
	private Label NacionalidadArtista;
	@FXML
	private ImageView imageView1;
	
	
	private static  Artista esteArtista;


	@FXML
	protected void initialize() {
		
	
		
		escribirNombreEnLabel(esteArtista);
		escribirNacionalidadEnLabel(esteArtista);
		
		Image a = new Image(App.class.getResourceAsStream(esteArtista.getFoto()));
		
		imageView1.setImage(a);
	}
	
	public static void setArtista (Artista a) {
		
		esteArtista = a;	
    }
	
	/* 
	public  Artista infoArtistaBD(Artista a) {
		
		ArtistaDAO art = new ArtistaDAO();
		art.infoUsuario(esteArtista);
		return art;
		
	}
	
	*/
		 
	@FXML
	private void escribirNombreEnLabel (Artista a) {
	   // ArtistaDAO art= new ArtistaDAO(a.getNombre(),a.getContraseña());
	    
	   
	    
    	NombreArtista.setText(a.getNombre());
	
	}
	@FXML
	private void escribirNacionalidadEnLabel (Artista a) {
		NacionalidadArtista.setText(a.getNacionalidad());	
	}
	
	private void insertarFoto(String url) {
		
		
	}

}

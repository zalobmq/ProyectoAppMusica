package com.gonzalo.appMusica;

import java.io.IOException;

import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import dao.UsuarioDAO;
import modelos.Usuario;

public class ElegirFotoUsuarioController {

	private static  Usuario esteUsuario;

	@FXML
	private ImageView avatar1foto;
	@FXML
	private ImageView avatar2foto;
	@FXML
	private ImageView avatar3foto;
	@FXML
	private ImageView avatar4foto;
	
	
	@FXML
    protected void initialize () {
	
		Image a = new Image(App.class.getResourceAsStream("avatar1.png"));
		avatar1foto.setImage(a);
		Image b = new Image(App.class.getResourceAsStream("avatar2.png"));
		avatar2foto.setImage(b);
		Image c = new Image(App.class.getResourceAsStream("avatar3.png"));
		avatar3foto.setImage(c);
		Image d = new Image(App.class.getResourceAsStream("avatar4.png"));
		avatar4foto.setImage(d);
		
		
	}
	public static void setUsuario (Usuario u) {
		
		esteUsuario = u;	
    }
	
	public void cambiarAvatar1() {
		try {
			int id=esteUsuario.getId();
			UsuarioDAO usee = new UsuarioDAO();
			
			usee.cambiarFoto("avatar1.png",id);
			App.loadScene(new Stage(), "AvisoFoto", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cambiarAvatar2() {
		
		try {
			int id=esteUsuario.getId();
			UsuarioDAO usee = new UsuarioDAO();
			
			usee.cambiarFoto("avatar2.png",id);
			App.loadScene(new Stage(), "AvisoFoto", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cambiarAvatar3() {
		try {
			int id=esteUsuario.getId();
			UsuarioDAO usee = new UsuarioDAO();
			
			usee.cambiarFoto("avatar3.png",id);
			App.loadScene(new Stage(), "AvisoFoto", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cambiarAvatar4() {
		try {
			int id=esteUsuario.getId();
			UsuarioDAO usee = new UsuarioDAO();
			
			usee.cambiarFoto("avatar4.png",id);
			App.loadScene(new Stage(), "AvisoFoto", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

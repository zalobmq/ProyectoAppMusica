package com.gonzalo.appMusica;

import java.io.IOException;

import dao.ListaDeReproduccionDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Usuario;

public class CrearPlaylistController {

	//---
	private static  Usuario esteUsuario;
	//---
	
	@FXML
	private TextField nombre;
	@FXML
	private TextField descripcion;
	
	@FXML
	protected void initialize() {

	}
	
	public static void setUsuario (Usuario u) {
		
		esteUsuario = u;	
    }
	
	/*
	 * Crear una nueva playlist
	 */
	@FXML
	public void crearNuevaLista() {
	//System.out.println(esteUsuario.toString());
		ListaDeReproduccionDAO nuevaLista = new ListaDeReproduccionDAO();
		
		nuevaLista.setNombre(nombre.getText());
		nuevaLista.setDescripcion(descripcion.getText());
		nuevaLista.setId_usuario(esteUsuario.getId());
		
		nuevaLista.añadir();
		
		try {
			App.loadScene(new Stage(), "ListasRepUsuario", "Listas Rep Usuario ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

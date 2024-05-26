package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Vista.Vista;

public class Modelo {
	private Vista[] miVista;

	public void setVista(Vista[] miVista) {
		this.miVista = miVista;
	}

	public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
		return ConexionBaseDeDatos.verificarUsuario(nombreUsuario, contrasena);
	}
	
	public boolean verificarUsuarioExistente(String nickname) {
		return ConexionBaseDeDatos.verificarUsuarioExistente(nickname);
	}

	public int registrarUsuario(String nick, String apellido, String nombre, String pwd) {
		return ConexionBaseDeDatos.registrarUsuario(nick, nombre, apellido, pwd, null, null);
	}
}

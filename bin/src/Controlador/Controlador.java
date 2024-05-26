package Controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {
	private JFrame frame;
	private Modelo miModelo;
	private Vista[] misVistas;

	public void setVista(Vista[] miVista) {
		this.misVistas = miVista;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);

	}

	public void LoginUsuario(String nombre, String apellidos, String nickname, String tipoUsuario, String pregunta,
			String respuesta, String password) {

	}
	
	public void registrarUsuario(String nickname, String nombre, String apellidos, String cp, String pwd, String preguntaSeguridad, String respuestaSeguridad, String preguntaCodigo) {
        int resultado = miModelo.registrarUsuario(nickname, nombre, apellidos, cp);
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
        }
    }

	public boolean verificarUsuarioExistente(String nickname) {
		return miModelo.verificarUsuarioExistente(nickname);
	}

}

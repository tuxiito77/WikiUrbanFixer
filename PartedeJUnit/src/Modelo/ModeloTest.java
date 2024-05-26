package Modelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import Vista.Vista;

public class ModeloTest {

	private Modelo modelo;
	private Vista[] vistasMock;

	@Before
	public void setUp() {
		modelo = new Modelo();
		vistasMock = new Vista[2];
		for (int i = 0; i < vistasMock.length; i++) {
			vistasMock[i] = mock(Vista.class);
		}
		modelo.setVista(vistasMock);
	}

	@Test
	public void testVerificarCredenciales() {
		// Arrange
		String nombreUsuario = "usuario";
		String contraseña = "contraseña";
		when(ConexionBaseDeDatos.verificarUsuario(nombreUsuario, contraseña)).thenReturn(true);

		// Act
		boolean resultado = modelo.verificarCredenciales(nombreUsuario, contraseña);

		// Assert
		assertTrue(resultado);
	}

	@Test
	public void testVerificarUsuarioExistente() {
		// Arrange
		String nickname = "usuario";
		when(ConexionBaseDeDatos.verificarUsuarioExistente(nickname)).thenReturn(true);

		// Act
		boolean resultado = modelo.verificarUsuarioExistente(nickname);

		// Assert
		assertTrue(resultado);
	}

	@Test
	public void testRegistrarUsuario() {
		// Arrange
		String nick = "usuario";
		String apellido = "Apellido";
		String nombre = "Nombre";
		String pwd = "contraseña";
		String cp = "12345";
		int idEsperado = 123;
		when(ConexionBaseDeDatos.registrarUsuario(nick, nombre, apellido, pwd, null, null, cp)).thenReturn(idEsperado);

		// Act
		int idResultado = modelo.registrarUsuario(nick, apellido, nombre, pwd, cp);

		// Assert
		assertEquals(idEsperado, idResultado);
	}
}

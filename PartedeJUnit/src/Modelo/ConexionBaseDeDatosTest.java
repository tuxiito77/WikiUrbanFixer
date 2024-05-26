package Modelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class ConexionBaseDeDatosTest {

	private ConexionBaseDeDatos conexion;
	private Connection connectionMock;

	@Before
	public void setUp() {
		conexion = new ConexionBaseDeDatos();
		connectionMock = mock(Connection.class);
		ConexionBaseDeDatos.conexion = connectionMock;
	}

	@Test
	public void testVerificarUsuario() throws SQLException {
		// Arrange
		String nick = "usuario";
		String pwd = "contraseña";
		String query = "SELECT COUNT(*) FROM PABLO.Usuario WHERE Nick = ? AND Pwd = ?";
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);
		when(connectionMock.prepareStatement(query)).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt(1)).thenReturn(1);

		// Act
		boolean resultado = conexion.verificarUsuario(nick, pwd);

		// Assert
		assertTrue(resultado);
	}

	@Test
	public void testRegistrarUsuario() throws SQLException {
		// Arrange
		String nick = "usuario";
		String nombre = "Nombre";
		String apellido = "Apellido";
		String pwd = "contraseña";
		String pregunta = "Pregunta";
		String respuesta = "Respuesta";
		String cp = "12345";
		String query = "INSERT INTO PABLO.Usuario (Nick, nombre, apellido, Pwd, pregunta, respuesta, CP) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statementMock = mock(PreparedStatement.class);
		when(connectionMock.prepareStatement(query)).thenReturn(statementMock);
		when(statementMock.executeUpdate()).thenReturn(1);

		// Act
		int resultado = ConexionBaseDeDatos.registrarUsuario(nick, nombre, apellido, pwd, pregunta, respuesta, cp);

		// Assert
		assertEquals(1, resultado);
	}

	@Test
	public void testVerificarUsuarioExistente() throws SQLException {
		// Arrange
		String nickname = "usuario";
		String query = "SELECT COUNT(*) FROM PABLO.Usuario WHERE Nick = ?";
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);
		when(connectionMock.prepareStatement(query)).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt(1)).thenReturn(1);

		// Act
		boolean resultado = ConexionBaseDeDatos.verificarUsuarioExistente(nickname);

		// Assert
		assertTrue(resultado);
	}
}

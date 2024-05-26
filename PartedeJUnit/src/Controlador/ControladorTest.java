package Controlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import javax.swing.JFrame;

import Modelo.Modelo;
import Vista.Vista;

import org.junit.Before;
import org.junit.Test;

public class ControladorTest {

    private Controlador controlador;
    private Modelo modeloMock;
    private Vista[] vistasMock;

    @Before
    public void setUp() {
        controlador = new Controlador();
        modeloMock = mock(Modelo.class);
        vistasMock = new Vista[10];

        for (int i = 0; i < vistasMock.length; i++) {
            vistasMock[i] = mock(Vista.class);
        }

        controlador.setModelo(modeloMock);
        controlador.setVista(vistasMock);
    }

    @Test
    public void testCambiarVentana() {
        // Arrange
        int desde = 0;
        int hasta = 1;
        JFrame frameDesde = mock(JFrame.class);
        JFrame frameHasta = mock(JFrame.class);

        when(vistasMock[desde]).thenReturn(frameDesde);
        when(vistasMock[hasta]).thenReturn(frameHasta);

        // Act
        controlador.cambiarVentana(desde, hasta);

        // Assert
        verify(frameDesde).setVisible(false);
        verify(frameHasta).setVisible(true);
    }

    @Test
    public void testRegistrarUsuario_Success() throws SQLException {
        // Arrange
        String nick = "usuario";
        String apellido = "Apellido";
        String nombre = "Nombre";
        String pwd = "password";
        String cp = "12345";

        // Mock para la conexión de la base de datos
        Modelo.ConexionBaseDeDatos conexionMock = mock(Modelo.ConexionBaseDeDatos.class);
        when(Modelo.ConexionBaseDeDatos.getConnection()).thenReturn(conexionMock);

        // Act
        boolean result = controlador.registrarUsuario(nick, apellido, nombre, pwd, cp);

        // Assert
        assertTrue(result);
        verify(conexionMock).prepareStatement(anyString());
    }

    @Test
    public void testRegistrarUsuario_Failure() throws SQLException {
        // Arrange
        String nick = "usuario";
        String apellido = "Apellido";
        String nombre = "Nombre";
        String pwd = "password";
        String cp = "12345";

        // Mock para la conexión de la base de datos
        Modelo.ConexionBaseDeDatos conexionMock = mock(Modelo.ConexionBaseDeDatos.class);
        when(Modelo.ConexionBaseDeDatos.getConnection()).thenReturn(conexionMock);

        // Simular SQLException
        when(conexionMock.prepareStatement(anyString())).thenThrow(new SQLException());

        // Act
        boolean result = controlador.registrarUsuario(nick, apellido, nombre, pwd, cp);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testVerificarUsuarioExistente() {
        // Arrange
        String nickname = "usuario";

        // Simular comportamiento del modelo
        when(modeloMock.verificarUsuarioExistente(nickname)).thenReturn(true);

        // Act
        boolean result = controlador.verificarUsuarioExistente(nickname);

        // Assert
        assertTrue(result);
    }
}

package Controlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import Modelo.Modelo;
import Vista.Vista;
import Vista._00_Login;
import Vista._01_Registro;
import Vista._02_OlvidoPwd;
import Vista._03_PantallaUsrAdmDenuncia;
import Vista._04_AlertaDenuncia;
import Vista._05_EstadoDenuncia;
import Vista._06_DenunciasFavUsrAdm;
import Vista._07_PantallaAdmin;
import Vista._08_AjustesUsrAdm;
import Vista._09_CambiarPwd;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

	private Controlador controladorMock;
	private Modelo modeloMock;
	private Vista[] vistasMock;

	@Before
	public void setUp() {
		controladorMock = mock(Controlador.class);
		modeloMock = mock(Modelo.class);
		vistasMock = new Vista[10];

		vistasMock[0] = mock(_00_Login.class);
		vistasMock[1] = mock(_01_Registro.class);
		vistasMock[2] = mock(_02_OlvidoPwd.class);
		vistasMock[3] = mock(_03_PantallaUsrAdmDenuncia.class);
		vistasMock[4] = mock(_04_AlertaDenuncia.class);
		vistasMock[5] = mock(_05_EstadoDenuncia.class);
		vistasMock[6] = mock(_06_DenunciasFavUsrAdm.class);
		vistasMock[7] = mock(_07_PantallaAdmin.class);
		vistasMock[8] = mock(_08_AjustesUsrAdm.class);
		vistasMock[9] = mock(_09_CambiarPwd.class);
	}

	@Test
    public void testMain() {
        // Arrange
        when(vistasMock[0].getModelo()).thenReturn(modeloMock);
        when(vistasMock[1].getModelo()).thenReturn(modeloMock);
        when(vistasMock[2].getModelo()).thenReturn(modeloMock);
        when(vistasMock[3].getModelo()).thenReturn(modeloMock);
        when(vistasMock[4].getModelo()).thenReturn(modeloMock);
        when(vistasMock[5].getModelo()).thenReturn(modeloMock);
        when(vistasMock[6].getModelo()).thenReturn(modeloMock);
        when(vistasMock[7].getModelo()).thenReturn(modeloMock);
        when(vistasMock[8].getModelo()).thenReturn(modeloMock);
        when(vistasMock[9].getModelo()).thenReturn(modeloMock);

        when(vistasMock[0].getControlador()).thenReturn(controladorMock);
        when(vistasMock[1].getControlador()).thenReturn(controladorMock);
        when(vistasMock[2].getControlador()).thenReturn(controladorMock);
        when(vistasMock[3].getControlador()).thenReturn(controladorMock);
        when(vistasMock[4].getControlador()).thenReturn(controladorMock);
        when(vistasMock[5].getControlador()).thenReturn(controladorMock);
        when(vistasMock[6].getControlador()).thenReturn(controladorMock);
        when(vistasMock[7].getControlador()).thenReturn(controladorMock);
        when(vistasMock[8].getControlador()).thenReturn(controladorMock);
        when(vistasMock[9].getControlador()).thenReturn(controladorMock);

        // Act
        Main.main(null);

        // Assert
        verify(controladorMock).setModelo(modeloMock);
        verify(modeloMock).setVista(vistasMock);

        for (Vista vista : vistasMock) {
            verify(vista).setModelo(modeloMock);
            verify(vista).setControlador(controladorMock);
        }
    }
}

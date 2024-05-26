import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _01_RegistroTest {

	private _01_Registro vista;
	private Controlador controladorMock;
	private Modelo modeloMock;

	@Before
	public void setUp() {
		vista = new _01_Registro();
		controladorMock = Mockito.mock(Controlador.class);
		modeloMock = Mockito.mock(Modelo.class);
		vista.setControlador(controladorMock);
		vista.setModelo(modeloMock);
	}

	@Test
	public void testInicializacion() {
		assertNotNull(vista);
		assertTrue(vista.isVisible()); // La ventana debe ser visible al principio
	}

	@Test
	public void testRegistroExitoso() {
		Mockito.when(controladorMock.verificarUsuarioExistente(Mockito.anyString())).thenReturn(false);
		Mockito.when(controladorMock.registrarUsuario(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString(), Mockito.anyString())).thenReturn(true);

		vista.getTxtNombre().setText("Nombre");
		vista.getTxtApellidos().setText("Apellidos");
		vista.getTxtNickname().setText("nickname");
		vista.getComboTipoUsuario().setSelectedItem("Usuario");
		vista.getComboPreguntas().setSelectedItem("¿Cuál es tu comida favorita?");
		vista.getTxtRespuesta().setText("Respuesta");
		vista.getTxtPassword().setText("contrasena");
		vista.getTxtPasswordRepeat().setText("contrasena");

		vista.getBtnEnviar().doClick();

		Mockito.verify(controladorMock).verificarUsuarioExistente("nickname");
		Mockito.verify(controladorMock).registrarUsuario("nickname", "Apellidos", "Nombre", "contrasena", "contrasena");
		Mockito.verify(controladorMock).cambiarVentana(1, 0);
		assertFalse(vista.isVisible()); // Verificamos que la ventana se ha cerrado
	}

	@Test
	public void testRegistroFallido() {
		Mockito.when(controladorMock.verificarUsuarioExistente(Mockito.anyString())).thenReturn(true);

		vista.getTxtNickname().setText("nickname");

		vista.getBtnEnviar().doClick();

		Mockito.verify(controladorMock).verificarUsuarioExistente("nickname");
		Mockito.verify(controladorMock, Mockito.never()).registrarUsuario(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		assertTrue(vista.isVisible()); // La ventana debe seguir visible
	}
}

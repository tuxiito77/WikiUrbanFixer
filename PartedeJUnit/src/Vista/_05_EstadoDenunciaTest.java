import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _05_EstadoDenunciaTest {

	private _05_EstadoDenuncia vista;
	private Controlador controladorMock;
	private Modelo modeloMock;

	@Before
	public void setUp() {
		vista = new _05_EstadoDenuncia();
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
	public void testAjustesUsuario() {
		vista.getBtnAjustesUsuario().doClick();
		Mockito.verify(controladorMock).cambiarVentana(5, 8);
	}

	@Test
	public void testDenunciasFavoritas() {
		vista.getBtnDenunciasFavoritas().doClick();
		Mockito.verify(controladorMock).cambiarVentana(5, 6);
	}

	@Test
	public void testDenunciarProblema() {
		vista.getBtnDenunciarProblema().doClick();
		Mockito.verify(controladorMock).cambiarVentana(5, 3);
	}
}

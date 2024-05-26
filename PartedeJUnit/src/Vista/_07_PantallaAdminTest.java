import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _07_PantallaAdminTest {

	private _07_PantallaAdmin vista;
	private Controlador controladorMock;
	private Modelo modeloMock;

	@Before
	public void setUp() {
		vista = new _07_PantallaAdmin();
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
	public void testAjustesAdministrador() {
		vista.getBtnAjustesAdministrador().doClick();
		Mockito.verify(controladorMock).cambiarVentana(7, 8);
	}

	@Test
	public void testDenunciasFavoritasAdmin() {
		vista.getBtnDenunciasFavoritasAdmin().doClick();
		Mockito.verify(controladorMock).cambiarVentana(7, 6);
	}

	@Test
	public void testDenunciarProblemaAdmin() {
		vista.getBtnDenunciarProblemaAdmin().doClick();
		Mockito.verify(controladorMock).cambiarVentana(7, 3);
	}
}

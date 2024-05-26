import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _04_AlertaDenunciaTest {

	private _04_AlertaDenuncia vista;
	private Controlador controladorMock;
	private Modelo modeloMock;

	@Before
	public void setUp() {
		vista = new _04_AlertaDenuncia();
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
	public void testConfirmarDenuncia() {
		vista.getTextFieldCodigoPostal().setText("12345");
		vista.getTextAreaDescripcion().setText("Descripción de la denuncia");

		vista.getBtnSi().doClick();

		Mockito.verify(controladorMock).cambiarVentana(4, 3);
	}

	@Test
	public void testCancelarDenuncia() {
		vista.getBtnNo().doClick();

		Mockito.verify(controladorMock).cambiarVentana(3, 5);
	}
}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _03_PantallaUsrAdmDenunciaTest {

	private _03_PantallaUsrAdmDenuncia vista;
	private Controlador controladorMock;
	private Modelo modeloMock;

	@Before
	public void setUp() {
		vista = new _03_PantallaUsrAdmDenuncia();
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
	public void testEnviarDenuncia() {
		vista.getTextField().setText("Nombre del problema");
		vista.getTextFieldCodigoPostal().setText("12345");
		vista.getTextFieldDescripcion().setText("Descripción del problema");
		vista.getComboBoxCategoria().setSelectedItem("Normal");

		vista.getBtnEnviarDenuncia().doClick();

		Mockito.verify(controladorMock).cambiarVentana(3, 4);
	}
}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _08_AjustesUsrAdmTest {
    
    private _08_AjustesUsrAdm vista;
    private Controlador controladorMock;
    private Modelo modeloMock;

    @Before
    public void setUp() {
        vista = new _08_AjustesUsrAdm();
        controladorMock = Mockito.mock(Controlador.class);
        modeloMock = Mockito.mock(Modelo.class);
        vista.setControlador(controladorMock);
        vista.setModelo(modeloMock);
    }

    @Test
    public void testInicializacion() {
        assertNotNull(vista);
        assertFalse(vista.isVisible()); // La ventana no debe ser visible al principio
    }

    @Test
    public void testAccionBotonAtras() {
        vista.setVisible(true); // Hacemos visible la ventana
        vista.getBtnAtras().doClick(); // Simulamos hacer clic en el botón "Atrás"
        Mockito.verify(controladorMock).cambiarVentana(7, 3); // Verificamos que se llama al método de cambiar ventana del controlador
        assertFalse(vista.isVisible()); // Verificamos que la ventana se ha cerrado
    }
}

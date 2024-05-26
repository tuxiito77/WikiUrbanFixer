import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _02_OlvidoPwdTest {
    
    private _02_OlvidoPwd vista;
    private Controlador controladorMock;
    private Modelo modeloMock;

    @Before
    public void setUp() {
        vista = new _02_OlvidoPwd();
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
    public void testEnvioRespuestaExitoso() {
        Mockito.when(controladorMock.verificarRespuestaSeguridad(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        
        vista.getComboBoxQuestions().setSelectedItem("Nombre de tu primera mascota");
        vista.getTextFieldAnswer().setText("expectedAnswer1");
        vista.getBtnSubmit().doClick();
        
        Mockito.verify(controladorMock).verificarRespuestaSeguridad("Nombre de tu primera mascota", "expectedAnswer1");
        Mockito.verify(controladorMock).cambiarVentana(2, 9);
        assertFalse(vista.isVisible()); // Verificamos que la ventana se ha cerrado
    }

    @Test
    public void testEnvioRespuestaFallido() {
        Mockito.when(controladorMock.verificarRespuestaSeguridad(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        
        vista.getComboBoxQuestions().setSelectedItem("Nombre de tu primera mascota");
        vista.getTextFieldAnswer().setText("respuestaIncorrecta");
        vista.getBtnSubmit().doClick();
        
        Mockito.verify(controladorMock).verificarRespuestaSeguridad("Nombre de tu primera mascota", "respuestaIncorrecta");
        Mockito.verify(controladorMock, Mockito.never()).cambiarVentana(Mockito.anyInt(), Mockito.anyInt());
        assertTrue(vista.isVisible()); // La ventana debe seguir visible
    }
}

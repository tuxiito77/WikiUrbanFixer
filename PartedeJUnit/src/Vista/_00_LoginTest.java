import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Controlador.Controlador;
import Modelo.Modelo;

public class _00_LoginTest {
    
    private _00_Login vista;
    private Controlador controladorMock;
    private Modelo modeloMock;

    @Before
    public void setUp() {
        vista = new _00_Login();
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
    public void testIntentarLoginExitoso() {
        Mockito.when(modeloMock.verificarCredenciales(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        
        vista.getTxtNickname().setText("usuario");
        vista.getTxtPassword().setText("contrasena");
        vista.intentarLogin();
        
        Mockito.verify(modeloMock).verificarCredenciales("usuario", "contrasena");
        Mockito.verify(controladorMock).cambiarVentana(0, 3);
        assertFalse(vista.isVisible()); // Verificamos que la ventana se ha cerrado
    }

    @Test
    public void testIntentarLoginFallido() {
        Mockito.when(modeloMock.verificarCredenciales(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        
        vista.getTxtNickname().setText("usuario");
        vista.getTxtPassword().setText("contrasena");
        vista.intentarLogin();
        
        Mockito.verify(modeloMock).verificarCredenciales("usuario", "contrasena");
        Mockito.verify(controladorMock, Mockito.never()).cambiarVentana(Mockito.anyInt(), Mockito.anyInt());
        assertTrue(vista.isVisible()); // La ventana debe seguir visible
    }
}

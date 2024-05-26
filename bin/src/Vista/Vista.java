package Vista;

import Controlador.Controlador;
import Modelo.Modelo;

/**
 * The Vista interface defines the common methods for view classes.
 */
public interface Vista {

    /**
     * Sets the controller object for the view.
     *
     * @param miControlador The controller to set.
     */
    public void setControlador(Controlador miControlador);

    /**
     * Sets the model object for the view.
     *
     * @param miModelo The model to set.
     */
    public void setModelo(Modelo miModelo);
}

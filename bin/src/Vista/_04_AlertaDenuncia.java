package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta clase representa la ventana de alerta de denuncia en la aplicación Urban Fixer.
 * Permite al usuario confirmar si se refiere a una denuncia existente.
 */
public class _04_AlertaDenuncia extends JFrame implements Vista {
    private JPanel contentPane;
    private JTextField textFieldCodigoPostal;
    private JTextArea textAreaDescripcion;
    
    private Controlador controlador;
    private Modelo modelo;
    
    /**
     * Establece el controlador para esta vista.
     * @param controlador El controlador que manejará las interacciones del usuario.
     */
    public void setControlador(Controlador controlador) {
    	this.controlador = controlador;
    }
    
    /**
     * Establece el modelo para esta vista.
     * @param modelo El modelo que proporcionará los datos necesarios para la vista.
     */
    public void setModelo(Modelo modelo) {
    	this.modelo = modelo;
    }

    /**
     * Crea una nueva instancia de la ventana de alerta de denuncia.
     * Inicializa los componentes de la interfaz de usuario.
     */
    public _04_AlertaDenuncia() {
        initialize();
    }

    /**
     * Inicializa los componentes de la interfaz de usuario y configura la ventana.
     */
    private void initialize() {
        setTitle("Urban Fixer - Alerta Denuncia");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMensajeAlerta = new JLabel("Este problema ya ha sido denunciado");
        lblMensajeAlerta.setBounds(10, 36, 464, 14);
        contentPane.add(lblMensajeAlerta);

        JLabel lblPregunta = new JLabel("¿Te refieres a esta denuncia?");
        lblPregunta.setBounds(10, 61, 300, 14);
        contentPane.add(lblPregunta);

        JLabel lblFotoDelProblema = new JLabel("Foto del problema:");
        lblFotoDelProblema.setBounds(10, 86, 180, 14);
        contentPane.add(lblFotoDelProblema);

        JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
        lblCodigoPostal.setBounds(10, 197, 100, 14);
        contentPane.add(lblCodigoPostal);

        textFieldCodigoPostal = new JTextField();
        textFieldCodigoPostal.setBounds(120, 194, 150, 20);
        contentPane.add(textFieldCodigoPostal);
        textFieldCodigoPostal.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripción de la denuncia:");
        lblDescripcion.setBounds(10, 228, 180, 14);
        contentPane.add(lblDescripcion);

        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setBounds(10, 253, 464, 60);
        contentPane.add(textAreaDescripcion);

        JButton btnSi = new JButton("Si");
        btnSi.setBounds(120, 324, 89, 23);
        contentPane.add(btnSi);
        btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(4, 3); 
			}
		});

        JButton btnNo = new JButton("No");
        btnNo.setBounds(250, 324, 89, 23);
        contentPane.add(btnNo);
        btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(3, 5); 
			}
		});
    }
}



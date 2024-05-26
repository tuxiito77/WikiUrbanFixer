package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La clase _02_OlvidoPwd representa la ventana de recuperación de contraseña en la aplicación Urban Fixer.
 * Permite a los usuarios recuperar su contraseña proporcionando la respuesta a una pregunta de seguridad.
 */
public class _02_OlvidoPwd extends JFrame implements Vista {

    private JPanel contentPane; // Panel principal de la ventana
    private JTextField textFieldAnswer; // Campo de texto para ingresar la respuesta
    private JComboBox<String> comboBoxQuestions; // Lista desplegable para seleccionar la pregunta de seguridad

    private Controlador controlador; // Referencia al controlador
    private Modelo modelo; // Referencia al modelo

    /**
     * Establece el controlador de la vista.
     * 
     * @param controlador El controlador a establecer.
     */
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    /**
     * Establece el modelo de la vista.
     * 
     * @param modelo El modelo a establecer.
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * Constructor de la clase _02_OlvidoPwd.
     * Inicializa la ventana de recuperación de contraseña y sus componentes.
     */
    public _02_OlvidoPwd() {
        setTitle("Urban Fixer - He olvidado contraseña");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta y lista desplegable para seleccionar la pregunta de seguridad
        JLabel lblSelectQuestion = new JLabel("Seleccione una pregunta:");
        lblSelectQuestion.setBounds(50, 30, 200, 14);
        contentPane.add(lblSelectQuestion);

        comboBoxQuestions = new JComboBox<>();
        comboBoxQuestions.setBounds(50, 55, 300, 20);
        comboBoxQuestions.addItem("Nombre de tu primera mascota");
        comboBoxQuestions.addItem("¿Qué mote tenías de pequeño?");
        comboBoxQuestions.addItem("¿Cuál es tu comida favorita?");
        comboBoxQuestions.addItem("País al que te gustaría viajar");
        comboBoxQuestions.addItem("Ciudad de nacimiento");
        contentPane.add(comboBoxQuestions);

        // Etiqueta y campo de texto para ingresar la respuesta
        JLabel lblQuestion = new JLabel("Respuesta:");
        lblQuestion.setBounds(50, 95, 200, 14);
        contentPane.add(lblQuestion);

        textFieldAnswer = new JTextField();
        textFieldAnswer.setBounds(50, 120, 300, 20);
        contentPane.add(textFieldAnswer);
        textFieldAnswer.setColumns(10);

        // Botón para enviar la respuesta y continuar
        JButton btnSubmit = new JButton("Aceptar");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedQuestion = (String) comboBoxQuestions.getSelectedItem();
                String answer = textFieldAnswer.getText();
                    controlador.cambiarVentana(2, 9);

                // Se espera comparar la respuesta ingresada con la respuesta esperada en la base de datos
                String expectedAnswer = "";
                switch (selectedQuestion) {
                    case "Nombre de tu primera mascota":
                        expectedAnswer = "expectedAnswer1";
                        break;
                    case "¿Qué mote tenías de pequeño?":
                        expectedAnswer = "expectedAnswer2";
                        break;
                    case "¿Cuál es tu comida favorita?":
                        expectedAnswer = "expectedAnswer3";
                        break;
                    case "País al que te gustaría viajar":
                        expectedAnswer = "expectedAnswer4";
                        break;
                    case "Ciudad de nacimiento":
                        expectedAnswer = "expectedAnswer5";
                        break;
                }
            }
        });
        btnSubmit.setBounds(250, 163, 100, 23);
        contentPane.add(btnSubmit);

        // Botón para regresar a la ventana anterior
        JButton btnBack = new JButton("Atrás");
        btnBack.setBounds(50, 163, 100, 23);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(2, 0);
            }
        });
        contentPane.add(btnBack);
    }
}

package Vista;

import javax.swing.*;

import Controlador.Controlador;
import Modelo.Modelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la vista de registro de usuario.
 */
public class _01_Registro extends JFrame implements Vista {
    // Campo de texto para el nombre del usuario
    private JTextField txtNombre;

    // Campo de texto para los apellidos del usuario
    private JTextField txtApellidos;

    // Campo de texto para el nombre de usuario deseado
    private JTextField txtNickname;

    // Campo de contraseña para la contraseña del usuario
    private JPasswordField txtPassword;

    // Campo de contraseña para repetir la contraseña ingresada
    private JPasswordField txtPasswordRepeat;

    // Campo de texto para ingresar la respuesta a la pregunta de seguridad
    private JTextField txtRespuesta;

    // Lista desplegable para seleccionar el tipo de usuario
    private JComboBox<String> comboTipoUsuario;

    // Lista desplegable para seleccionar la pregunta de seguridad
    private JComboBox<String> comboPreguntas;

    // Referencia al controlador
    private Controlador controlador;

    // Referencia al modelo
    private Modelo modelo;

    /**
     * Establece el controlador para esta vista.
     * 
     * @param controlador El controlador para establecer.
     */
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Establece el modelo para esta vista.
     * 
     * @param modelo El modelo para establecer.
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * Constructor para la vista de registro de usuario.
     */
    public _01_Registro() {
        setTitle("Urban Fixer - Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(99, 0, 600, 563);
        getContentPane().add(panel);

        JLabel lblTitle = new JLabel("Registro de Usuario");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(173, 10, 300, 30);
        panel.add(lblTitle);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50, 70, 100, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(250, 70, 250, 25);
        panel.add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellido");
        lblApellidos.setBounds(50, 110, 100, 25);
        panel.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(250, 110, 250, 25);
        panel.add(txtApellidos);

        JLabel lblNickname = new JLabel("Nickname");
        lblNickname.setBounds(50, 150, 100, 25);
        panel.add(lblNickname);

        txtNickname = new JTextField();
        txtNickname.setBounds(250, 150, 250, 25);
        panel.add(txtNickname);

        JLabel lblTipoUsuario = new JLabel("Tipo de usuario");
        lblTipoUsuario.setBounds(50, 190, 100, 25);
        panel.add(lblTipoUsuario);

        comboTipoUsuario = new JComboBox<>();
        comboTipoUsuario.addItem("Administrador");
        comboTipoUsuario.addItem("Usuario");
        comboTipoUsuario.setBounds(250, 190, 250, 25);
        panel.add(comboTipoUsuario);

        JLabel lblPreguntas = new JLabel("Preguntas en caso de olvidar la contraseña");
        lblPreguntas.setBounds(50, 230, 250, 25);
        panel.add(lblPreguntas);

        comboPreguntas = new JComboBox<>();
        comboPreguntas.addItem("Nombre de tu primera mascota");
        comboPreguntas.addItem("¿Qué mote tenías de pequeño?");
        comboPreguntas.addItem("¿Cuál es tu comida favorita?");
        comboPreguntas.addItem("País al que te gustaría viajar");
        comboPreguntas.addItem("Ciudad de nacimiento");
        comboPreguntas.setBounds(250, 260, 250, 25);
        panel.add(comboPreguntas);

        JLabel lblRespuesta = new JLabel("Respuesta");
        lblRespuesta.setBounds(50, 300, 100, 25);
        panel.add(lblRespuesta);

        txtRespuesta = new JTextField();
        txtRespuesta.setBounds(250, 300, 250, 25);
        panel.add(txtRespuesta);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setBounds(50, 340, 100, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(250, 340, 250, 25);
        panel.add(txtPassword);

        JLabel lblPasswordRepeat = new JLabel("Repetir contraseña");
        lblPasswordRepeat.setBounds(50, 380, 150, 25);
        panel.add(lblPasswordRepeat);

        txtPasswordRepeat = new JPasswordField();
        txtPasswordRepeat.setBounds(250, 380, 250, 25);
        panel.add(txtPasswordRepeat);

        JCheckBox chckbxTerms = new JCheckBox("Acepto condiciones y términos");
        chckbxTerms.setBounds(50, 420, 250, 25);
        panel.add(chckbxTerms);

        JCheckBox chckbxAge = new JCheckBox("Soy mayor de 14 años");
        chckbxAge.setBounds(50, 450, 250, 25);
        panel.add(chckbxAge);

        JCheckBox chckbxNotRobot = new JCheckBox("No soy un robot");
        chckbxNotRobot.setBounds(50, 480, 250, 25);
        panel.add(chckbxNotRobot);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(250, 520, 100, 30);
        panel.add(btnEnviar);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	  String nombre = txtNombre.getText();
                  String apellidos = txtApellidos.getText();
                  String nickname = txtNickname.getText();
                  String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();
                  String pregunta = (String) comboPreguntas.getSelectedItem();
                  String respuesta = txtRespuesta.getText();
                  String password = new String(txtPassword.getPassword());
                  String passwordRepeat = new String(txtPasswordRepeat.getPassword());

                  // Verificación de campos vacíos
                  if (nombre.isEmpty() || apellidos.isEmpty() || nickname.isEmpty() || 
                      tipoUsuario.isEmpty() || pregunta.isEmpty() || respuesta.isEmpty() || 
                      password.isEmpty() || passwordRepeat.isEmpty()) {
                      JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
                      return;
                  }

                  // Verificación de que las contraseñas coincidan
                  if (!password.equals(passwordRepeat)) {
                      JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
                      return;
                  }
                  // Verificar si el usuario ya existe
                  if (controlador.verificarUsuarioExistente(nickname)) {
                      JOptionPane.showMessageDialog(null, "El nickname ya está en uso.");
                      return;
                  }

                  // Llamar al método del controlador para guardar en la base de datos
                  controlador.LoginUsuario(nombre, apellidos, nickname, tipoUsuario, pregunta, respuesta, password);
              }
          });


        JButton btnBack = new JButton("Atrás");
        btnBack.setBounds(50, 520, 100, 30);
        panel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(1, 0);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Método principal para ejecutar la aplicación.
     * Crea una instancia del registro y la muestra.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _01_Registro frame = new _01_Registro();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


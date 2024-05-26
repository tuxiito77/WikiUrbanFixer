package Vista;

import javax.swing.*;
import Controlador.Controlador;
import Modelo.Modelo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase _00_Login representa la ventana de inicio de sesión de la aplicación Urban Fixer.
 * Permite a los usuarios iniciar sesión, registrarse o recuperar su contraseña.
 */
public class _00_Login extends JFrame implements Vista {
    private JTextField txtNickname; // Campo de texto para el nickname
    private JPasswordField txtPassword; // Campo de contraseña
    private Controlador controlador; // Controlador para manejar la interacción entre la vista y el modelo
    private Modelo modelo; // Modelo que contiene la lógica de negocio de la aplicación
    private JLabel lblLogo; // Etiqueta para mostrar el logo de la aplicación
    private int intentos = 0; // Contador de intentos de inicio de sesión

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
     * Constructor de la clase _00_Login.
     * Inicializa la ventana de inicio de sesión y sus componentes.
     */
    public _00_Login() {
        setTitle("Urban Fixer"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define la operación de cierre al cerrar la ventana
        setSize(800, 600); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setLayout(null); // Establece el layout a nulo para posicionar los componentes manualmente

        // Etiqueta del título
        JLabel lblTitle = new JLabel("Urban Fixer");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(300, 50, 200, 30);
        getContentPane().add(lblTitle);

        // Logotipo
        ImageIcon logo = new ImageIcon(new ImageIcon(this.getClass().getResource("/logo.png")).getImage()
                .getScaledInstance(170, 65, Image.SCALE_SMOOTH));
        lblLogo = new JLabel(logo);
        lblLogo.setBounds(315, 100, 170, 65);
        getContentPane().add(lblLogo);

        // Etiqueta de Nickname y campo de texto
        JLabel lblNickname = new JLabel("Nickname");
        lblNickname.setBounds(200, 173, 80, 14);
        getContentPane().add(lblNickname);

        txtNickname = new JTextField();
        txtNickname.setBounds(300, 171, 180, 20);
        getContentPane().add(txtNickname);
        txtNickname.setColumns(10);

        // Etiqueta de Contraseña y campo de contraseña
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setBounds(200, 226, 80, 14);
        getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(300, 224, 180, 20);
        getContentPane().add(txtPassword);

        // Botón de Iniciar sesión
        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                intentarLogin();
            }
        });
        btnLogin.setBounds(327, 273, 120, 23);
        getContentPane().add(btnLogin);

        // Etiqueta de Olvidaste tu contraseña
        JLabel lblForgotPassword = new JLabel("¿Has olvidado tu contraseña?");
        lblForgotPassword.setForeground(Color.BLUE);
        lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblForgotPassword.setBounds(328, 325, 200, 14);
        getContentPane().add(lblForgotPassword);
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controlador.cambiarVentana(0, 2);
            }
        });

        // Etiqueta de Registrarse
        JLabel lblRegister = new JLabel("Registrarse");
        lblRegister.setForeground(Color.BLUE);
        lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegister.setBounds(328, 371, 80, 14);
        getContentPane().add(lblRegister);
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controlador.cambiarVentana(0, 1);
            }
        });

        // Botón de Soy Admin
        JButton btnSoyAdmin = new JButton("Soy Admin");
        btnSoyAdmin.setBounds(323, 395, 124, 21);
        getContentPane().add(btnSoyAdmin);
        btnSoyAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(0, 7);
            }
        });

        setVisible(true); // Hace la ventana visible
    }

    /**
     * Intenta realizar el inicio de sesión con las credenciales ingresadas.
     * Si las credenciales son correctas, se cambia a la ventana principal.
     * Si son incorrectas, se muestra un mensaje de error y se incrementa el contador de intentos fallidos.
     * Si se superan los tres intentos fallidos, el programa se cierra.
     */
    private void intentarLogin() {
        String NICK = txtNickname.getText(); // Obtiene el nickname ingresado
        String PWD = new String(txtPassword.getPassword()); // Obtiene la contraseña ingresada

        if (modelo.verificarCredenciales(NICK, PWD)) { // Verifica las credenciales
            JOptionPane.showMessageDialog(this, "Login exitoso"); // Muestra mensaje de éxito
            controlador.cambiarVentana(0, 3); // Cambia a la ventana principal
            dispose(); // Cierra esta ventana
        } else {
            intentos++; // Incrementa el contador de intentos
            if (intentos < 3) { // Si los intentos no han excedido 3
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Intentos restantes: " + (3 - intentos)); // Muestra mensaje de error
            } else {
                JOptionPane.showMessageDialog(this, "Ha superado el número de intentos. El programa se cerrará."); // Muestra mensaje de superación de intentos
                System.exit(0); // Cierra la aplicación
            }
        }
    }
}

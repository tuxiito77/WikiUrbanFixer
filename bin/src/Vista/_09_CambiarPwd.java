package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta clase representa la ventana para cambiar la contraseña en la aplicación Urban Fixer.
 */
public class _09_CambiarPwd extends JFrame implements Vista {

    private JFrame frame;
    private JPasswordField passwordFieldOldPassword;
    private JPasswordField passwordFieldNewPassword;
    private JPasswordField passwordFieldRepeatNewPassword;

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
     * Método principal que inicia la aplicación.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _09_CambiarPwd window = new _09_CambiarPwd();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crea la ventana para cambiar la contraseña.
     */
    public _09_CambiarPwd() {
        initialize();
    }

    /**
     * Hace visible o invisible la ventana.
     * @param visible true para hacer visible, false para hacer invisible.
     */
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    /**
     * Inicializa el contenido de la ventana.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Cambio de contraseña");
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTitulo.setBounds(289, 62, 220, 30);
        frame.getContentPane().add(lblTitulo);

        JLabel lblOldPassword = new JLabel("Contraseña Antigua");
        lblOldPassword.setBounds(180, 188, 150, 30);
        frame.getContentPane().add(lblOldPassword);

        passwordFieldOldPassword = new JPasswordField();
        passwordFieldOldPassword.setBounds(359, 189, 200, 30);
        frame.getContentPane().add(passwordFieldOldPassword);

        JLabel lblNewPassword = new JLabel("Nueva contraseña");
        lblNewPassword.setBounds(180, 267, 150, 30);
        frame.getContentPane().add(lblNewPassword);

        passwordFieldNewPassword = new JPasswordField();
        passwordFieldNewPassword.setBounds(359, 268, 200, 30);
        frame.getContentPane().add(passwordFieldNewPassword);

        JLabel lblRepeatNewPassword = new JLabel("Repetir nueva contraseña");
        lblRepeatNewPassword.setBounds(180, 339, 180, 30);
        frame.getContentPane().add(lblRepeatNewPassword);

        passwordFieldRepeatNewPassword = new JPasswordField();
        passwordFieldRepeatNewPassword.setBounds(359, 340, 200, 30);
        frame.getContentPane().add(passwordFieldRepeatNewPassword);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(459, 416, 100, 30);
        frame.getContentPane().add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(9, 0);
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(passwordFieldOldPassword.getPassword());
                String newPassword = new String(passwordFieldNewPassword.getPassword());
                String repeatNewPassword = new String(passwordFieldRepeatNewPassword.getPassword());
            }
        });

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setBounds(214, 416, 100, 30);
        frame.getContentPane().add(btnAtras);
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(9, 2);
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}

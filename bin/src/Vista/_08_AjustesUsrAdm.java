package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta clase representa la ventana de ajustes de usuario y administrador en la aplicación Urban Fixer.
 */
public class _08_AjustesUsrAdm extends JFrame implements Vista {

    private JFrame frame;
    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldCodigoPostal;

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
                    _08_AjustesUsrAdm window = new _08_AjustesUsrAdm();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crea la ventana de ajustes de usuario y administrador.
     */
    public _08_AjustesUsrAdm() {
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
        frame.setTitle("Urban Fixer - Ajustes");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Ajustes de Usuario");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTitulo.setBounds(260, 31, 300, 30);
        frame.getContentPane().add(lblTitulo);

        JButton btnEditarFoto = new JButton("Editar Foto");
        btnEditarFoto.setBounds(31, 20, 100, 100);
        frame.getContentPane().add(btnEditarFoto);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(197, 137, 100, 30);
        frame.getContentPane().add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(360, 138, 200, 30);
        frame.getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(197, 215, 100, 30);
        frame.getContentPane().add(lblApellidos);

        textFieldApellidos = new JTextField();
        textFieldApellidos.setBounds(360, 216, 200, 30);
        frame.getContentPane().add(textFieldApellidos);
        textFieldApellidos.setColumns(10);

        JLabel lblCodigoPostal = new JLabel("Código Postal:");
        lblCodigoPostal.setBounds(197, 295, 100, 30);
        frame.getContentPane().add(lblCodigoPostal);

        textFieldCodigoPostal = new JTextField();
        textFieldCodigoPostal.setBounds(360, 296, 200, 30);
        frame.getContentPane().add(textFieldCodigoPostal);
        textFieldCodigoPostal.setColumns(10);

        JButton btnCambiarContrasena = new JButton("Cambiar contraseña");
        btnCambiarContrasena.setBounds(237, 368, 300, 30);
        frame.getContentPane().add(btnCambiarContrasena);

        JButton btnAtras = new JButton("Atrás");
        btnAtras.setBounds(237, 434, 100, 30);
        frame.getContentPane().add(btnAtras);
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(7, 3);
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}

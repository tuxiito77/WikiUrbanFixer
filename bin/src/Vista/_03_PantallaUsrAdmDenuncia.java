package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

/**
 * La clase _03_PantallaUsrAdmDenuncia representa la ventana de gestión de denuncias para usuarios y administradores en la aplicación Urban Fixer.
 * Permite a los usuarios y administradores realizar diversas acciones relacionadas con las denuncias.
 */
public class _03_PantallaUsrAdmDenuncia extends JFrame implements Vista {

	private JPanel contentPane; // Panel principal de la ventana
	private JTextField textFieldCodigoPostal; // Campo de texto para ingresar el código postal
	private JTextField textField; // Campo de texto para ingresar el nombre del problema

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
     * Constructor de la clase _03_PantallaUsrAdmDenuncia.
     * Inicializa la ventana de gestión de denuncias y sus componentes.
     */
	public _03_PantallaUsrAdmDenuncia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta de bienvenida
		JLabel lblBienvenido = new JLabel("Bienvenido a la pantalla de Usuarios");
		lblBienvenido.setBounds(301, 32, 233, 14);
		contentPane.add(lblBienvenido);

		// Etiquetas y campos de texto para ingresar información de la denuncia
		JLabel lblFotoDelProblema = new JLabel("Foto del problema:");
		lblFotoDelProblema.setBounds(86, 158, 150, 14);
		contentPane.add(lblFotoDelProblema);

		JLabel lblImagenPlaceholder = new JLabel("Nombre del problema:");
		lblImagenPlaceholder.setBounds(86, 83, 136, 51);
		contentPane.add(lblImagenPlaceholder);

		JLabel lblCodigoPostal = new JLabel("Codigo postal:");
		lblCodigoPostal.setBounds(86, 217, 100, 14);
		contentPane.add(lblCodigoPostal);

		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setBounds(232, 215, 150, 20);
		contentPane.add(textFieldCodigoPostal);
		textFieldCodigoPostal.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setBounds(86, 276, 100, 14);
		contentPane.add(lblCategoria);

		JComboBox<String> comboBoxCategoria = new JComboBox<>();
		comboBoxCategoria.setBounds(232, 272, 150, 22);
		comboBoxCategoria.addItem("Leve");
		comboBoxCategoria.addItem("Normal");
		comboBoxCategoria.addItem("Grave");
		comboBoxCategoria.addItem("Muy grave");
		contentPane.add(comboBoxCategoria);

		JLabel lblDescripcionDelProblema = new JLabel("Descripción del problema:");
		lblDescripcionDelProblema.setBounds(86, 313, 200, 14);
		contentPane.add(lblDescripcionDelProblema);

		JTextField textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(171, 337, 260, 100);
		contentPane.add(textFieldDescripcion);

		// Botón para enviar la denuncia
		JButton btnEnviarDenuncia = new JButton("Enviar Denuncia");
		btnEnviarDenuncia.setBounds(283, 471, 150, 20);
		contentPane.add(btnEnviarDenuncia);
		btnEnviarDenuncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(3, 4); 
			}
		});

		// Botones de acciones adicionales
		JButton btnAjustesUsuario = new JButton("Ajustes de Usuario");
		btnAjustesUsuario.setBounds(600, 67, 160, 20);
		contentPane.add(btnAjustesUsuario);
		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(3, 8); 
			}
		});
		
		JButton btnEstadoDenuncias = new JButton("Estado Denuncias");
		btnEstadoDenuncias.setBounds(600, 241, 160, 20);
		contentPane.add(btnEstadoDenuncias);
		btnEstadoDenuncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(3, 5); 
			}
		});
		
		JButton btnDenunciasFavoritas = new JButton("Denuncias Favoritas");
		btnDenunciasFavoritas.setBounds(600, 286, 160, 20);
		contentPane.add(btnDenunciasFavoritas);
		btnDenunciasFavoritas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(3, 6); 
			}
		});
		
		// Campo de texto adicional
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(232, 99, 150, 20);
		contentPane.add(textField);

		// Acción del botón de ajustes de usuario
		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ajustesFrame = new JFrame("Ajustes de Usuario");
				ajustesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ajustesFrame.setBounds(100, 100, 500, 400);

			}
		});
	}
}


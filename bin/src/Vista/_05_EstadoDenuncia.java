package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta clase representa la ventana de estado de denuncia en la aplicación Urban Fixer.
 * Permite a los usuarios ver el estado de las denuncias y realizar acciones relacionadas.
 */
public class _05_EstadoDenuncia extends JFrame implements Vista {

	private JPanel contentPane;
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
					_05_EstadoDenuncia frame = new _05_EstadoDenuncia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana de estado de denuncia.
	 */
	public _05_EstadoDenuncia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenido = new JLabel("Bienvenido a la pantalla de Usuarios");
		lblBienvenido.setBounds(301, 33, 233, 14);
		contentPane.add(lblBienvenido);

		JButton btnAjustesUsuario = new JButton("Ajustes de Usuario");
		btnAjustesUsuario.setBounds(601, 64, 160, 23);
		contentPane.add(btnAjustesUsuario);
		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(5, 8); 
			}
		});
		

		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ajustesFrame = new JFrame("Ajustes de Usuario");
				ajustesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ajustesFrame.setBounds(100, 100, 500, 400);
			}
		});

		JLabel lblEstadoDenuncia = new JLabel("Estado de denuncia");
		lblEstadoDenuncia.setBounds(323, 123, 120, 14);
		contentPane.add(lblEstadoDenuncia);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 179, 450, 150);
		contentPane.add(scrollPane);

		JTable tableEstado = new JTable();
		tableEstado.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "En proceso", null, null},
				{"", "", "Solucionada", null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo Postal", "Categoria", "Estado", "Imagen", "Favorita"
			}
		));
		scrollPane.setViewportView(tableEstado);

		JButton btnDenunciasFavoritas = new JButton("Denuncias Favoritas");
		btnDenunciasFavoritas.setBounds(505, 456, 172, 21);
		contentPane.add(btnDenunciasFavoritas);
		btnDenunciasFavoritas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(5, 6); 
			}
		});

		JButton btnDenunciarProblema = new JButton("Denunciar Problema");
		btnDenunciarProblema.setBounds(180, 456, 188, 21);
		contentPane.add(btnDenunciarProblema);
		btnDenunciarProblema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(5, 3); 
			}
		});
	}
}


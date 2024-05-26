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
 * Esta clase representa la ventana de Denuncias Favoritas para Usuarios Administradores en la aplicación Urban Fixer.
 * Permite a los administradores ver las denuncias marcadas como favoritas.
 */
public class _06_DenunciasFavUsrAdm extends JFrame implements Vista {

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
					_06_DenunciasFavUsrAdm  frame = new _06_DenunciasFavUsrAdm ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana de Denuncias Favoritas para Usuarios Administradores.
	 */
	public _06_DenunciasFavUsrAdm () {
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
		btnAjustesUsuario.setBounds(600, 65, 160, 23);
		contentPane.add(btnAjustesUsuario);
		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(6, 8); 
			}
		});

		btnAjustesUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ajustesFrame = new JFrame("Ajustes de Usuario");
				ajustesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ajustesFrame.setBounds(100, 100, 500, 400);
			}
		});

		JLabel lblDenunciasFavoritas = new JLabel("Denuncias Favoritas");
		lblDenunciasFavoritas.setBounds(323, 123, 150, 14);
		contentPane.add(lblDenunciasFavoritas);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 180, 450, 150);
		contentPane.add(scrollPane);

		JTable tableFavoritas = new JTable();
		tableFavoritas.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "En proceso", null},
				{"", "", "Solucionada", null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Codigo Postal", "Categoria", "Estado", "Imagen"
			}
		));
		scrollPane.setViewportView(tableFavoritas);

		JButton btnDenunciarProblema = new JButton("Denunciar Problema");
		btnDenunciarProblema.setBounds(180, 456, 150, 21);
		contentPane.add(btnDenunciarProblema);
		btnDenunciarProblema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(6, 3); 
			}
		});

		JButton btnEstadoDenuncias = new JButton("Estado Denuncias");
		btnEstadoDenuncias.setBounds(506, 456, 160, 21);
		contentPane.add(btnEstadoDenuncias);
		btnEstadoDenuncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVentana(6, 5); 
			}
		});
	}
}
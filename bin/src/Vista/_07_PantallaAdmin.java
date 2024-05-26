package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controlador.Controlador;
import Modelo.Modelo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase representa la pantalla de administración de la aplicación Urban Fixer.
 * Permite a los administradores ver las denuncias pendientes de autorizar y realizar diferentes acciones sobre ellas.
 */
public class _07_PantallaAdmin extends JFrame implements Vista {
    private JTable table;
    private JTextField searchField;

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
     * Crea la pantalla de administración.
     */
    public _07_PantallaAdmin() {
        setTitle("Pantalla de Administración");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblBienvenido = new JLabel("Bienvenido a la pantalla de administradores");
        lblBienvenido.setBounds(302, 32, 364, 14);
        getContentPane().add(lblBienvenido);

        JPanel panel = new JPanel();
        panel.setBounds(93, 132, 461, 303);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblDenunciasPendientes = new JLabel("Denuncias pendientes de autorizar");
        lblDenunciasPendientes.setBounds(10, 11, 200, 14);
        panel.add(lblDenunciasPendientes);

        JComboBox<String> categoryComboBox = new JComboBox<>();
        categoryComboBox.addItem("Leves");
        categoryComboBox.addItem("Normales");
        categoryComboBox.addItem("Graves");
        categoryComboBox.addItem("Muy graves");
        categoryComboBox.setBounds(10, 36, 100, 22);
        panel.add(categoryComboBox);

        searchField = new JTextField();
        searchField.setBounds(120, 36, 200, 22);
        panel.add(searchField);
        searchField.setColumns(10);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(330, 36, 74, 23);
        panel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 68, 441, 195);
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Codigo Postal 1", "", null, null, null},
        		{"Codigo Postal 2", "", null, null, null},
        		{"Codigo Postal 3", "", null, null, null},
        		{"Codigo Postal 4", "", null, null, null},
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
        		"Codigo Postal", "Categoria", "Descripción", "imagen", "Favorita"
        	}
        ));
        scrollPane.setViewportView(table);

        JButton btnDenegar = new JButton("Denegar");
        btnDenegar.setBounds(133, 456, 122, 21);
        getContentPane().add(btnDenegar);

        JButton btnAutorizar = new JButton("Autorizar");
        btnAutorizar.setBounds(409, 456, 122, 21);
        getContentPane().add(btnAutorizar);

        JButton btnAjustesAdministrador = new JButton("Ajustes Administrador");
        btnAjustesAdministrador.setBounds(571, 65, 189, 23);
        getContentPane().add(btnAjustesAdministrador);
        btnAjustesAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(7, 8);
            }
        });

        JButton btnDenunciasFavoritasAdmin = new JButton("Denuncias Favoritas");
        btnDenunciasFavoritasAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(7, 6);
            }
        });
        btnDenunciasFavoritasAdmin.setBounds(605, 241, 155, 21);
        getContentPane().add(btnDenunciasFavoritasAdmin);

        JButton btnDenunciarProblemaAdmin = new JButton("Denunciar Problema");
        btnDenunciarProblemaAdmin.setBounds(605, 281, 155, 21);
        getContentPane().add(btnDenunciarProblemaAdmin);
        btnDenunciarProblemaAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVentana(7, 3);
            }
        });
    }

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _07_PantallaAdmin window = new _07_PantallaAdmin();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

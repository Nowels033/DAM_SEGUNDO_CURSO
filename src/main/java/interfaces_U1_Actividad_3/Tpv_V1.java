package interfaces_U1_Actividad_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Tpv_V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaMesas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tpv_V1 frame = new Tpv_V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tpv_V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// MODELOS DE LAS TABLAS DE LAS MESAS

		String[] columnNames = { "Nombre", "Tipo", "Cantidad", "Precio", "Precio Total" };

		Object[][] data = { {},

		};

		DefaultTableModel modelMesa1 = new DefaultTableModel(data, columnNames);
		DefaultTableModel modelMesa2 = new DefaultTableModel(data, columnNames);
		DefaultTableModel modelMesa3 = new DefaultTableModel(data, columnNames);
		DefaultTableModel modelMesa4 = new DefaultTableModel(data, columnNames);
		DefaultTableModel modelMesa5 = new DefaultTableModel(data, columnNames);
		DefaultTableModel modelMesa6 = new DefaultTableModel(data, columnNames);

		// ARRAYLIST DE PRODUCTOS

		ArrayList<Producto> productos = Main.iniciarProductos();

		// ICONO DE MESA

		ClassLoader classLoader = getClass().getClassLoader();
		ImageIcon imageiconMesa = new ImageIcon(classLoader.getResource("comedor.png"));
		imageiconMesa.setImage(imageiconMesa.getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH));

		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);

		JPanel menu = new JPanel();
		contentPane.add(menu, "menu");
		menu.setLayout(new GridLayout(0, 2, 0, 0));

		// MESA1

		JButton mesa1 = new JButton("Mesa 1");

		menu.add(mesa1);
		mesa1.setIcon(imageiconMesa);
		mesa1.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa1.setVerticalTextPosition(SwingConstants.BOTTOM);

		// MESA2
		JButton mesa2 = new JButton("Mesa 2");
		mesa2.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(mesa2);
		mesa2.setIcon(imageiconMesa);
		mesa2.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa2.setVerticalTextPosition(SwingConstants.BOTTOM);

		// MESA3
		JButton mesa3 = new JButton("Mesa 3");
		mesa3.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(mesa3);
		mesa3.setIcon(imageiconMesa);
		mesa3.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa3.setVerticalTextPosition(SwingConstants.BOTTOM);

		// MESA4
		JButton mesa4 = new JButton("Mesa 4");
		mesa4.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(mesa4);
		mesa4.setIcon(imageiconMesa);
		mesa4.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa4.setVerticalTextPosition(SwingConstants.BOTTOM);

		// MESA5
		JButton mesa5 = new JButton("Mesa 5");
		mesa5.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(mesa5);
		mesa5.setIcon(imageiconMesa);
		mesa5.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa5.setVerticalTextPosition(SwingConstants.BOTTOM);

		// MESA6
		JButton mesa6 = new JButton("Mesa 6");
		mesa6.setVerticalAlignment(SwingConstants.BOTTOM);
		menu.add(mesa6);
		mesa6.setIcon(imageiconMesa);
		mesa6.setHorizontalTextPosition(SwingConstants.CENTER);
		mesa6.setVerticalTextPosition(SwingConstants.BOTTOM);

		// PANEL DE TABLA
		JPanel tabla = new JPanel();
		contentPane.add(tabla, "tabla");
		tabla.setLayout(null);

		tablaMesas = new JTable();
		// tablaMesas.setModel(modelMesa1);
		tablaMesas.setBounds(48, 35, 742, 352);
		tabla.add(tablaMesas);

		JButton btnAniadir = new JButton("AÑADIR");
		btnAniadir.setBounds(48, 413, 225, 37);
		tabla.add(btnAniadir);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(309, 413, 225, 37);
		tabla.add(btnEliminar);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "menu");
			}
		});
		btnVolver.setBounds(565, 413, 225, 37);
		tabla.add(btnVolver);

		// LISTENER DE MESAS
		// MESA 1
		mesa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa1);
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 2
		mesa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa2);
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 3
		mesa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa3);
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 4
		mesa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa4);
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 5
		mesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa5);
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 6
		mesa6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaMesas.setModel(modelMesa6);
				cardLayout.show(contentPane, "tabla");
			}
		});
	}
}

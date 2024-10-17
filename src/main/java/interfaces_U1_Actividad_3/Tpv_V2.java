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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class Tpv_V2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaMesas;
	private String nombreProducto = "";
	private String tipoSeleccionado = "";
	private int numeroDeModelo = 0;
	private JTextField totalSinIva;
	private JTextField totalIva;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tpv_V2 frame = new Tpv_V2();
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
	public Tpv_V2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

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
		modelMesa1.removeRow(0);
		modelMesa2.removeRow(0);
		modelMesa3.removeRow(0);
		modelMesa4.removeRow(0);
		modelMesa5.removeRow(0);
		modelMesa6.removeRow(0);
		
		//ARRAY DE MODELOS
		
		DefaultTableModel [] modelos =new DefaultTableModel[6];
		modelos[0]=modelMesa1;
		modelos[1]=modelMesa2;
		modelos[2]=modelMesa3;
		modelos[3]=modelMesa4;
		modelos[4]=modelMesa5;
		modelos[5]=modelMesa6;
		

		// ARRAYLIST DE PRODUCTOS

		ArrayList<Producto> productos = Metodos.iniciarProductos();

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
		tablaMesas.setBounds(48, 35, 742, 310);
		tabla.add(tablaMesas);

		JButton btnAniadir = new JButton("AÑADIR");

		btnAniadir.setBounds(48, 413, 225, 37);
		tabla.add(btnAniadir);

		JButton btnBorrar = new JButton("BORRAR");
		
		btnBorrar.setBounds(309, 413, 225, 37);
		tabla.add(btnBorrar);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "menu");

			}
		});
		btnVolver.setBounds(565, 413, 225, 37);
		tabla.add(btnVolver);
		
		totalSinIva = new JTextField();
		totalSinIva.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalSinIva.setEnabled(false);
		totalSinIva.setEditable(false);
		totalSinIva.setBounds(48, 364, 86, 20);
		tabla.add(totalSinIva);
		totalSinIva.setColumns(10);
		
		totalIva = new JTextField();
		totalIva.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalIva.setEnabled(false);
		totalIva.setEditable(false);
		totalIva.setBounds(163, 364, 96, 20);
		tabla.add(totalIva);
		totalIva.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TOTAL SIN IVA");
		lblNewLabel.setBounds(48, 350, 86, 14);
		tabla.add(lblNewLabel);
		
		JLabel lblTotalConIva = new JLabel("TOTAL CON IVA");
		lblTotalConIva.setBounds(163, 350, 96, 14);
		tabla.add(lblTotalConIva);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(39, 10, 79, 14);
		tabla.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("TIPO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(180, 10, 79, 14);
		tabla.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CANTIDAD");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(346, 10, 79, 14);
		tabla.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PRECIO SIN IVA");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1.setBounds(510, 10, 79, 14);
		tabla.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("PRECIO CON IVA");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1_1.setBounds(647, 10, 114, 14);
		tabla.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBounds(697, 363, 89, 23);
		tabla.add(btnImprimir);

		JPanel aniadir = new JPanel();
		aniadir.setLayout(null);
		contentPane.add(aniadir, "añadir");

		JButton btnOk = new JButton("OK");
		
		btnOk.setBounds(614, 438, 225, 37);
		aniadir.add(btnOk);

		
		//LISTENER VOLVER 2
		JButton btnVolver2 = new JButton("VOLVER");
		btnVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "tabla");

			}
		});
		btnVolver2.setBounds(614, 390, 225, 37);
		aniadir.add(btnVolver2);

		JComboBox comboBoxTipo = new JComboBox();

		comboBoxTipo.setModel(new DefaultComboBoxModel(Metodos.arrayTipoProductos()));
		comboBoxTipo.setBounds(48, 11, 199, 37);
		aniadir.add(comboBoxTipo);

		JLabel lblLabelTipo = new JLabel("Selecciona el tipo :");
		lblLabelTipo.setBounds(61, -18, 199, 43);
		aniadir.add(lblLabelTipo);

		JComboBox comboBoxProducto = new JComboBox();
		
		comboBoxProducto.setModel(new DefaultComboBoxModel(new String[] {" ", " "}));
		comboBoxProducto.setBounds(323, 11, 199, 37);
		aniadir.add(comboBoxProducto);
		
		JSlider numProductos = new JSlider();
		numProductos.setValue(1);
		
		numProductos.setPaintTicks(true);
		numProductos.setPaintLabels(true);
		numProductos.setMinimum(1);
		numProductos.setBounds(727, 11, 240, 37);
		aniadir.add(numProductos);
		
		JLabel lblProducto = new JLabel("1");
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setBounds(671, 22, 46, 14);
		aniadir.add(lblProducto);
		
		JPanel botonesTipo = new JPanel();
		botonesTipo.setBounds(10, 50, 343, 428);
		aniadir.add(botonesTipo,"botonesTipo");
		botonesTipo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JToggleButton btnEntrante = new JToggleButton("ENTRANTE");
		
		buttonGroup.add(btnEntrante);
		btnEntrante.setVerticalAlignment(SwingConstants.BOTTOM);
		botonesTipo.add(btnEntrante);
		
		JToggleButton btnPrimeros = new JToggleButton("PRIMERO");
		
		buttonGroup.add(btnPrimeros);
		btnPrimeros.setVerticalAlignment(SwingConstants.BOTTOM);
		botonesTipo.add(btnPrimeros);
		
		JToggleButton btnSegundos = new JToggleButton("SEGUNDO");
		buttonGroup.add(btnSegundos);
		btnSegundos.setVerticalAlignment(SwingConstants.BOTTOM);
		botonesTipo.add(btnSegundos);
		
		JToggleButton btnBebida = new JToggleButton("BEBIDA");
		btnBebida.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonGroup.add(btnBebida);
		botonesTipo.add(btnBebida);
		
		JToggleButton btnPostre = new JToggleButton("POSTRE");
		buttonGroup.add(btnPostre);
		botonesTipo.add(btnPostre);
//		
//		JPanel botonesProductos = new JPanel();
//		botonesProductos.setBounds(376, 50, 240, 328);
//		aniadir.add(botonesProductos);
//		botonesProductos.setLayout(new GridLayout(3, 3, 0, 0));
//		
//		JToggleButton btnNombre = new JToggleButton("nombre");
//		buttonGroup_1.add(btnNombre);
//		btnNombre.setVerticalAlignment(SwingConstants.BOTTOM);
//		botonesProductos.add(btnNombre);

		// LISTENER DE MESAS
		// MESA 1
		mesa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=1;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
				
				
			}
		});
		// MESA 2
		mesa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=2;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
				
			}
		});
		// MESA 3
		mesa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=3;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 4
		mesa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=4;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 5
		mesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=5;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
			}
		});
		// MESA 6
		mesa6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroDeModelo=6;
				tablaMesas.setModel(modelos[numeroDeModelo-1]);
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				cardLayout.show(contentPane, "tabla");
			}
		});

		// LISTENER AÑADIR
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "añadir");

				comboBoxTipo.setSelectedIndex(-1);
				comboBoxProducto.setSelectedIndex(-1);
				numProductos.setValue(1);
			}
		});

		// LISTENER COMBOBOX TIPO
		
		comboBoxTipo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        tipoSeleccionado = (String) comboBoxTipo.getSelectedItem();

		        if (tipoSeleccionado != null) {
		           
		            if (tipoSeleccionado.equalsIgnoreCase("Bebida") || 
		                tipoSeleccionado.equalsIgnoreCase("Comida") || 
		                tipoSeleccionado.equalsIgnoreCase("Postre")) {

		                String[] nombres = Metodos.arrayNombreProductos(productos, tipoSeleccionado);
		                comboBoxProducto.setModel(new DefaultComboBoxModel<>(nombres));
		            }
		        } else {
		            
		           // System.out.println("No se ha seleccionado");
		        }
		        buttonGroup.clearSelection();
		    }
		});
		
		
		// LISTENER COMBOBOX NOMBRE PRODUCTO
		comboBoxProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 nombreProducto= (String)comboBoxProducto.getSelectedItem();
			}
		});
		
		//LISTENER CHANGE SLIDER
		numProductos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblProducto.setText(numProductos.getValue()+"");
			}
		});
		
		//LISTENER BOTON OK
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String precioString = "";
				for (int i = 0; i < productos.size(); i++) {
					
					if (nombreProducto.equalsIgnoreCase(productos.get(i).getNombre())) {
						precioString = productos.get(i).getPrecio()+"";
					}
				}
				
				
				String cantidad =lblProducto.getText();
				String[] aniadirTabla = new String[5];
				aniadirTabla[0]= nombreProducto;
				aniadirTabla[1]=tipoSeleccionado;
				aniadirTabla[2]=cantidad;
				
				double precio = Double.parseDouble(precioString);
				double cantidadDouble =Double.parseDouble(aniadirTabla[2]);	
				double total = precio*cantidadDouble;
			
				aniadirTabla[3]=String.valueOf(total);
				
				double porcentaje = 21;
				double totalConIva= (total*porcentaje/100)+total;
				
				aniadirTabla[4]=String.valueOf(totalConIva);
				
				
				Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).addRow(aniadirTabla);
				
				totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
				totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				
				
				
				cardLayout.show(contentPane, "tabla");
			}
		});
		
		//LISTENER BOTON BORRAR
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int borrar = tablaMesas.getSelectedRow();
				if (borrar>=0) {
					Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).removeRow(borrar);
					totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
					totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "ERROR Selecciona una FILA!!!!");
				}
				
			}
		});
		
		//LISTENER BOTONES DE TIPO DE PRODUCTO
		//BOTON COMIDA
		btnEntrante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("HOLA");
				
				String[] nombres =Metodos.arrayNombreProductos(productos, btnEntrante.getText());
				
				cardLayout.show(contentPane, "botonesProductos");
				
			//	Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres);
				
				
//				JPanel botonesProductos = new JPanel();
//				botonesProductos.setBounds(376, 50, 240, 328);
//				aniadir.add(botonesProductos);
//				botonesProductos.setLayout(new GridLayout(3, 3, 0, 0));
//
//				JToggleButton btnNombre;
//				for (int i = 0; i < nombres.length; i++) {
//					btnNombre = new JToggleButton(nombres[i]);
//					buttonGroup_1.add(btnNombre);
//					btnNombre.setVerticalAlignment(SwingConstants.BOTTOM);
//					botonesProductos.add(btnNombre);
//				}
			}
		});
		
		btnPrimeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] nombres2 =Metodos.arrayNombreProductos(productos, btnPrimeros.getText());
				
				
				cardLayout.show(contentPane, "botonesProductos");
		//		Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres2);
			}
		});
		btnSegundos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] nombres3 =Metodos.arrayNombreProductos(productos, btnSegundos.getText());
				
				
				
		//		Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres3);
			}
		});
		btnBebida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] nombres4 =Metodos.arrayNombreProductos(productos, btnBebida.getText());
				
				
				
			//	Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres4);
			}
		});
		btnPostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] nombres5 =Metodos.arrayNombreProductos(productos, btnPostre.getText());
				
				
				
				//Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres5);
			}
		});
		
	}
}

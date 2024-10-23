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
import java.util.Iterator;
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

public class Tpv_V4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaMesas;
	private String nombreProducto = "";
	private String tipoSeleccionado = "";
	private int fila=0;
	private boolean modificar=false;
	private int numeroDeModelo = 0;
	private JTextField totalSinIva;
	private JTextField totalIva;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private String[] nombres;
	private JPanel botonesProductos=new JPanel();
	private Metodos nombreProductos=new Metodos();
	private String tipoModificar="",productoModificar="",cantidadModificar="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tpv_V4 frame = new Tpv_V4();
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
	public Tpv_V4() {
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
		ArrayList<JButton> mesas = new ArrayList<JButton>();
		
		for (int i=1; i<7; i++) {
			int indexMesas = i;
			JButton mesa1 = new JButton("Mesa "+i);
			menu.add(mesa1);
			mesa1.setIcon(imageiconMesa);
			mesa1.setHorizontalTextPosition(SwingConstants.CENTER);
			mesa1.setVerticalTextPosition(SwingConstants.BOTTOM);
			mesa1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					numeroDeModelo=indexMesas;
					tablaMesas.setModel(modelos[numeroDeModelo-1]);
					totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
					totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
					cardLayout.show(contentPane, "tabla");
					
					
				}
			});
		}
		

		// PANEL DE TABLA
		JPanel tabla = new JPanel();
		contentPane.add(tabla, "tabla");
		tabla.setLayout(null);

		tablaMesas = new JTable();
		tablaMesas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tablaMesas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		// tablaMesas.setModel(modelMesa1);
		tablaMesas.setBounds(10, 35, 846, 310);
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
		
		JLabel lblTotalSinIVA = new JLabel("TOTAL SIN IVA");
		lblTotalSinIVA.setBounds(48, 350, 86, 14);
		tabla.add(lblTotalSinIVA);
		
		JLabel lblTotalConIva = new JLabel("TOTAL CON IVA");
		lblTotalConIva.setBounds(163, 350, 96, 14);
		tabla.add(lblTotalConIva);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(69, 11, 79, 14);
		tabla.add(lblNombre);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblTipo.setBounds(210, 11, 79, 14);
		tabla.add(lblTipo);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblCantidad.setBounds(376, 11, 79, 14);
		tabla.add(lblCantidad);
		
		JLabel lblPrecioSinIVA = new JLabel("PRECIO SIN IVA");
		lblPrecioSinIVA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioSinIVA.setForeground(Color.BLACK);
		lblPrecioSinIVA.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPrecioSinIVA.setBounds(540, 11, 79, 14);
		tabla.add(lblPrecioSinIVA);
		
		JLabel lblPrecioConIVA = new JLabel("PRECIO CON IVA");
		lblPrecioConIVA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioConIVA.setForeground(Color.BLACK);
		lblPrecioConIVA.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPrecioConIVA.setBounds(677, 11, 114, 14);
		tabla.add(lblPrecioConIVA);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setBounds(697, 363, 89, 23);
		tabla.add(btnImprimir);
		
		JButton btnModificar = new JButton("MODIFICAR");
		
		btnModificar.setBounds(309, 363, 225, 37);
		tabla.add(btnModificar);

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
		
		JSlider numProductos = new JSlider();
		numProductos.setPaintTicks(true);
		numProductos.setPaintLabels(true);
		numProductos.setOrientation(SwingConstants.VERTICAL);
		numProductos.setValue(1);
		numProductos.setMinimum(1);
		numProductos.setBounds(801, 11, 56, 292);
		aniadir.add(numProductos);
		
		JLabel lblProducto = new JLabel("1");
		lblProducto.setFont(new Font("Dialog", Font.BOLD, 17));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setBounds(793, 314, 64, 59);
		aniadir.add(lblProducto);
		
		JPanel botonesTipo = new JPanel();
		botonesTipo.setBounds(10, 11, 343, 467);
		aniadir.add(botonesTipo,"botonesTipo");
		botonesTipo.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
	

		// LISTENER AÑADIR
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "añadir");

				//comboBoxTipo.setSelectedIndex(-1);
				//comboBoxProducto.setSelectedIndex(-1);
				//numProductos.setValue(1);
			}
		});
		
		//LISTENER CHANGE SLIDER
		numProductos.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				lblProducto.setText(numProductos.getValue()+"");
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
		
		

		
		//LISTENER BOTON OK
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!modificar ) {
							String precioString = "";
							for (int i = 0; i < productos.size(); i++) {
								
								if (productos.get(i).getNombre().equalsIgnoreCase(nombreProductos.getNombre())) {
									precioString = productos.get(i).getPrecio()+"";
								}
							}
							
							//if(buttonGroup.isSelected(null)) {
								String cantidad =lblProducto.getText();
								String[] aniadirTabla = new String[5];
								aniadirTabla[0]= nombreProductos.getNombre().toUpperCase();
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
								
								buttonGroup.clearSelection();
								buttonGroup_1.clearSelection();
								
								cardLayout.show(contentPane, "tabla");
						}
						
						
						if(modificar ) {
							
							String precioString = "";
							for (int i = 0; i < productos.size(); i++) {
								
								if (productos.get(i).getNombre().equalsIgnoreCase(productoModificar)) {
									precioString = productos.get(i).getPrecio()+"";
								}
							}
							
							String[] modificarTabla = new String[5];
							modificarTabla[0]= productoModificar;
							modificarTabla[1]=tipoModificar;
							modificarTabla[2]=cantidadModificar;
							
							double precio = Double.parseDouble(precioString);
							double cantidadDouble =Double.parseDouble(modificarTabla[2]);	
							double total = precio*cantidadDouble;
						
							modificarTabla[3]=String.valueOf(total);
							
							double porcentaje = 21;
							double totalConIva= (total*porcentaje/100)+total;
							
							modificarTabla[4]=String.valueOf(totalConIva);
							
							
							
							Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).insertRow(fila, modificarTabla);
							
							totalSinIva.setText(Metodos.sumarColumna(tablaMesas, 3)+" €");
							totalIva.setText(Metodos.sumarColumna(tablaMesas, 4)+" €");
							
							buttonGroup.clearSelection();
							buttonGroup_1.clearSelection();
							modificar=false;
							
							cardLayout.show(contentPane, "tabla");
							
						
							
						}
						
						
					}
				});
				
				//LISTENER DE BOTON MODIFICAR
				
				
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 fila =tablaMesas.getSelectedRow();
						if (fila >= 0) {
							
							modificar=true;
							productoModificar=(String) Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).getValueAt(fila, 0);
							tipoModificar=(String) Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).getValueAt(fila, 1);
							cantidadModificar=(String) Metodos.seleccionarModeloDeTabla(numeroDeModelo, modelos).getValueAt(fila, 2);
							
							numProductos.setValue(Integer.parseInt(cantidadModificar));
							
							cardLayout.show(contentPane, "añadir");
							
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Selecciona una fila para MODIFICAR");
						}
						
						
					}
				});
				//HACER EL BUCLE DE BOTONES DE LOS TIPOS DE COMIDA//
				String[] nombreDeLosTiposDeProductos =Metodos.arrayTipoProductos();
				ArrayList<ImageIcon> iconosTipoProducto = Metodos.arrayListIconosTipoDeProducto(); 
				for (int i = 0; i < nombreDeLosTiposDeProductos.length; i++) {
					
					JToggleButton btnTipo = new JToggleButton(nombreDeLosTiposDeProductos[i]);

					buttonGroup.add(btnTipo);
					btnTipo.setVerticalAlignment(SwingConstants.BOTTOM);
					btnTipo.setIcon(iconosTipoProducto.get(i));
					btnTipo.setHorizontalTextPosition(SwingConstants.CENTER);
					btnTipo.setVerticalTextPosition(SwingConstants.BOTTOM);
					botonesTipo.add(btnTipo);
					
					btnTipo.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							
							//System.out.println("EJECUTADO : ");
							botonesProductos.removeAll();
							
							 nombres =Metodos.arrayNombreProductos(productos, btnTipo.getText());
							 botonesProductos=Metodos.generarBotonesProductos(aniadir, buttonGroup_1, nombres,nombreProductos);
							 tipoSeleccionado=btnTipo.getText();
							 botonesProductos.revalidate();
							// botonesProductos.repaint();
							
							
							 
						}
					});
					
					
					
				}
				
		
	}
}

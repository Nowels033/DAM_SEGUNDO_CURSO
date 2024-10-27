package interfaces_U1_Actividad_3_Final;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class MenuDeProductos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroupTipoComida = new ButtonGroup();
	private final ArrayList<Producto> productos = Metodos.iniciarProductos();
	private final String[] productosSeleccionados = new String[5];
	private JTextField cantidad;
	private final ButtonGroup buttonGroupSubirBajar = new ButtonGroup();
	private final ButtonGroup buttonGroupProductos = new ButtonGroup();
	private final String[] TIPOSDEPRODUCTO = { "Entrante", "Primero", "Segundo", "Postre", "Bebida" };
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JPanel jPanelProductos = new JPanel();
	private ArrayList<Producto> productosParaMostrar = new ArrayList<Producto>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuDeProductos dialog = new MenuDeProductos(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuDeProductos(JDialog frame, DefaultTableModel modeloTabla) {
		super(frame, "MENU DE PRODUCTOS", true);
		setLocationRelativeTo(frame);
		setBounds(100, 100, 1067, 524);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel botonesTipoComida = new JPanel();
		botonesTipoComida.setBounds(10, 11, 200, 430);
		contentPanel.add(botonesTipoComida);
		botonesTipoComida.setLayout(new GridLayout(0, 1, 0, 0));

		jPanelProductos = new JPanel();
		jPanelProductos.setBounds(225, 11, 748, 430);
		contentPanel.add(jPanelProductos);

		
		jPanelProductos.setLayout(cardLayout);

		JPanel botonesProductos = new JPanel();
		jPanelProductos.add(botonesProductos, "productos");
		botonesProductos.setLayout(new GridLayout(0, 3, 0, 0));


		//////////////////////////////////////////////////
		//////////////////////////////////////////////////
		// PANEL DE BOTONES
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabla.addRow(productosSeleccionados);
				
				
				
				
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");

		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		

		BotonRedondo btnBajar = new BotonRedondo("-");
		btnBajar.setForeground(new Color(0, 0, 0));
		buttonGroupSubirBajar.add(btnBajar);
		btnBajar.setBounds(994, 380, 47, 28);
		btnBajar.setFont(new Font("Stencil", Font.BOLD, 15));
		contentPanel.add(btnBajar);

		BotonRedondo btnSubir = new BotonRedondo("+");

		btnSubir.setForeground(new Color(0, 0, 0));
		btnSubir.setFont(new Font("Stencil", Font.BOLD, 14));
		buttonGroupSubirBajar.add(btnSubir);
		btnSubir.setBounds(994, 277, 47, 28);
		contentPanel.add(btnSubir);

		cantidad = new JTextField();
		cantidad.setFont(new Font("Source Sans Pro Light", Font.BOLD, 20));
		cantidad.setText("1");
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setEditable(false);
		cantidad.setBounds(991, 316, 50, 53);
		contentPanel.add(cantidad);
		cantidad.setColumns(10);

		
		
		generarBotonesTipoDeProducto(buttonGroupTipoComida, botonesTipoComida,buttonGroupProductos,botonesProductos,cardLayout);
		
		
			
		
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				productosParaMostrar.clear();
                botonesProductos.removeAll();
				getButtonGroupTipoComida().clearSelection();
				cerrarDialogo();
				
				
				
			
			}
		});

		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCantidad = Integer.parseInt(cantidad.getText());
				totalCantidad++;
				cantidad.setText(totalCantidad + "");
				getProductosSeleccionados()[2] = cantidad.getText();

			}
		});

		btnBajar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCantidad = Integer.parseInt(cantidad.getText());
				if (totalCantidad > 1) {
					totalCantidad--;
					cantidad.setText(totalCantidad + "");
					getProductosSeleccionados()[2] = cantidad.getText();
				} else {
					JOptionPane.showMessageDialog(getParent(), "NO PUEDES SELECCIONAR MENOS DE 1 PRODUCTO EN CANTIDAD");
				}

			}
		});

	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public ButtonGroup getButtonGroupTipoComida() {
		return buttonGroupTipoComida;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public String[] getProductosSeleccionados() {
		return productosSeleccionados;
	}

	public JTextField getCantidad() {
		return cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		this.cantidad = cantidad;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroupSubirBajar;
	}

	public ButtonGroup getButtonGroup_1() {
		return buttonGroupProductos;
	}

	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public ButtonGroup getButtonGroupSubirBajar() {
		return buttonGroupSubirBajar;
	}

	public ButtonGroup getButtonGroupProductos() {
		return buttonGroupProductos;
	}

	public String[] getTIPOSDEPRODUCTO() {
		return TIPOSDEPRODUCTO;
	}
	
	

	public JPanel getjPanelProductos() {
		return jPanelProductos;
	}

	public void setjPanelProductos(JPanel jPanelProductos) {
		this.jPanelProductos = jPanelProductos;
	}

	private void generarBotonesTipoDeProducto(ButtonGroup buttonGroupTipoComida, JPanel botonesTipoComida, ButtonGroup buttonGroupProductos, JPanel botonesProductos, CardLayout cardLayout) {
	    
	    for (int i = 0; i < TIPOSDEPRODUCTO.length; i++) {
	        JToggleButton btnTipoComida = new JToggleButton(TIPOSDEPRODUCTO[i]);
	        btnTipoComida.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	   // LISTENER BOTON DE TIPOS DE COMIDA
	            	
	            	
	                productosParaMostrar.clear();
	                botonesProductos.removeAll();

	             
	                getProductosSeleccionados()[1] = btnTipoComida.getText().toUpperCase();
	                
	                System.out.println("HOLA ESTOY FUNCIOnANDO " + getProductosSeleccionados()[1]);
	                
	               
	                for (int j = 0; j < getProductos().size(); j++) {
	                    if (getProductos().get(j).getTipo().equalsIgnoreCase(getProductosSeleccionados()[1])) {
	                        productosParaMostrar.add(getProductos().get(j));
	                    }
	                }
	                
	               
	                for (int j = 0; j < productosParaMostrar.size(); j++) {
	                    JToggleButton tglbtnProductos = new JToggleButton(productosParaMostrar.get(j).getNombre());
	                    tglbtnProductos.addActionListener(new ActionListener() {
	                        public void actionPerformed(ActionEvent e) {
	                           
	                        	getProductosSeleccionados()[0] = tglbtnProductos.getText().toUpperCase();
	                        	
	                        	for (int k = 0; k < getProductos().size(); k++) {
									
	                        		if (getProductos().get(k).getNombre().equalsIgnoreCase(tglbtnProductos.getText())) {
										
	                        			getProductosSeleccionados()[3]=String.valueOf(getProductos().get(k).getPrecio());
									}
	                        		
								}
	                        }
	                    });
	                    iconosNombreDeProducto(tglbtnProductos, tglbtnProductos.getText());
	                    buttonGroupProductos.add(tglbtnProductos);
	                    botonesProductos.add(tglbtnProductos);
	                }
	                
	               
	                botonesProductos.revalidate();
	                botonesProductos.repaint();
	                cardLayout.show(botonesProductos.getParent(), "productos");
	            }
	        });

	        btnTipoComida.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnTipoComida.setVerticalTextPosition(SwingConstants.BOTTOM);
	        asignarIconoTiposDeComida(btnTipoComida);
	        buttonGroupTipoComida.add(btnTipoComida);
	        botonesTipoComida.add(btnTipoComida);
	    }
	}
	


	private void cerrarDialogo() {
		setVisible(false);
		getOwner().setVisible(true);

	}

//	private void generarBotonesNombresProductos(ArrayList<Producto> arrayDeProductos, ButtonGroup buttonGroup_1,JPanel botonesProductos,CardLayout cardLayout) {
//
//		
//		ArrayList<String> productoSeleccionado = new ArrayList<String>();
//		for (int i = 0; i < arrayDeProductos.size(); i++) {
//			
//			if (arrayDeProductos.get(i).getTipo().equalsIgnoreCase(getProductosSeleccionados()[1])) {
//				productoSeleccionado.add(arrayDeProductos.get(i).getNombre());
//			}
//			
//			
//		}
//		
//		botonesProductos.removeAll();
//		
//		for (int i = 0; i < productoSeleccionado.size(); i++) {
//			
//			JButton btnNombreProducto = new JButton(productoSeleccionado.get(i));
//			btnNombreProducto.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e) {
//						
//					
//					productosSeleccionados[0]=btnNombreProducto.getText();
//					
//					
//				}
//			});
//			iconosNombreDeProducto(btnNombreProducto,btnNombreProducto.getText());
//			buttonGroup_1.add(btnNombreProducto);
//			botonesProductos.add(btnNombreProducto);
//			
//		}
//		
//		
//
//	}
	
	private void generarBotonesNombresProductos(ArrayList<Producto> arrayDeProductos, ButtonGroup buttonGroupProductos, JPanel botonesProductos, CardLayout cardLayout, JPanel contenedorPrincipal) {
	    // Limpiamos el JPanel de botones antes de agregar los nuevos
	    botonesProductos.removeAll();

	    String tipoSeleccionado = getProductosSeleccionados()[1];

	    for (Producto producto : arrayDeProductos) {
	        if (producto.getTipo().equalsIgnoreCase(tipoSeleccionado)) {
	            JButton btnNombreProducto = new JButton(producto.getNombre());
	            btnNombreProducto.addActionListener(e -> productosSeleccionados[0] = btnNombreProducto.getText());

	            // Asignamos icono correspondiente al botón
	           // iconosNombreDeProducto(btnNombreProducto, producto.getNombre());
	            buttonGroupProductos.add(btnNombreProducto);
	            botonesProductos.add(btnNombreProducto);
	        }
	    }

	    // Aseguramos que se actualice el panel de botones
	    botonesProductos.revalidate();
	    botonesProductos.repaint();

	    // Actualizamos el CardLayout para asegurarnos de que el panel se muestre
	    cardLayout.show(contenedorPrincipal, "productos"); // reemplaza "nombrePanelProductos" con el nombre de tu panel en el CardLayout
	}

	private static void asignarIconoTiposDeComida(JToggleButton btnTipoComida) {
		// ICONO DE MESA

		ClassLoader classLoader = MenuDeProductos.class.getClassLoader();

		ImageIcon imageiconEntrante = new ImageIcon(classLoader.getResource("entrante.png"));
		imageiconEntrante
				.setImage(imageiconEntrante.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

		ImageIcon imageiconPrimero = new ImageIcon(classLoader.getResource("primerPlato.png"));
		imageiconPrimero.setImage(imageiconPrimero.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

		ImageIcon imageiconSegundo = new ImageIcon(classLoader.getResource("segundoPlato.png"));
		imageiconSegundo.setImage(imageiconSegundo.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

		ImageIcon imageiconPostre = new ImageIcon(classLoader.getResource("postre.png"));
		imageiconPostre.setImage(imageiconPostre.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

		ImageIcon imageiconBebida = new ImageIcon(classLoader.getResource("bebida.png"));
		imageiconBebida.setImage(imageiconBebida.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

		if (btnTipoComida.getText().equalsIgnoreCase("Entrantes")) {

			btnTipoComida.setIcon(imageiconEntrante);

		}
		if (btnTipoComida.getText().equalsIgnoreCase("Primeros")) {

			btnTipoComida.setIcon(imageiconPrimero);

		}
		if (btnTipoComida.getText().equalsIgnoreCase("Segundos")) {

			btnTipoComida.setIcon(imageiconSegundo);

		}
		if (btnTipoComida.getText().equalsIgnoreCase("Postres")) {

			btnTipoComida.setIcon(imageiconPostre);

		}
		if (btnTipoComida.getText().equalsIgnoreCase("Bebidas")) {

			btnTipoComida.setIcon(imageiconBebida);

		}

	}

	private static void iconosNombreDeProducto(JToggleButton  btn, String nombreProducto) {

		ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();

		ClassLoader classLoader = Metodos.class.getClassLoader();

		ImageIcon iconoBravas = new ImageIcon(classLoader.getResource("patatasBravas.png"));
		iconoBravas.setImage(iconoBravas.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoEnsalada = new ImageIcon(classLoader.getResource("ensalada.png"));
		iconoEnsalada.setImage(iconoEnsalada.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoCroquetas = new ImageIcon(classLoader.getResource("croqueta.png"));
		iconoCroquetas.setImage(iconoCroquetas.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoBocataBeicon = new ImageIcon(classLoader.getResource("bocataBeicon.png"));
		iconoBocataBeicon
				.setImage(iconoBocataBeicon.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoBocataTortilla = new ImageIcon(classLoader.getResource("tortilla.png"));
		iconoBocataTortilla
				.setImage(iconoBocataTortilla.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoSopa = new ImageIcon(classLoader.getResource("sopa.png"));
		iconoSopa.setImage(iconoSopa.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoPasta = new ImageIcon(classLoader.getResource("pasta.png"));
		iconoPasta.setImage(iconoPasta.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoEscapole = new ImageIcon(classLoader.getResource("escalopeDePollo.png"));
		iconoEscapole.setImage(iconoEscapole.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoHamburguesa = new ImageIcon(classLoader.getResource("hamburguesa.png"));
		iconoHamburguesa.setImage(iconoHamburguesa.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoHamburguesaXL = new ImageIcon(classLoader.getResource("hamburguesaXL.png"));
		iconoHamburguesaXL
				.setImage(iconoHamburguesaXL.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoPizza = new ImageIcon(classLoader.getResource("pizza.png"));
		iconoPizza.setImage(iconoPizza.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoBocataDelDia = new ImageIcon(classLoader.getResource("bocataDelDia.png"));
		iconoBocataDelDia
				.setImage(iconoBocataDelDia.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoCerveza = new ImageIcon(classLoader.getResource("cerveza.png"));
		iconoCerveza.setImage(iconoCerveza.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoAgua = new ImageIcon(classLoader.getResource("agua-mineral.png"));
		iconoAgua.setImage(iconoAgua.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoRefresco = new ImageIcon(classLoader.getResource("refresco.png"));
		iconoRefresco.setImage(iconoRefresco.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoZumo = new ImageIcon(classLoader.getResource("zumo.png"));
		iconoZumo.setImage(iconoZumo.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoTarta = new ImageIcon(classLoader.getResource("tarta.png"));
		iconoTarta.setImage(iconoTarta.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoHelado = new ImageIcon(classLoader.getResource("helado.png"));
		iconoHelado.setImage(iconoHelado.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoFruta = new ImageIcon(classLoader.getResource("fruta.png"));
		iconoFruta.setImage(iconoFruta.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconoCafe = new ImageIcon(classLoader.getResource("cafe.png"));
		iconoCafe.setImage(iconoCafe.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));

		iconos.add(iconoBravas);
		iconos.add(iconoEnsalada);
		iconos.add(iconoCroquetas);
		iconos.add(iconoBocataBeicon);
		iconos.add(iconoBocataTortilla);
		iconos.add(iconoSopa);
		iconos.add(iconoPasta);
		iconos.add(iconoEscapole);
		iconos.add(iconoHamburguesa);
		iconos.add(iconoHamburguesaXL);
		iconos.add(iconoPizza);
		iconos.add(iconoBocataDelDia);
		iconos.add(iconoCerveza);
		iconos.add(iconoAgua);
		iconos.add(iconoRefresco);
		iconos.add(iconoZumo);
		iconos.add(iconoTarta);
		iconos.add(iconoHelado);
		iconos.add(iconoFruta);
		iconos.add(iconoCafe);
		
		

		if (nombreProducto.equalsIgnoreCase("Racion De Patatas Bravas")) {
			btn.setIcon(iconoBravas);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Ensalada De Peraltas")) {
			btn.setIcon(iconoEnsalada);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Croquetas")) {
			btn.setIcon(iconoCroquetas);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Bocata Beicon Queso")) {
			btn.setIcon(iconoBocataBeicon);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Bocata De Tortilla")) {
			btn.setIcon(iconoBocataTortilla);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Sopa")) {
			btn.setIcon(iconoSopa);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Pasta del Dia")) {
			btn.setIcon(iconoPasta);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Escalope De Pollo")) {
			btn.setIcon(iconoEscapole);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Hamburguesa")) {
			btn.setIcon(iconoHamburguesa);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Hamburguesa XL")) {
			btn.setIcon(iconoHamburguesaXL);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("PIZZA 4 QUESOS")) {
			btn.setIcon(iconoPizza);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		if (nombreProducto.equalsIgnoreCase("Bocata del Dia")) {
			btn.setIcon(iconoBocataDelDia);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Cerveza")) {
			btn.setIcon(iconoCerveza);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Agua")) {
			btn.setIcon(iconoAgua);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Refresco")) {
			btn.setIcon(iconoRefresco);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Zumo")) {
			btn.setIcon(iconoZumo);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Fruta")) {
			btn.setIcon(iconoFruta);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Tarta")) {
			btn.setIcon(iconoTarta);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Helado")) {
			btn.setIcon(iconoHelado);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}

		if (nombreProducto.equalsIgnoreCase("Cafe")) {
			btn.setIcon(iconoCafe);
			btn.setHorizontalTextPosition(SwingConstants.CENTER);
			btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
	}
}

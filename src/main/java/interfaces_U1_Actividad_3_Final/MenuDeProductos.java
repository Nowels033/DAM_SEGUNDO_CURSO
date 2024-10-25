package interfaces_U1_Actividad_3_Final;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class MenuDeProductos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroupTipoComida = new ButtonGroup();
	private final ArrayList<Producto> productos = Metodos.iniciarProductos();
	private final String[] productosSeleccionados = new String[3];
	private JTextField cantidad;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuDeProductos dialog = new MenuDeProductos(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuDeProductos(JDialog frame) {
		super(frame, "MENU DE PRODUCTOS", true);
		setLocationRelativeTo(frame);
		setBounds(100, 100, 1067, 524);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel botonesTipoComida = new JPanel();
		botonesTipoComida.setBounds(10, 11, 200, 441);
		contentPanel.add(botonesTipoComida);
		botonesTipoComida.setLayout(new GridLayout(0, 1, 0, 0));

		

		JPanel productos = new JPanel();
		productos.setBounds(209, 11, 775, 441);
		contentPanel.add(productos);

		CardLayout cardLayout = new CardLayout(0, 0);
		productos.setLayout(cardLayout);

		JPanel panel = new JPanel();
		productos.add(panel, "productos");
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		//////////////////////////////////////////////////
		//////////////////////////////////////////////////
		// PANEL DE BOTONES
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		
		
		generarBotonesTipoDeProducto(buttonGroupTipoComida, botonesTipoComida);
		
		BotonRedondo btnBajar = new BotonRedondo("-");
		btnBajar.setForeground(new Color(0, 0, 0));
		buttonGroup.add(btnBajar);
		btnBajar.setBounds(994, 380, 47, 28);
		btnBajar.setFont(new Font("Stencil", Font.BOLD, 15));
		contentPanel.add(btnBajar);
		
		BotonRedondo btnSubir = new BotonRedondo("+");
		
		btnSubir.setForeground(new Color(0, 0, 0));
		btnSubir.setFont(new Font("Stencil", Font.BOLD, 14));
		buttonGroup.add(btnSubir);
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
		
		
		
		
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getButtonGroupTipoComida().clearSelection();
				cerrarDialogo();
			}
		});

		
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCantidad=Integer.parseInt(cantidad.getText());
				totalCantidad++;
				cantidad.setText(totalCantidad+"");
				getProductosSeleccionados()[2]=cantidad.getText();
				
			}
		});
		
		btnBajar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int totalCantidad=Integer.parseInt(cantidad.getText());
				if(totalCantidad >1) {
					totalCantidad--;
					cantidad.setText(totalCantidad+"");
					getProductosSeleccionados()[2]=cantidad.getText();
				}
				else {
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

	private  void generarBotonesTipoDeProducto(ButtonGroup buttonGroupTipoComida, JPanel botonesTipoComida) {

		String[] tiposDeProducto = { "Entrantes", "Primeros", "Segundos", "Postres", "Bebidas" };

		for (int i = 0; i < tiposDeProducto.length; i++) {

			JToggleButton btnTipoComida = new JToggleButton(tiposDeProducto[i]);
			btnTipoComida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//LISTENER BOTON DE TIPOS DE COMIDA 
					getProductosSeleccionados()[1]=btnTipoComida.getText();
					
					
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

	private static void asignarIconoTiposDeComida(JToggleButton btnTipoComida) {
		// ICONO DE MESA

		ClassLoader classLoader = MenuDeProductos.class.getClassLoader();

		ImageIcon imageiconEntrante = new ImageIcon(classLoader.getResource("entrante.png"));
		imageiconEntrante.setImage(imageiconEntrante.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));

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
}

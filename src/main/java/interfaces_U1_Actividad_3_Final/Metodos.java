package interfaces_U1_Actividad_3_Final;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;




public class Metodos {
	
	public String nombre;
	
	

//	public static void main(String[] args) {
//		imprimir();
//	}

	public Metodos() {
		this.nombre="prueba";
	}

	public static ArrayList<Producto> iniciarProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String bebida = "Bebida", postre = "Postre", entrante = "Entrante",primero="Primero",segundo="Segundo";

		Producto p1 = new Producto("Cerveza", bebida, 3.0);
		Producto p2 = new Producto("Agua", bebida, 2.0);
		Producto p3 = new Producto("Refresco", bebida, 3.0);
		Producto p4 = new Producto("Zumo", bebida, 3.2);
		Producto p5 = new Producto("Fruta", postre, 2.8);
		Producto p6 = new Producto("Tarta", postre, 3.0);
		Producto p7 = new Producto("Helado", postre, 3.0);
		Producto p8 = new Producto("Racion De Patatas Bravas", entrante, 9.0);
		Producto p9 = new Producto("Bocata Beicon Queso", primero, 4.5);
		Producto p10 = new Producto("Bocata De Tortilla", primero, 4.0);
		Producto p11 = new Producto("Ensalada de Peraltas", entrante, 8.0);
		Producto p12 = new Producto("Croquetas", entrante, 8.5);
		Producto p13 = new Producto("Sopa", primero, 8.0);
		Producto p14 = new Producto("Escalope De Pollo", segundo, 7.0);
		Producto p15 = new Producto("Hamburguesa", segundo, 8.0);
		Producto p16 = new Producto("Hamburguesa XL", segundo, 9.0);
		Producto p17 = new Producto("PIZZA 4 QUESOS", segundo, 12.0);
		Producto p18 = new Producto("Pasta del Dia", primero, 6.0);
		Producto p19 = new Producto("Bocata del Dia", segundo, 6.0);


		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);
		productos.add(p7);
		productos.add(p8);
		productos.add(p9);
		productos.add(p10);
		productos.add(p11);
		productos.add(p12);
		productos.add(p13);
		productos.add(p14);
		productos.add(p15);
		productos.add(p16);
		productos.add(p17);
		productos.add(p18);
		productos.add(p19);

		return productos;

	}

	public static String[] arrayTipoProductos() {
		String[] tipoProductos = new String[5];

		tipoProductos[0] = "Entrante";
		tipoProductos[1] = "Primero";
		tipoProductos[2] = "Segundo";
		tipoProductos[3] = "Bebida";
		tipoProductos[4] = "Postre";
	

		return tipoProductos;
	}


	public static String[] arrayNombreProductos(ArrayList<Producto> lista, String nombre) {

	    int tamanio = 0;

	  
	    for (int i = 0; i < lista.size(); i++) {
	        if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
	            tamanio++;
	        }
	    }

	    String[] nombres = new String[tamanio];
	    int j = 0; 
	   
	    for (int i = 0; i < lista.size(); i++) {
	        if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
	            nombres[j] = lista.get(i).getNombre();
	            j++; 
	        }
	    }

	    return nombres;
	}

	public static DefaultTableModel seleccionarModeloDeTabla(int seleccion, DefaultTableModel[] modelos) {
		DefaultTableModel modelMesa = null;

		if (seleccion == 1) {

			modelMesa = modelos[0];

		}
		if (seleccion == 2) {

			modelMesa = modelos[1];

		}
		if (seleccion == 3) {

			modelMesa = modelos[2];

		}
		if (seleccion == 4) {

			modelMesa = modelos[3];

		}
		if (seleccion == 5) {

			modelMesa = modelos[4];

		}
		if (seleccion == 6) {

			modelMesa = modelos[5];

		}

		return modelMesa;

	}

	public static double sumarColumna(JTable tabla, int num) {
		double suma = 0;

		for (int i = 0; i < tabla.getRowCount(); i++) {

			double valor = Double.parseDouble((String) tabla.getValueAt(i, num));

			suma += valor;

		}

		suma = Math.round(suma * 100.0) / 100.0;

		return suma;
	}

	public static void imprimir(JTable tabla, JPanel contentPain) {
		// public static void imprimir() {
		String nombre = JOptionPane.showInputDialog(contentPain, "INTRODUCE EL NOMBRE DEL ARCHIVO");
		// String nombre = JOptionPane.showInputDialog("INTRODUCE EL NOMBRE DEL
		// ARCHIVO");
		File archivo = new File("C:\\" + nombre + ".txt");
		// System.out.println(nombre);
		FileWriter fw = null;
		if (archivo.exists()) {
			try {
				fw = new FileWriter(archivo);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


	public static JPanel generarBotonesProductos(JPanel contenedor, ButtonGroup buttonGroup_1, String[] nombres,Metodos nombre) {

	    JPanel botonesProductos = new JPanel();
	    
	    //botonesProductos.removeAll();
	    
	    botonesProductos.setBounds(380, 11, 403, 368);
	    contenedor.add(botonesProductos);//, "botonesProductos");
	    
	    botonesProductos.setLayout(new GridLayout(3, 3, 0, 0));

	    for (int i = 0; i < nombres.length; i++) {
	        JToggleButton btnNombre = new JToggleButton(nombres[i]);
	        
	        buttonGroup_1.add(btnNombre);
	        btnNombre.setVerticalAlignment(SwingConstants.BOTTOM);
	        btnNombre.setText(nombres[i]);
	        Metodos.iconosNombreDeProducto(btnNombre, nombres[i]);
	        botonesProductos.add(btnNombre,"botonesProductos");
	        
	        

	      
	        JToggleButton currentButton = btnNombre;
	       

	        btnNombre.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	                System.out.println(currentButton.getText());
	                nombre.setNombre(currentButton.getText());
	            }
	        });
	        botonesProductos.revalidate();
	        botonesProductos.repaint();
	    }
	    
	    return botonesProductos;
	}

	public static ArrayList<ImageIcon> arrayListIconosTipoDeProducto() {
		
		ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
		
		
		ClassLoader classLoader = Metodos.class.getClassLoader();
		
		ImageIcon iconoEntrante = new ImageIcon(classLoader.getResource("entrante.png"));
		iconoEntrante.setImage(iconoEntrante.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoPrimerPlato = new ImageIcon(classLoader.getResource("primerPlato.png"));
		iconoPrimerPlato.setImage(iconoPrimerPlato.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoSegundoPlato = new ImageIcon(classLoader.getResource("segundoPlato.png"));
		iconoSegundoPlato.setImage(iconoSegundoPlato.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoBebida = new ImageIcon(classLoader.getResource("bebida.png"));
		iconoBebida.setImage(iconoBebida.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoPostre = new ImageIcon(classLoader.getResource("postre.png"));
		iconoPostre.setImage(iconoPostre.getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
		
		iconos.add(iconoEntrante);
		iconos.add(iconoPrimerPlato);
		iconos.add(iconoSegundoPlato);
		iconos.add(iconoBebida);
		iconos.add(iconoPostre);
		
		
		
		return iconos;
		
	}
	
	public static void iconosNombreDeProducto(JToggleButton btn,String nombreProducto) {
		
		ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
		
		
		ClassLoader classLoader = Metodos.class.getClassLoader();
		
		ImageIcon iconoBravas = new ImageIcon(classLoader.getResource("patatasBravas.png"));
		iconoBravas.setImage(iconoBravas.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoEnsalada = new ImageIcon(classLoader.getResource("ensalada.png"));
		iconoEnsalada.setImage(iconoEnsalada.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoCroquetas = new ImageIcon(classLoader.getResource("croqueta.png"));
		iconoCroquetas.setImage(iconoCroquetas.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoBocataBeicon = new ImageIcon(classLoader.getResource("bocataBeicon.png"));
		iconoBocataBeicon.setImage(iconoBocataBeicon.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoBocataTortilla = new ImageIcon(classLoader.getResource("tortilla.png"));
		iconoBocataTortilla.setImage(iconoBocataTortilla.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoSopa = new ImageIcon(classLoader.getResource("sopa.png"));
		iconoSopa.setImage(iconoSopa.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoPasta = new ImageIcon(classLoader.getResource("pasta.png"));
		iconoPasta.setImage(iconoPasta.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoEscapole = new ImageIcon(classLoader.getResource("escalopeDePollo.png"));
		iconoEscapole.setImage(iconoEscapole.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoHamburguesa = new ImageIcon(classLoader.getResource("hamburguesa.png"));
		iconoHamburguesa.setImage(iconoHamburguesa.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoHamburguesaXL = new ImageIcon(classLoader.getResource("hamburguesaXL.png"));
		iconoHamburguesaXL.setImage(iconoHamburguesaXL.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoPizza = new ImageIcon(classLoader.getResource("pizza.png"));
		iconoPizza.setImage(iconoPizza.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon iconoBocataDelDia = new ImageIcon(classLoader.getResource("bocataDelDia.png"));
		iconoBocataDelDia.setImage(iconoBocataDelDia.getImage().getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH));
		
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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

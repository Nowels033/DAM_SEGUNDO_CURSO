package interfaces_U1_Actividad_3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
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

		return productos;

	}

	public static String[] arrayTipoProductos() {
		String[] tipoProductos = new String[5];

		tipoProductos[0] = "Bebida";
		tipoProductos[1] = "Entrante";
		tipoProductos[2] = "Postre";
		tipoProductos[3] = "Primero";
		tipoProductos[4] = "Segundo";
	

		return tipoProductos;
	}

//	public static String[] arrayNombreProductos(ArrayList<Producto> lista, String nombre) {
//		
//		int tamanio = 0;
//		
//		for (int i = 0; i < lista.size(); i++) {
//			if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
//				
//				tamanio++;
//			}
//		}
//
//		String[] nombres = new String[tamanio];
//
//		for (int i = 0; i < lista.size(); i++) {
//			if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
//				nombres[i] = lista.get(i).getNombre();
//			}
//		}
//
//		return nombres;
//
//	}
	public static String[] arrayNombreProductos(ArrayList<Producto> lista, String nombre) {

	    int tamanio = 0;

	    // Primero contamos cuántos productos coinciden con el tipo
	    for (int i = 0; i < lista.size(); i++) {
	        if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
	            tamanio++;
	        }
	    }

	    String[] nombres = new String[tamanio];
	    int j = 0;  // Índice para el array nombres[]

	    // Ahora llenamos el array solo con los nombres que coincidan
	    for (int i = 0; i < lista.size(); i++) {
	        if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
	            nombres[j] = lista.get(i).getNombre();
	            j++;  // Incrementamos j para no sobrescribir valores en el array
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

//	public static JPanel generarBotonesProductos(JPanel contenedor, ButtonGroup buttonGroup_1, String[] nombres) {
//
//		JPanel botonesProductos = new JPanel();
//		
//		botonesProductos.setBounds(376, 50, 240, 328);
//		contenedor.add(botonesProductos,"botonesProductos");
//		
//		//contenedor.remove(botonesProductos);
//		//contenedor.add(botonesProductos,"botonesProductos");
//		botonesProductos.setLayout(new GridLayout(3, 3, 0, 0));
//
//		JToggleButton btnNombre;
//		for (int i = 0; i < nombres.length; i++) {
//			btnNombre = new JToggleButton(nombres[i]);
//			
//			buttonGroup_1.add(btnNombre);
//			btnNombre.setVerticalAlignment(SwingConstants.BOTTOM);
//			btnNombre.setText(nombres[i]);
//			
//				
//			
//			botonesProductos.add(btnNombre);
//			btnNombre.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					 
//					 System.out.println("Button clicked: " + btnNombre.getText());
//				}
//			});
//		}
//		
//		return botonesProductos;
//
//	}
	public static JPanel generarBotonesProductos(JPanel contenedor, ButtonGroup buttonGroup_1, String[] nombres,Metodos nombre) {

	    JPanel botonesProductos = new JPanel();
	    
	    
	    botonesProductos.setBounds(376, 50, 240, 328);
	    contenedor.add(botonesProductos, "botonesProductos");
	    
	    botonesProductos.setLayout(new GridLayout(3, 3, 0, 0));

	    for (int i = 0; i < nombres.length; i++) {
	        JToggleButton btnNombre = new JToggleButton(nombres[i]);
	        
	        buttonGroup_1.add(btnNombre);
	        btnNombre.setVerticalAlignment(SwingConstants.BOTTOM);
	        btnNombre.setText(nombres[i]);
	        
	        botonesProductos.add(btnNombre);

	      
	        JToggleButton currentButton = btnNombre;

	        btnNombre.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	                System.out.println(currentButton.getText());
	                nombre.setNombre(currentButton.getText());
	            }
	        });
	    }
	    
	    return botonesProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

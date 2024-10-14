package interfaces_U1_Actividad_3;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Metodos {

//	public static void main(String[] args) {
//
//	}

	public static ArrayList<Producto> iniciarProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String bebida = "Bebida", postre = "Postre", comida = "Comida";

		Producto p1 = new Producto("Cerveza", bebida, 3.0);
		Producto p2 = new Producto("Agua", bebida, 2.0);
		Producto p3 = new Producto("Refresco", bebida, 3.0);
		Producto p4 = new Producto("Zumo", bebida, 3.2);
		Producto p5 = new Producto("Fruta", postre, 2.8);
		Producto p6 = new Producto("Tarta", postre, 3.0);
		Producto p7 = new Producto("Helado", postre, 3.0);
		Producto p8 = new Producto("Racion De Patatas Bravas", comida, 9.0);
		Producto p9 = new Producto("Bocata Beicon Queso", comida, 4.5);
		Producto p10 = new Producto("Bocata De Tortilla", comida, 4.0);

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

		return productos;

	}

	public static String[] arrayTipoProductos() {
		String[] tipoProductos = new String[3];

		tipoProductos[0] = "Bebida";
		tipoProductos[1] = "Comida";
		tipoProductos[2] = "Postre";

		return tipoProductos;
	}

	public static String[] arrayNombreProductos(ArrayList<Producto> lista, String nombre) {

//		for (int i = 0; i < lista.size(); i++) {
//			if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
//				tamanio++;
//			}
//		}

		String[] nombres = new String[lista.size()];

		for (int i = 0; i < lista.size(); i++) {
			if (nombre.equalsIgnoreCase(lista.get(i).getTipo())) {
				nombres[i] = lista.get(i).getNombre();
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
			
			modelMesa=modelos[3];
			
		}
		if (seleccion == 5) {
			
			modelMesa=modelos[4];
			
		}
		if (seleccion == 6) {
			
			modelMesa=modelos[5];
			
		}
		
		return modelMesa;

	}
	
	public static double sumarColumna(JTable table, int colIndex) {
        double suma = 0;

        for (int i = 0; i < table.getRowCount(); i++) {
        	
            double valor = Double.parseDouble((String) table.getValueAt(i, colIndex));
            
                suma +=  valor; 
          
        }
        
        suma=Math.round(suma * 100.0) / 100.0;

        return suma;
    }

}

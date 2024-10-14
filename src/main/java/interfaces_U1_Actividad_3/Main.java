package interfaces_U1_Actividad_3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		

	}
	
	public static ArrayList<Producto> iniciarProductos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String bebida="Bebida",postre="Postre",comida="Comida";
		
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

}

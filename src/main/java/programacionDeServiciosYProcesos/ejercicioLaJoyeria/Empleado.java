package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Empleado extends Thread {
    private static int numEmpleados = 1;
    private int nombre = numEmpleados;
    private Cesto cesto;
    private int collaresFabricados;
    private final int NUMERO = 20;

    public Empleado(Cesto cesto) {
        this.nombre = numEmpleados++;
        this.cesto = cesto;
        this.collaresFabricados = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Collar collar = new Collar();
                for (int i = 0; i < NUMERO; i++) {
                    String color = (i % 2 == 0) ? "blanca" : "azul";
                    cesto.cogerPerla(color);
                    collar.insertarPerla();
                }
                collaresFabricados++;
            }
        } catch (NoMaterialsLeft e) {
            System.out.println(e.getMessage());
        }
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }

    public int getCollaresFabricados() {
        return collaresFabricados;
    }

    public static int getNumEmpleados() {
        return numEmpleados;
    }

    public static void setNumEmpleados(int numEmpleados) {
        Empleado.numEmpleados = numEmpleados;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Cesto getCesto() {
        return cesto;
    }

    public void setCesto(Cesto cesto) {
        this.cesto = cesto;
    }

    public void setCollaresFabricados(int collaresFabricados) {
        this.collaresFabricados = collaresFabricados;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre=" + nombre +
                ", cesto=" + cesto +
                ", collaresFabricados=" + collaresFabricados +
                '}';
    }
}

package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Empleado extends Thread {
    private Cesto cesto;
    private int collaresFabricados;

    public Empleado(Cesto cesto) {
        this.cesto = cesto;
        this.collaresFabricados = 0;
    }

    @Override
    public void run() {
        try {
            while (true) { // Sigue trabajando hasta que no haya más perlas
                Collar collar = new Collar();
                for (int i = 0; i < 20; i++) {
                    String color = (i % 2 == 0) ? "blanca" : "azul"; // Alterna colores
                    cesto.cogerPerla(color);
                    collar.insertarPerla();
                }
                collaresFabricados++; // Collar completado
            }
        } catch (NoMaterialsLeft e) {
            System.out.println(e.getMessage()); // Aviso cuando no hay más perlas
        }
    }

    public int getCollaresFabricados() {
        return collaresFabricados;
    }
}

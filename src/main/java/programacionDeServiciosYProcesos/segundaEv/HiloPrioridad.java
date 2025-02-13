package programacionDeServiciosYProcesos.segundaEv;

class HiloPrioridad extends Thread {
    private int c = 0; // Contador
    private boolean stopHilo = false;


    public HiloPrioridad(String nombre) {
        super(nombre);
    }


    public int getContador() {
        return c;
    }


    public void pararHilo() {
        stopHilo = true;
    }


    public void run() {
        // El hilo sigue ejecutándose hasta que stopHilo sea true
        while (!stopHilo) {
            c++; // Incrementa el contador
            try {
                Thread.sleep(2); // Simula trabajo del hilo
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Fin hilo " + this.getName()); // Muestra el fin del hilo
    }
}
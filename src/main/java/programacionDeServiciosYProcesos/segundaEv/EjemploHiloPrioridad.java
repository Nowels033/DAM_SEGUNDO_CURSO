package programacionDeServiciosYProcesos.segundaEv;

public class EjemploHiloPrioridad {
    public static void main(String[] args) {

        HiloPrioridad hl = new HiloPrioridad("Hilo1");
        HiloPrioridad h2 = new HiloPrioridad("Hilo2");
        HiloPrioridad h3 = new HiloPrioridad("Hilo3");


        hl.setPriority(Thread.NORM_PRIORITY); // Prioridad normal
        h2.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima
        h3.setPriority(Thread.MIN_PRIORITY); // Prioridad mínima


        hl.start();
        h2.start();
        h3.start();


        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Parar los hilos
        hl.pararHilo();
        h2.pararHilo();
        h3.pararHilo();


        System.out.println("h2 (Prioridad Máxima): " + h2.getContador());
        System.out.println("hl (Prioridad Normal): " + hl.getContador());
        System.out.println("h3 (Prioridad Mínima): " + h3.getContador());
    }
}

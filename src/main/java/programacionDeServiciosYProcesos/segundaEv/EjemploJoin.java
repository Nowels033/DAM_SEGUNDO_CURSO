package programacionDeServiciosYProcesos.segundaEv;

public class EjemploJoin {
    public static void main(String[] args) {
        // Creación de los hilos con diferentes nombres y numeros de repeticiones
        HiloJoin h1 = new HiloJoin("Hilo1", 4);
        HiloJoin h2 = new HiloJoin("Hilo2", 2);
        HiloJoin h3 = new HiloJoin("Hilo3", 1);


        h1.start();
        h2.start();
        h3.start();

        try {

            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {

            System.err.println("Error al esperar los hilos");
        }


        System.out.println("FINAL DE PROGRAMA");
    }
}
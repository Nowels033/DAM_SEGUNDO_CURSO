package programacionDeServiciosYProcesos.hilosRunnable;

public class Hilos2App {
    public static void main(String[] args) {
        Hilo [] arrayHilos = new Hilo[3];

        for (int i = 0; i < arrayHilos.length; i++) {

           new Thread(arrayHilos[i] = new Hilo()).start();
        }
    }
}

package programacionDeServiciosYProcesos.hilosRunnable;

public class Hilo implements Runnable {

    @Override
    public void run() {
        System.out.println("Soy el hilo :"+Thread.currentThread().getId());

    }
}

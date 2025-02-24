
package psp.extra;
class ContadorRegresivo extends Thread {
    private int numero;

    public ContadorRegresivo(int numero) {
        this.numero = numero;
    }

    public void run() {
        try {
            Thread.sleep(1000 * numero);
            System.out.println(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CuentaAtras {
    public static void main(String[] args) throws InterruptedException {
        Thread[] hilos = new Thread[10];

        for (int i = 0; i < 10; i++) {
            hilos[i] = new ContadorRegresivo(10 - i);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        System.out.println("¡Despegue!");
    }
}

package psp.pingPong;

class PingPong extends Thread {
    private String palabra;
    private static final Object lock = new Object();

    public PingPong(String palabra) {
        this.palabra = palabra;
    }

    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) { // 10 iteraciones por ejemplo
                System.out.println(palabra);
                System.out.flush();
                lock.notify(); // Notifica al otro hilo
                try {
                    lock.wait(); // Espera a que el otro hilo imprima
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify(); // Desbloquear en la última iteración
        }
    }
}

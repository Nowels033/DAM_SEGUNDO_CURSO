package psp.cienMetrosLisos;

class Atleta extends Thread {
    private int dorsal;
    private static final Object testigo = new Object();
    private static boolean salida = false;

    public Atleta(int dorsal) {
        this.dorsal = dorsal;
    }

    public void run() {
        synchronized (testigo) {
            while (!salida) {
                try {
                    testigo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        long inicio = System.currentTimeMillis();
        try {
            Thread.sleep(9 + (int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long fin = System.currentTimeMillis();
        System.out.println("Atleta " + dorsal + " termina en " + (fin - inicio) + "ms.");
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public static void setSalida(boolean salida) {
        Atleta.salida = salida;
    }
}

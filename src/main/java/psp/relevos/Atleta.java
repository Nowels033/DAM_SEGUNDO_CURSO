package psp.relevos;

class Atleta extends Thread {
    private String nombre;
    private static final Object testigo = new Object();
    private static int turno = 0;
    private int miTurno;

    public Atleta(String nombre, int miTurno) {
        this.nombre = nombre;
        this.miTurno = miTurno;
    }

    public void run() {
        synchronized (testigo) {
            while (turno != miTurno) {
                try {
                    testigo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nombre + " empieza a correr...");
            try {
                Thread.sleep(9000 + (int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nombre + " pasa el testigo.");
            turno++;
            testigo.notifyAll();
        }
    }
}

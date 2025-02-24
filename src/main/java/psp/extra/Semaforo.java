package psp.extra;

class Semaforo extends Thread {
    private String[] luces = { "ROJO", "AMARILLO", "VERDE" };
    private int indice = 0;

    public synchronized void cambiarLuz() {
        System.out.println("Luz: " + luces[indice]);
        try {
            Thread.sleep(indice == 0 ? 5000 : 2000); // Rojo dura 5s, los demás 2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indice = (indice + 1) % 3;
    }

    public void run() {
        while (true) {
            cambiarLuz();
        }
    }
}



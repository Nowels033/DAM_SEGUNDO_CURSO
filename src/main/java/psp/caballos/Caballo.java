package psp.caballos;

import java.util.Random;

class Caballo extends Thread {
    private String nombre;
    private static boolean carreraFinalizada = false;

    public Caballo(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        Random random = new Random();
        int distancia = 0;
        while (distancia < 100 && !carreraFinalizada) {
            distancia += random.nextInt(10);
            System.out.println(nombre + " ha recorrido " + distancia + " metros.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!carreraFinalizada) {
            carreraFinalizada = true;
            System.out.println(nombre + " ha ganado la carrera!");
        }
    }
}


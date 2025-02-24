package psp.cienMetrosLisos;


public class Carrera {
    public static void main(String[] args) {
        Atleta[] atletas = new Atleta[8];
        for (int i = 0; i < 8; i++) {
            atletas[i] = new Atleta(i + 1);
            atletas[i].start();
        }

        try {
            Thread.sleep(1000);
            System.out.println("Preparados...");
            Thread.sleep(1000);
            System.out.println("Listos...");
            Thread.sleep(1000);
            System.out.println("¡Ya!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (Atleta.class) {
            Atleta.setSalida(true);
            Atleta.class.notifyAll();
        }
    }
}

package psp.extra;

class SalaConferencias {
    private int personas = 0;
    private final int CAPACIDAD_MAX = 5;

    public synchronized void entrar(String nombre) throws InterruptedException {
        while (personas >= CAPACIDAD_MAX) {
            System.out.println(nombre + " espera para entrar.");
            wait();
        }
        personas++;
        System.out.println(nombre + " ha entrado en la sala. Personas dentro: " + personas);
    }

    public synchronized void salir(String nombre) {
        personas--;
        System.out.println(nombre + " ha salido de la sala. Personas dentro: " + personas);
        notifyAll();
    }
}

class Persona extends Thread {
    private SalaConferencias sala;
    private String nombre;

    public Persona(SalaConferencias sala, String nombre) {
        this.sala = sala;
        this.nombre = nombre;
    }

    public void run() {
        try {
            sala.entrar(nombre);
            Thread.sleep(2000);
            sala.salir(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ControlAccesoSala {
    public static void main(String[] args) {
        SalaConferencias sala = new SalaConferencias();

        for (int i = 1; i <= 10; i++) {
            new Persona(sala, "Persona " + i).start();
        }
    }
}

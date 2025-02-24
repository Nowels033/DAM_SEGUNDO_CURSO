package psp.extra;

class DatosCompartidos {
    private int valor;
    private boolean escribiendo = false;

    public synchronized void escribir(int nuevoValor) throws InterruptedException {
        while (escribiendo) {
            wait();
        }
        escribiendo = true;
        valor = nuevoValor;
        System.out.println("Escritor escribió: " + valor);
        escribiendo = false;
        notifyAll();
    }

    public synchronized int leer() throws InterruptedException {
        while (escribiendo) {
            wait();
        }
        System.out.println("Lector leyó: " + valor);
        return valor;
    }
}

class Escritor extends Thread {
    private DatosCompartidos datos;

    public Escritor(DatosCompartidos datos) {
        this.datos = datos;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                datos.escribir(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Lector extends Thread {
    private DatosCompartidos datos;

    public Lector(DatosCompartidos datos) {
        this.datos = datos;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                datos.leer();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class EscritorLector {
    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        Escritor escritor = new Escritor(datos);
        Lector lector1 = new Lector(datos);
        Lector lector2 = new Lector(datos);

        escritor.start();
        lector1.start();
        lector2.start();
    }
}

package psp.contador;

public class Contador {
    private int c = 0;

    public synchronized void incrementar() {
        c++;
    }

    public synchronized void decrementar() {
        c--;
    }

    public synchronized int getValor() {
        return c;
    }
}
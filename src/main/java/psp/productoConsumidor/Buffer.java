package psp.productoConsumidor;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int limite = 5;

    public synchronized void producir(int valor) throws InterruptedException {
        while (buffer.size() == limite) {
            wait();
        }
        buffer.add(valor);
        System.out.println("Producido: " + valor);
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int valor = buffer.poll();
        System.out.println("Consumido: " + valor);
        notifyAll();
        return valor;
    }
}


package psp.productoConsumidor;

public class ProductorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Productor p = new Productor(buffer);
        Consumidor c = new Consumidor(buffer);
        p.start();
        c.start();
    }
}
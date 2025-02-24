package psp.cajero;

public class CajeroAutomatico {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        Thread cliente1 = new Thread(() -> {
            cuenta.retirar(500);
        }, "Cliente1");

        Thread cliente2 = new Thread(() -> {
            cuenta.retirar(700);
        }, "Cliente2");

        cliente1.start();
        cliente2.start();
    }
}
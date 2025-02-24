package psp.cajero;

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void retirar(double cantidad) {
        if (cantidad <= saldo) {
            System.out.println(Thread.currentThread().getName() + " retirando " + cantidad);
            saldo -= cantidad;
        } else {
            System.out.println(Thread.currentThread().getName() + " saldo insuficiente.");
        }
    }

    public synchronized void ingresar(double cantidad) {
        System.out.println(Thread.currentThread().getName() + " ingresando " + cantidad);
        saldo += cantidad;
    }

    public double getSaldo() {
        return saldo;
    }
}

class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void retirar(int cantidad, String nombre) {
        while (saldo < cantidad) { // Espera si no hay suficiente saldo
            System.out.println(nombre + " quiere retirar " + cantidad + " pero el saldo es insuficiente. Esperando...");
            try {
                wait(); // Bloquea el hilo hasta que haya suficiente dinero
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saldo -= cantidad;
        System.out.println(nombre + " ha retirado " + cantidad + ". Saldo restante: " + saldo);
    }

    public synchronized void depositar(int cantidad) {
        saldo += cantidad;
        System.out.println("Se ha depositado " + cantidad + ". Nuevo saldo: " + saldo);
        notifyAll(); // Despierta a los hilos que estaban esperando
    }
}

class ClienteRetira extends Thread {
    private CuentaBancaria cuenta;
    private String nombre;

    public ClienteRetira(CuentaBancaria cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public void run() {
        for (int i = 0; i < 2; i++) { // Intenta retirar dinero dos veces
            cuenta.retirar(100, nombre);
            try {
                Thread.sleep(1000); // Simula tiempo de espera entre intentos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClienteDeposita extends Thread {
    private CuentaBancaria cuenta;

    public ClienteDeposita(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public void run() {
        for (int i = 0; i < 3; i++) { // Realiza 3 depósitos
            cuenta.depositar(100);
            try {
                Thread.sleep(2000); // Simula tiempo entre depósitos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BancoWaitNotify {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(50); // Saldo inicial bajo

        ClienteRetira cliente1 = new ClienteRetira(cuenta, "Cliente 1");
        ClienteRetira cliente2 = new ClienteRetira(cuenta, "Cliente 2");
        ClienteDeposita depositante = new ClienteDeposita(cuenta);

        cliente1.start();
        cliente2.start();
        depositante.start();
    }
}
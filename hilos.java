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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeerURL {
    public static void main(String[] args) {
        String urlString = "https://www.example.com"; // Cambia por cualquier URL válida
        try {
            URL url = new URL(urlString);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200) {
                BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
                lector.close();
            } else {
                System.out.println("Error: Código de respuesta " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void retirar(int cantidad, String nombre) {
        if (saldo >= cantidad) {
            System.out.println(nombre + " está retirando " + cantidad);
            saldo -= cantidad;
            System.out.println("Nuevo saldo después de la retirada: " + saldo);
        } else {
            System.out.println(nombre + " intentó retirar " + cantidad + " pero no hay saldo suficiente.");
        }
    }

    public int getSaldo() {
        return saldo;
    }
}

class Cliente extends Thread {
    private CuentaBancaria cuenta;
    private String nombre;

    public Cliente(CuentaBancaria cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public void run() {
        for (int i = 0; i < 3; i++) { // Intenta retirar dinero 3 veces
            cuenta.retirar(50, nombre);
            try {
                Thread.sleep(100); // Simula el tiempo de espera entre retiros
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BancoHilos {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100); // Saldo inicial
        Cliente cliente1 = new Cliente(cuenta, "Cliente 1");
        Cliente cliente2 = new Cliente(cuenta, "Cliente 2");

        cliente1.start();
        cliente2.start();
    }
}
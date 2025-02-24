package psp.contador;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        Thread h1 = new HiloContador(contador);
        Thread h2 = new HiloContador(contador);
        h1.start();
        h2.start();
        h1.join();
        h2.join();
        System.out.println("Valor final del contador: " + contador.getValor());
    }
}

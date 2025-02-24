package psp.pingPong;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new PingPong("Ping");
        Thread t2 = new PingPong("pong");
        t1.start();
        t2.start();
    }
}
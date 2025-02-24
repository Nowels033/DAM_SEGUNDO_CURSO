package psp.relevos;

public class Carrera {
    public static void main(String[] args) {
        Thread a1 = new Atleta("Atleta 1", 0);
        Thread a2 = new Atleta("Atleta 2", 1);
        Thread a3 = new Atleta("Atleta 3", 2);
        Thread a4 = new Atleta("Atleta 4", 3);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
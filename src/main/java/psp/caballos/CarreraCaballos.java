package psp.caballos;

public class CarreraCaballos {
    public static void main(String[] args) {
        Caballo[] caballos = {
                new Caballo("Caballo1"),
                new Caballo("Caballo2"),
                new Caballo("Caballo3"),
                new Caballo("Caballo4"),
                new Caballo("Caballo5")
        };

        for (Caballo c : caballos) {
            c.start();
        }
    }
}

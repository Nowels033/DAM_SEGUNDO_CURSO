package programacionDeServiciosYProcesos.miceApp;

public class MiceApp {


    public static void main(String[] args) {
    Mouse mickey = new Mouse();
    Mouse minny = new Mouse();
    mickey.setName("Mickey");
    minny.setName("Minny");




        mickey.start();
        minny.start();

        try {

            System.out.println("ESPERO A QUE COMA MICKY");
            mickey.join();

            System.out.println("MICKEY TERMINO DE COMER");

            if (minny.isAlive()) {
                System.out.println("MINNY sigue comiendo");
            } else {
                System.out.println("Veo que MINNY termino de comer");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        mickey.run();
//        minny.run();

    }
}

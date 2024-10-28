package programacionDeServiciosYProcesos.miceApp;

public class MiceApp {


    public static void main(String[] args) {
    Mouse mickey = new Mouse();
    Mouse minny = new Mouse();
    mickey.setName("Mickey");
    minny.setName("Minny");

    //mickey.start();
    //minny.start();


        mickey.run();
        minny.run();

    }
}

package programacionDeServiciosYProcesos.escritorApp;

public class Main {
    public static void main(String[] args) {

        /**
         * Crea 5 hilos y lanza su ejecucion
         */
        int escritores = 1;
//        Thread [] arrayEscritores = new Thread[5];
//
//        for (int i = 0; i < arrayEscritores.length; i++, escritores++) {
//
//        }
//
//        for (Thread arrayEscritore : arrayEscritores) {
//
//            Thread escritor = arrayEscritore;
//
//        }
        Thread [] arrayEscritoresTotal = new Thread[70];

        for (int i = 0; i < arrayEscritoresTotal.length; i++) {
            arrayEscritoresTotal[i] = new Thread(new Escritor("Escritor "+i));
            arrayEscritoresTotal[i].start();
        }










    }
}

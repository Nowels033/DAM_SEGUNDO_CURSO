package programacionDeServiciosYProcesos.miceApp;

import java.util.Random;

public class Mouse extends Thread{


    /**
     *
     *
     */
    @Override
    public void run(){
        Random random = new Random();
        this.comer(random.nextInt(5000));

    }

    /**
     * Simula el tiempo que esta comiendo.
     * El numero de milisegundos se pasa como parametro
     * @param ms<long> milisegundos que dormira el hilo
     */
    public void comer (long ms){

        String nombre = Thread.currentThread().getName();
        System.out.println("Soy "+nombre+" y voy a comer ("+ms+"ms).......");


        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }


        System.out.println(nombre+" : termine de comer");

    }


}

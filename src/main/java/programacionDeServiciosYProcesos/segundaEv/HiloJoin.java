package programacionDeServiciosYProcesos.segundaEv;

class HiloJoin extends Thread {
    private int n;


    public HiloJoin(String nom, int n) {
        super(nom);
        this.n = n;
    }


    public void run() {
        for (int i = 1; i <= n; i++) {
            try {

                sleep(1000);
                System.out.println(getName() + ": " + i);
            } catch (InterruptedException e) {

                System.out.println("Hilo interrumpido: " + getName());
            }
        }
        System.out.println("Fin Bucle " + getName());
    }
}


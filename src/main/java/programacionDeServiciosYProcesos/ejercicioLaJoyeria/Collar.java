package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Collar {
    private int perlasInsertadas = 0;

    public void insertarPerla() {
        perlasInsertadas++;
    }

    public boolean isComplete() {
        return perlasInsertadas == 20;
    }


}

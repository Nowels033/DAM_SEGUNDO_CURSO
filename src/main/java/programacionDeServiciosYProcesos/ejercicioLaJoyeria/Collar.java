package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Collar {
    private int perlasInsertadas = 0;

    public void insertarPerla() {
        perlasInsertadas++;
        
//        if(perlasInsertadas==20) {
//        	
//        }
    }

    public boolean isComplete() {
        return perlasInsertadas == 20;
    }


}

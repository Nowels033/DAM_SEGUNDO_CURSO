package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Cesto {
    public int perlasBlancas = 180; // Constantes integradas directamente
    public int perlasAzules = 210;

    public synchronized Perla cogerPerla(String color) throws NoMaterialsLeft {
        if (color.equals("blanca")) {
            if (perlasBlancas > 0) {
                perlasBlancas--;
                return new Perla("blanca");
            } else {
                throw new NoMaterialsLeft("No hay más perlas BLANCAS");
            }
        } else if (color.equals("azul")) {
            if (perlasAzules > 0) {
                perlasAzules--;
                return new Perla("azul");
            } else {
                throw new NoMaterialsLeft("No hay más perlas AZULES");
            }
        }
        return null; // Solo si el color no es válido
    }
}
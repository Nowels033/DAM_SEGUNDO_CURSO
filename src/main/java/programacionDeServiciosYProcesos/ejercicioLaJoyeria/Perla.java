package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Perla {
    private String color;

    public Perla(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Perla{" +
                "Color='" + color + '\'' +
                '}';
    }
}

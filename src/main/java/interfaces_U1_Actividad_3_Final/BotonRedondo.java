package interfaces_U1_Actividad_3_Final;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BotonRedondo extends JButton {

    // Constructor para inicializar el texto del botón
    public BotonRedondo(String label) {
        super(label);
        // Hace el botón no opaco para que se vea la forma redonda
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // El contexto gráfico para dibujar
        Graphics2D g2 = (Graphics2D) g;
        // Hacer los bordes más suaves (antialiasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar un botón redondo
        if (getModel().isArmed()) {
            g2.setColor(Color.LIGHT_GRAY); // Color cuando el botón está presionado
        } else {
            g2.setColor(getBackground());  // Color normal del botón
        }
        // Dibuja el círculo que representa el botón
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Dibujar el texto centrado en el botón
        super.paintComponent(g2);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Dibujar el borde del botón
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        // Verifica si el punto (x, y) está dentro de la forma redonda del botón
        Ellipse2D shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);
    }
}
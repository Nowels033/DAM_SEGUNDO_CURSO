package interfaces_U1_Actividad_2_Tabla_Eventos;

import javax.swing.*;
import javax.swing.table.*;

public class Main {
    public static void main(String[] args) {
        // Nombres de las columnas
        String[] columnNames = {"ID", "Nombre", "Edad"};
        
        // Datos de ejemplo
        Object[][] data = {
            {1, "Juan", 25},
            {2, "Ana", 30},
            {3, "Carlos", 28}
        };

        // Crear el modelo de la tabla con los datos y nombres de columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Crear la JTable con el modelo
        JTable table = new JTable(model);
        
        // Obtener el nombre de la primera columna (índice 0)
        String nombreColumna = table.getColumnName(0);
        
        // Mostrar el nombre de la columna
        System.out.println("El nombre de la primera columna es: " + nombreColumna);

        // Crear una ventana para mostrar la JTable
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
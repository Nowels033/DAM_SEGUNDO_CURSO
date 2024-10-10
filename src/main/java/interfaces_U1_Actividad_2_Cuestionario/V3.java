package interfaces_U1_Actividad_2_Cuestionario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V3 extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton btnAtras, btnSiguiente;
    private int currentQuestion = 0;
    private JProgressBar progressBar;
    
    // Respuestas
    private JCheckBox checkBox1, checkBox2;
    private JRadioButton radioButton1, radioButton2, radioButton3;
    private ButtonGroup radioGroup;
    
    // Resumen de respuestas
    private String[] respuestas = new String[3];

    public V3() {
        setTitle("Cuestionario");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel principal con CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Paneles de preguntas
        mainPanel.add(createPregunta1Panel(), "Pregunta 1");
        mainPanel.add(createPregunta2Panel(), "Pregunta 2");
        mainPanel.add(createPregunta3Panel(), "Pregunta 3");
        
        // Barra de progreso
        progressBar = new JProgressBar(0, 3);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        
        // Botones de navegación
        btnAtras = new JButton("Atrás");
        btnSiguiente = new JButton("Siguiente");
        btnAtras.addActionListener(new BtnAtrasActionListener());
        btnSiguiente.addActionListener(new BtnSiguienteActionListener());
        
        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAtras);
        buttonPanel.add(btnSiguiente);

        // Añadir todo al JFrame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(progressBar, BorderLayout.NORTH);
    }

    private JPanel createPregunta1Panel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JLabel("Pregunta 1: ¿Qué lenguajes de programación conoces?"));
        
        checkBox1 = new JCheckBox("Java");
        checkBox2 = new JCheckBox("Python");
        panel.add(checkBox1);
        panel.add(checkBox2);
        
        return panel;
    }

    private JPanel createPregunta2Panel() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JLabel("Pregunta 2: ¿Cuál es tu nivel de experiencia en Java?"));
        
        radioButton1 = new JRadioButton("Básico");
        radioButton2 = new JRadioButton("Intermedio");
        radioButton3 = new JRadioButton("Avanzado");
        
        radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioGroup.add(radioButton3);
        
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        
        return panel;
    }

    private JPanel createPregunta3Panel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Pregunta 3: ¿Te gustaría aprender más lenguajes?"));
        
        JCheckBox checkBox = new JCheckBox("Sí, me gustaría aprender más.");
        panel.add(checkBox);
        
        return panel;
    }

    private class BtnAtrasActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentQuestion > 0) {
                currentQuestion--;
                cardLayout.show(mainPanel, "Pregunta " + (currentQuestion + 1));
                progressBar.setValue(currentQuestion);
                if (currentQuestion == 0) {
                    btnAtras.setText("Cerrar");
                }
                btnSiguiente.setText("Siguiente");
            } else {
                dispose(); // Cerrar el diálogo si está en la primera pregunta
            }
        }
    }

    private class BtnSiguienteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentQuestion < 2) {
                saveAnswer();
                currentQuestion++;
                cardLayout.show(mainPanel, "Pregunta " + (currentQuestion + 1));
                progressBar.setValue(currentQuestion + 1);
                btnAtras.setText("Atrás");
                if (currentQuestion == 2) {
                    btnSiguiente.setText("Finalizar");
                }
            } else {
                saveAnswer();
                showResumen();
            }
        }
        
        private void saveAnswer() {
            if (currentQuestion == 0) {
                StringBuilder answer = new StringBuilder();
                if (checkBox1.isSelected()) answer.append("Java ");
                if (checkBox2.isSelected()) answer.append("Python ");
                respuestas[0] = answer.toString();
            } else if (currentQuestion == 1) {
                if (radioButton1.isSelected()) respuestas[1] = "Básico";
                else if (radioButton2.isSelected()) respuestas[1] = "Intermedio";
                else if (radioButton3.isSelected()) respuestas[1] = "Avanzado";
            } else if (currentQuestion == 2) {
                respuestas[2] = "Sí, me gustaría aprender más.";
            }
        }
    }

    private void showResumen() {
        String resumen = "Resumen de respuestas:\n";
        resumen += "Pregunta 1: " + respuestas[0] + "\n";
        resumen += "Pregunta 2: " + respuestas[1] + "\n";
        resumen += "Pregunta 3: " + respuestas[2] + "\n";
        
        JOptionPane.showMessageDialog(this, resumen, "Resumen", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Cerrar la aplicación después de mostrar el resumen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            V3 frame = new V3();
            frame.setVisible(true);
        });
    }
}
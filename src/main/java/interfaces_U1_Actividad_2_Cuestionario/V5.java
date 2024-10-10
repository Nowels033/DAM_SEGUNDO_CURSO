package interfaces_U1_Actividad_2_Cuestionario;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V5 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton btnAtras, btnSiguiente, btnFin;
    private int question = 0;
    private int opcion = 1;
    private JProgressBar progressBar;

    private JCheckBox checkBox1, checkBox2;
    private JRadioButton radioButton1, radioButton2, radioButton3;
    private ButtonGroup radioGroup;

    private String[] respuestas = new String[3];
    private String[] preguntas = new String[3];
    private String[] opciones = new String[7];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    V4 frame = new V4();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public V5() {

        preguntas[0] = "¿Qué lenguajes sabes de programación?";
        preguntas[1] = "¿Qué nivel tienes de programación?";
        preguntas[2] = "¿Quieres seguir aprendiendo?";

        opciones[0] = "Java";
        opciones[1] = "Python";
        opciones[2] = "Junior";
        opciones[3] = "Intermedio";
        opciones[4] = "Avanzado";
        opciones[5] = "Sí";
        opciones[6] = "No";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Barra de progreso
        progressBar = new JProgressBar(0, 3);
        progressBar.setValue(1);
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 10, 414, 20);
        contentPane.add(progressBar);

        JLabel texto = new JLabel(preguntas[question]);
        texto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
        texto.setBounds(10, 48, 385, 97);
        contentPane.add(texto);

        // Pregunta 1 (CheckBox)
        checkBox1 = new JCheckBox(opciones[0]);
        checkBox1.setBounds(33, 173, 97, 23);
        contentPane.add(checkBox1);

        checkBox2 = new JCheckBox(opciones[1]);
        checkBox2.setBounds(171, 173, 97, 23);
        contentPane.add(checkBox2);

        // RadioButtons (para la segunda pregunta)
        radioButton1 = new JRadioButton(opciones[2]);
        radioButton1.setBounds(33, 173, 100, 23);
        radioButton2 = new JRadioButton(opciones[3]);
        radioButton2.setBounds(171, 173, 100, 23);
        radioButton3 = new JRadioButton(opciones[4]);
        radioButton3.setBounds(300, 173, 100, 23);

        radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioGroup.add(radioButton3);

        // Botones de navegación
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAnswer();
                if (question < 2) {
                    question++;
                    progressBar.setValue(question + 1);
                    updateQuestion(texto);
                } else {
                    showResumen();
                }
            }
        });
        btnSiguiente.setBounds(335, 227, 89, 23);
        contentPane.add(btnSiguiente);

        btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (question > 0) {
                    question--;
                    progressBar.setValue(question + 1);
                    updateQuestion(texto);
                }
            }
        });
        btnAtras.setBounds(221, 227, 89, 23);
        contentPane.add(btnAtras);

        btnFin = new JButton("Fin");
        btnFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String resumen = "Resumen de respuestas:\n";
                resumen += "Pregunta 1: " + respuestas[0] + "\n";
                resumen += "Pregunta 2: " + respuestas[1] + "\n";
                resumen += "Pregunta 3: " + respuestas[2] + "\n";

                JOptionPane.showInputDialog( resumen,  JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        btnFin.setBounds(335, 227, 89, 23);
        contentPane.add(btnFin);
        btnFin.setVisible(false);

        btnAtras.setVisible(false);
        btnSiguiente.setVisible(false);
    }

    private void updateQuestion(JLabel texto) {
        texto.setText(preguntas[question]);
        if (question == 0) {
            checkBox1.setVisible(true);
            checkBox2.setVisible(true);
            radioButton1.setVisible(false);
            radioButton2.setVisible(false);
            radioButton3.setVisible(false);
            btnSiguiente.setVisible(true);
        } else if (question == 1) {
            checkBox1.setVisible(false);
            checkBox2.setVisible(false);
            radioButton1.setVisible(true);
            radioButton2.setVisible(true);
            radioButton3.setVisible(true);
            btnSiguiente.setVisible(true);
            btnFin.setVisible(false);
        } else if (question == 2) {
            radioButton1.setVisible(false);
            radioButton2.setVisible(false);
            radioButton3.setVisible(false);
            checkBox1.setVisible(true);
            checkBox2.setVisible(true);
            btnSiguiente.setVisible(false);
            btnFin.setVisible(true);
        }
        btnAtras.setVisible(question > 0);
    }

    private void saveAnswer() {
        if (question == 0) {
            StringBuilder answer = new StringBuilder();
            if (checkBox1.isSelected()) answer.append(opciones[0]).append(" ");
            if (checkBox2.isSelected()) answer.append(opciones[1]).append(" ");
            respuestas[0] = answer.toString();
        } else if (question == 1) {
            if (radioButton1.isSelected()) respuestas[1] = opciones[2];
            else if (radioButton2.isSelected()) respuestas[1] = opciones[3];
            else if (radioButton3.isSelected()) respuestas[1] = opciones[4];
        } else if (question == 2) {
            if (checkBox1.isSelected()) respuestas[2] = opciones[5];
            else if (checkBox2.isSelected()) respuestas[2] = opciones[6];
        }
    }

    private void showResumen() {
        String resumen = "Resumen de respuestas:\n";
        resumen += "Pregunta 1: " + respuestas[0] + "\n";
        resumen += "Pregunta 2: " + respuestas[1] + "\n";
        resumen += "Pregunta 3: " + respuestas[2] + "\n";

        JOptionPane.showMessageDialog(this, resumen, "Resumen", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
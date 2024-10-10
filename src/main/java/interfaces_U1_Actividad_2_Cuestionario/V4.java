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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JButton btnAtras, btnSiguiente,btnFin;
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
	public V4() {

		preguntas[0] = "¿Que lenguajes sabes de programacion?";
		preguntas[1] = "¿Que nivel tienes de programacion?";
		preguntas[2] = "¿Quieres seguir aprendiendo?";

		opciones[0] = "Java";
		opciones[1] = "Python";
		opciones[2] = "Junior";
		opciones[3] = "Senior";
		opciones[4] = "Si";
		opciones[5] = "No";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel texto = new JLabel(preguntas[question]);
		texto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		texto.setBounds(10, 48, 385, 97);
		contentPane.add(texto);

		checkBox1 = new JCheckBox(opciones[0]);
		checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkBox1.isSelected()) {
					
					if (question <= 1) {
						btnSiguiente.setVisible(true);
					}
					
					respuestas[question] = checkBox1.getText();

				}
				if (!checkBox1.isSelected()) {

					btnSiguiente.setVisible(false);
					respuestas[question] = checkBox1.getText();

				}

			}
		});
		checkBox1.setBounds(33, 173, 97, 23);
		contentPane.add(checkBox1);

		checkBox2 = new JCheckBox(opciones[1]);
		checkBox2.setBounds(171, 173, 97, 23);
		contentPane.add(checkBox2);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBox1.setSelected(false);
				checkBox2.setSelected(false);
				question++;
				texto.setText(preguntas[question]);
				opcion++;
				checkBox1.setText(opciones[opcion]);
				opcion++;
				checkBox2.setText(opciones[opcion]);
				btnAtras.setVisible(true);
				
				if (question > 1) {
					
					
					btnSiguiente.setVisible(false);
					btnFin.setVisible(true);
				}
				
			}
		});
		btnSiguiente.setBounds(335, 227, 89, 23);
		contentPane.add(btnSiguiente);

		btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBox1.setSelected(false);
				checkBox2.setSelected(false);
				question--;
				texto.setText(preguntas[question]);
				opcion = opcion-3;
				checkBox1.setText(opciones[opcion]);
				opcion++;
				checkBox2.setText(opciones[opcion]);
				
				if (question == 0) {
					btnAtras.setVisible(false);
				}
				if (question <= 1) {
					
					btnFin.setVisible(false);
				}
				
			}
		});
		btnAtras.setBounds(221, 227, 89, 23);
		contentPane.add(btnAtras);
		
		btnFin = new JButton("Fin");
		btnFin.setBounds(335, 227, 89, 23);
		contentPane.add(btnFin);

		btnAtras.setVisible(false);
		btnSiguiente.setVisible(false);
		btnFin.setVisible(false);

	}
}

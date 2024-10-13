package interfaces_U1_Actividad_2_Cuestionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;

public class Cuestionario_V6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupP1 = new ButtonGroup();
	private final ButtonGroup buttonGroupP2 = new ButtonGroup();
	private final ButtonGroup buttonGroupP3 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuestionario_V6 frame = new Cuestionario_V6();
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
	public Cuestionario_V6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ArrayList<String> respuestas = new ArrayList();

		String pre1 = "Pregunta1", pre2 = "Pregunta2", pre3 = "Pregunta3";
		
		String[] preguntas = new String[3];
		preguntas[0]=pre1;
		preguntas[1]=pre2;
		preguntas[2]=pre3;
		

		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);

		JPanel panel1 = new JPanel();
		contentPane.add(panel1, "panel1");
		panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel(pre1);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 24, 294, 90);
		panel1.add(lblNewLabel);

		JCheckBox chckbx1 = new JCheckBox("A");

		buttonGroupP1.add(chckbx1);
		chckbx1.setBounds(27, 140, 97, 23);
		panel1.add(chckbx1);

		JCheckBox chckbx2 = new JCheckBox("B");
		buttonGroupP1.add(chckbx2);
		chckbx2.setBounds(27, 172, 97, 23);
		panel1.add(chckbx2);

		JCheckBox chckbx3 = new JCheckBox("C");
		buttonGroupP1.add(chckbx3);
		chckbx3.setBounds(27, 205, 97, 23);
		panel1.add(chckbx3);

		JButton btnNewButton = new JButton("Siguiente");

		btnNewButton.setBounds(325, 205, 89, 23);
		panel1.add(btnNewButton);

		btnNewButton.setVisible(false);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		contentPane.add(panel2, "panel2");

		JLabel lblNewLabel_1 = new JLabel(pre2);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(31, 24, 294, 90);
		panel2.add(lblNewLabel_1);

		JRadioButton chckbx4 = new JRadioButton("A");
		buttonGroupP2.add(chckbx4);
		chckbx4.setBounds(27, 140, 97, 23);
		panel2.add(chckbx4);

		JRadioButton chckbx5 = new JRadioButton("B");
		buttonGroupP2.add(chckbx5);
		chckbx5.setBounds(27, 172, 97, 23);
		panel2.add(chckbx5);

		JRadioButton chckbx6 = new JRadioButton("C");
		buttonGroupP2.add(chckbx6);
		chckbx6.setBounds(27, 205, 97, 23);
		panel2.add(chckbx6);

	
		JButton btnNewButton_3 = new JButton("Atras");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(226, 205, 89, 23);
		panel2.add(btnNewButton_3);

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		contentPane.add(panel3, "panel3");

		JLabel lblNewLabel_2 = new JLabel(pre3);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(31, 24, 294, 90);
		panel3.add(lblNewLabel_2);

		JCheckBox chckbx7 = new JCheckBox("A");
		buttonGroupP3.add(chckbx7);
		chckbx7.setBounds(27, 140, 97, 23);
		panel3.add(chckbx7);

		JCheckBox chckbx8 = new JCheckBox("B");
		buttonGroupP3.add(chckbx8);
		chckbx8.setBounds(27, 172, 97, 23);
		panel3.add(chckbx8);

		JCheckBox chckbx9 = new JCheckBox("C");
		buttonGroupP3.add(chckbx9);
		chckbx9.setBounds(27, 205, 97, 23);
		panel3.add(chckbx9);

		JButton btnFin = new JButton("FIN");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String resumen=resumen(preguntas, respuestas);
				JOptionPane.showMessageDialog(contentPane, resumen);
				dispose();
			}
		});
		btnFin.setBounds(325, 205, 89, 23);
		panel3.add(btnFin);
		btnFin.setVisible(false);

		// PROGREES BAR

		JProgressBar progressBar = new JProgressBar(1, 3);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(10, 125, 392, 14);
		JProgressBar progressBar2 = new JProgressBar(1, 3);
		progressBar2.setForeground(Color.GREEN);
		progressBar2.setBounds(10, 125, 392, 14);
		JProgressBar progressBar3 = new JProgressBar(1, 3);
		progressBar3.setForeground(Color.GREEN);
		progressBar3.setBounds(10, 125, 392, 14);
		panel1.add(progressBar);
		panel2.add(progressBar2);
		panel3.add(progressBar3);
		
		
		
		
	//BOTON SIGUIENTE HACIA PESTAÑA3
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.show(contentPane, "panel3");
				progressBar3.setValue(3);
				buttonGroupP3.clearSelection();
				
				
			}
		});
		
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(325, 205, 89, 23);
		panel2.add(btnNewButton_1);


		// CHECKBOX PRIMERAS PREGUNTAS
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton.setVisible(true);
				respuestas.add(0, chckbx1.getText());

				// System.out.println(respuestas.get(0));

			}
		});

		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton.setVisible(true);
				respuestas.add(0, chckbx2.getText());

			}
		});

		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton.setVisible(true);
				respuestas.add(0, chckbx3.getText());

			}
		});
		// CHECKBOX Segundas PREGUNTAS
				chckbx4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnNewButton_1.setVisible(true);
						respuestas.add(1, chckbx4.getText());

						// System.out.println(respuestas.get(0));

					}
				});

				chckbx5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnNewButton_1.setVisible(true);
						respuestas.add(1, chckbx5.getText());

					}
				});

				chckbx6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnNewButton_1.setVisible(true);
						respuestas.add(1, chckbx6.getText());

					}
				});
				// CHECKBOX TERCERA PREGUNTA
				chckbx7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnFin.setVisible(true);
						respuestas.add(2, chckbx7.getText());

						// System.out.println(respuestas.get(0));

					}
				});

				chckbx8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnFin.setVisible(true);
						respuestas.add(2, chckbx8.getText());

					}
				});

				chckbx9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						btnFin.setVisible(true);
						respuestas.add(2, chckbx9.getText());

					}
				});
		// SIGUIENTE PESTAÑA DESDE PANEL1 A PANEL2
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(contentPane, "panel2");
				progressBar2.setValue(2);
				buttonGroupP2.clearSelection();

			}
		});

		// VOLVER A PANEL1
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardLayout.show(contentPane, "panel1");
				respuestas.remove(0);
				buttonGroupP1.clearSelection();
				btnNewButton.setVisible(false);
				
				
			}
		});
		
		//VOLVER A PANEL 2
				JButton btnAtras3P = new JButton("Atras");
				btnAtras3P.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						cardLayout.show(contentPane, "panel2");
						btnNewButton_1.setVisible(false);
						buttonGroupP2.clearSelection();
						respuestas.remove(1);
					}
				});
				btnAtras3P.setBounds(216, 205, 89, 23);
				panel3.add(btnAtras3P);

	}
	
	public static String resumen(String[] preguntas,ArrayList<String> respuestas ) {
		String resumen ="";
		
		for (int i = 0; i < preguntas.length; i++) {
			
			resumen += "Pregunta "+(i+1)+": "+preguntas[i]+" "+"Tu respuesta : "+respuestas.get(i)+"\n";
			
			
		}
		return resumen;
	}
}

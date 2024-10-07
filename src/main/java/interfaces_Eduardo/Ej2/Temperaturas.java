package interfaces_Eduardo.Ej2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Temperaturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField resultado;
	private JTextField introducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperaturas frame = new Temperaturas();
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
	public Temperaturas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cº", "Kelvin", "Fahrenheit"}));
		comboBox.setBounds(35, 92, 123, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cº", "Kelvin", "Fahrenheit"}));
		comboBox_1.setBounds(271, 92, 123, 22);
		contentPane.add(comboBox_1);

		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(235, 156, 159, 20);
		contentPane.add(resultado);
		resultado.setColumns(10);

		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(242, 227, 89, 23);
		contentPane.add(btnNewButton);

		introducido = new JTextField();
		introducido.setBounds(173, 49, 86, 20);
		contentPane.add(introducido);
		introducido.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("TEMPERATURA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(173, 36, 86, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblTemperaturaConvertida = new JLabel("TEMPERATURA CONVERTIDA");
		lblTemperaturaConvertida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperaturaConvertida.setBorder(new LineBorder(Color.RED, 3, true));
		lblTemperaturaConvertida.setBounds(23, 147, 176, 38);
		contentPane.add(lblTemperaturaConvertida);

		JLabel lblNewLabel_1_1 = new JLabel("DESDE :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(53, 64, 86, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("A :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(292, 64, 86, 14);
		contentPane.add(lblNewLabel_1_2);

		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion1 = comboBox.getSelectedItem().toString();
				String seleccion2 = comboBox_1.getSelectedItem().toString();

				Double numero = Double.parseDouble(introducido.getText());

				if (seleccion1.equalsIgnoreCase("Cº") && seleccion2.equalsIgnoreCase("Cº")) {

					resultado.setText(numero + "Cº");

				}
				
				if (seleccion1.equalsIgnoreCase("Cº") && seleccion2.equalsIgnoreCase("Kelvin")) {

					resultado.setText(Calculos.gradosToKelvin(numero) + " K");

				}
				if (seleccion1.equalsIgnoreCase("Cº") && seleccion2.equalsIgnoreCase("Fahrenheit")) {

					resultado.setText(Calculos.gradosToFaren(numero) + " F");

				}
				if (seleccion1.equalsIgnoreCase("Kelvin") && seleccion2.equalsIgnoreCase("Kelvin")) {

					resultado.setText(numero + " K");

				}
				
				if (seleccion1.equalsIgnoreCase("Kelvin") && seleccion2.equalsIgnoreCase("Cº")) {

					resultado.setText(Calculos.kelvinToGrados(numero) + " Cº");

				}
				
				if (seleccion1.equalsIgnoreCase("Kelvin") && seleccion2.equalsIgnoreCase("Fahrenheit")) {

					resultado.setText(Calculos.kelvinToFaren(numero) + " F");

				}
				
				if (seleccion1.equalsIgnoreCase("Fahrenheit") && seleccion2.equalsIgnoreCase("Fahrenheit")) {

					resultado.setText(numero + " F");

				}
				
				if (seleccion1.equalsIgnoreCase("Fahrenheit") && seleccion2.equalsIgnoreCase("Cº")) {

					resultado.setText(Calculos.farenToGrados(numero) + " Cº");

				}
				
				if (seleccion1.equalsIgnoreCase("Fahrenheit") && seleccion2.equalsIgnoreCase("Kelvin")) {

					resultado.setText(Calculos.farenToKelvin(numero) + " K");

				}
			}
		});
		calcular.setBounds(292, 193, 89, 23);
		contentPane.add(calcular);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main.main(null);
				dispose();
			}
		});
		btnMenu.setBounds(97, 227, 89, 23);
		contentPane.add(btnMenu);
	}
}

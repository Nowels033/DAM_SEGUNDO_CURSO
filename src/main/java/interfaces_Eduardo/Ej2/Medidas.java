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
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Medidas extends JFrame {

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
					Medidas frame = new Medidas();
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
	public Medidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Milimetros (MM)", "Centimetros(CM)", "Metros(M)", "Kilometros(KM)" }));
		comboBox.setBounds(29, 88, 135, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Milimetros (MM)", "Centimetros(CM)", "Metros(M)", "Kilometros(KM)"}));
		comboBox_1.setBounds(276, 88, 135, 22);
		contentPane.add(comboBox_1);

		JLabel lblNewLabel = new JLabel("MEDIDA CONVERTIDA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(Color.RED, 3, true));
		lblNewLabel.setBounds(97, 143, 176, 38);
		contentPane.add(lblNewLabel);

		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setColumns(10);
		resultado.setBounds(296, 152, 86, 20);
		contentPane.add(resultado);

		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton.setBounds(227, 227, 89, 23);
		contentPane.add(btnNewButton);

		introducido = new JTextField();
		introducido.setColumns(10);
		introducido.setBounds(177, 57, 86, 20);
		contentPane.add(introducido);

		JLabel lblNewLabel_1 = new JLabel("MEDIDA");
		lblNewLabel_1.setBounds(189, 32, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seleccion1 = comboBox.getSelectedItem().toString();
				String seleccion2 = comboBox_1.getSelectedItem().toString();

				Double numero = Double.parseDouble(introducido.getText());

				if (seleccion1.equalsIgnoreCase("Milimetros (MM)") && seleccion2.equalsIgnoreCase("Milimetros (MM)")) {

					resultado.setText(numero + " MM");

				}
				
				if (seleccion1.equalsIgnoreCase("Milimetros (MM)") && seleccion2.equalsIgnoreCase("Centimetros(CM)")) {

					resultado.setText(Calculos.milimetroCentimetro(numero) + " CM");

				}
				
				if (seleccion1.equalsIgnoreCase("Milimetros (MM)") && seleccion2.equalsIgnoreCase("Metros(M)")) {

					resultado.setText(Calculos.milimetroMetro(numero) + " Metros");

				}
				
				if (seleccion1.equalsIgnoreCase("Milimetros (MM)") && seleccion2.equalsIgnoreCase("Kilometros(KM)")) {

					resultado.setText(Calculos.milimetroKm(numero) + " KM");

				}
				
				if (seleccion1.equalsIgnoreCase("Centimetros(CM)") && seleccion2.equalsIgnoreCase("Centimetros(CM)")) {

					resultado.setText(numero + " CM");

				}
				
				if (seleccion1.equalsIgnoreCase("Centimetros(CM)") && seleccion2.equalsIgnoreCase("Milimetros (MM)")) {

					resultado.setText(Calculos.centimetroMilimetro(numero) + " MM");

				}
				
				if (seleccion1.equalsIgnoreCase("Centimetros(CM)") && seleccion2.equalsIgnoreCase("Metros(M)")) {

					resultado.setText(Calculos.centimetroMetro(numero) + " M");

				}
				
				if (seleccion1.equalsIgnoreCase("Centimetros(CM)") && seleccion2.equalsIgnoreCase("Kilometros(KM)")) {

					resultado.setText(Calculos.centimetroKm(numero) + " KM");

				}

			}
		});
		calcular.setBounds(293, 183, 89, 23);
		contentPane.add(calcular);
		
		JLabel lblNewLabel_1_1 = new JLabel("DESDE :");
		lblNewLabel_1_1.setBounds(46, 60, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("A :");
		lblNewLabel_1_2.setBounds(319, 60, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main.main(null);
				dispose();
			}
		});
		btnMenu.setBounds(75, 227, 89, 23);
		contentPane.add(btnMenu);
	}
}

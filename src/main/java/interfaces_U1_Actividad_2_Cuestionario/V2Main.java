package interfaces_U1_Actividad_2_Cuestionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V2Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texto;
	private String respuesta1, respuesta2, respuesta3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V2Main frame = new V2Main();
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
	public V2Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 472, 308);
		contentPane.add(panel,"panel1");
		

		JPanel panel2 = new JPanel();
		panel.setBounds(10, 11, 472, 283);
		panel.setLayout(new CardLayout(0, 0));

		texto = new JTextField();
		texto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texto.setText("¿Cuantas veces te duchas a la semana?");
		texto.setEditable(false);
		panel.add(texto, "name_11359338132300");
		texto.setColumns(10);
		contentPane.add(panel2);
		panel2.setLayout(new CardLayout(0, 0));
		JCheckBox check1 = new JCheckBox("<6");
		JCheckBox check2 = new JCheckBox("0");
		JCheckBox check3 = new JCheckBox("7");

		JButton siguiente = new JButton("Siguiente");
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				texto.setText("¿FUMAS?");
				siguiente.setVisible(false);
				check1.setSelected(false);
				check2.setSelected(false);
				check3.setSelected(false);
				
				
				
			}
		});
		siguiente.setBounds(374, 305, 89, 23);

		 
		check1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (check1.isSelected()) {

					respuesta1 = check1.getText();

					siguiente.setVisible(true);
				}
				if (!check1.isSelected()) {

					respuesta1 ="";

					siguiente.setVisible(false);
				}
			}
		});
		check1.setBounds(20, 300, 97, 23);
		contentPane.add(check1);

		
		check2.setBounds(132, 301, 97, 23);
		contentPane.add(check2);
		
		check2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (check2.isSelected()) {

					respuesta1 = check1.getText();

					siguiente.setVisible(true);
				}
				if (!check2.isSelected()) {

					respuesta1 ="";

					siguiente.setVisible(false);
				}
			}
		});

		
		check3.setBounds(231, 301, 97, 23);
		contentPane.add(check3);

		// contentPane.add(siguiente);
		contentPane.add(siguiente);
		siguiente.setVisible(false);

	}
}

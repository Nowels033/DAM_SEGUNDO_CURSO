package interfaces_U1_Actividad_2_Cuestionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Prueba_Sabado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout = new CardLayout(0, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba_Sabado frame = new Prueba_Sabado();
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
	public Prueba_Sabado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel texto1 = new JPanel();
		texto1.setForeground(new Color(255, 255, 255));
		texto1.setBounds(0, 0, 424, 190);
		contentPane.add(texto1,"texto1");
		texto1.setLayout(cardLayout);
		
		JPanel texto2 = new JPanel();
		texto2.setForeground(Color.WHITE);
		texto2.setBounds(0, 0, 424, 190);
		contentPane.add(texto2,"texto2");
		texto2.setLayout(cardLayout);
		
		JPanel texto3 = new JPanel();
		texto3.setForeground(Color.WHITE);
		texto3.setBounds(0, 0, 424, 190);
		contentPane.add(texto3,"texto3");
		texto3.setLayout(cardLayout);
		
		JCheckBox checkA = new JCheckBox("New check box");
		checkA.setBounds(10, 195, 97, 23);
		contentPane.add(checkA);
		
		JCheckBox checkB = new JCheckBox("New check box");
		checkB.setBounds(140, 195, 97, 23);
		contentPane.add(checkB);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setVisible(false);
		btnAtras.setBounds(229, 227, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnSig = new JButton("Siguiente");
		btnSig.setVisible(false);
		btnSig.setBounds(335, 227, 89, 23);
		contentPane.add(btnSig);
		
		JButton btnFin = new JButton("Fin");
		btnFin.setVisible(false);
		btnFin.setBounds(335, 227, 89, 23);
		contentPane.add(btnFin);
	}
}

package interfaces_U1_Actividad_3_Final;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupMesas = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 470);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		CardLayout cardLayoutMesas = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayoutMesas);
		//add(contentPane,"panelInicial");
		
		JPanel mesas = new JPanel();
		getContentPane().add(mesas, "mesas");
		mesas.setLayout(new GridLayout(0, 3, 0, 0));
		mesas.setVisible(true);
		
		
		int numMesas=Integer.parseInt(JOptionPane.showInputDialog("¿CUANTAS MESAS TIENES EN EL SERVICIO?"));
		//System.out.println(numMesas);
		
		
		for (int i = 0; i < numMesas; i++) {
			
			JToggleButton btnMesa = new JToggleButton("Mesa ");
			buttonGroupMesas.add(btnMesa);
			btnMesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnMesa.setVerticalAlignment(SwingConstants.BOTTOM);
			btnMesa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnMesa.setText("Mesa "+(i+1));
			btnMesa.setVisible(true);
			btnMesa.setIcon(iconoMesas());
			System.out.println(numMesas);
			mesas.add(btnMesa);
			
			btnMesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			
		}
		
		
	}
	
	private static ImageIcon iconoMesas() {
		// ICONO DE MESA

				ClassLoader classLoader =Prueba.class.getClassLoader() ;//getClass().getClassLoader();
				ImageIcon imageiconMesa = new ImageIcon(classLoader.getResource("comedor.png"));
				imageiconMesa.setImage(imageiconMesa.getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH));
				
				return imageiconMesa;
	}

}

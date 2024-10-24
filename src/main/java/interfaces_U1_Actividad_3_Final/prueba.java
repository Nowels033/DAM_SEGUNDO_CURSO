package interfaces_U1_Actividad_3_Final;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupMesas = new ButtonGroup();
	private int numMesas=0;
	private JToggleButton[] botonesMesas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_100905143017200");
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	
		
		
		//numMesas=Integer.parseInt(JOptionPane.showInputDialog("¿CUANTAS MESAS TIENES EN EL SERVICIO?"));  
		
		
		
		
		// botonesMesas=generarBotonesMesasYArray(buttonGroupMesas, numMesas, mesas);
		
		
		
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public int getNumMesas() {
		return numMesas;
	}

	public void setNumMesas(int numMesas) {
		this.numMesas = numMesas;
	}

	public JToggleButton[] getBotonesMesas() {
		return botonesMesas;
	}

	public void setBotonesMesas(JToggleButton[] botonesMesas) {
		this.botonesMesas = botonesMesas;
	}

	public ButtonGroup getButtonGroupMesas() {
		return buttonGroupMesas;
	}
	
	private static ImageIcon iconoMesas() {
		// ICONO DE MESA

		ClassLoader classLoader = Mesa.class.getClassLoader();// getClass().getClassLoader();
		ImageIcon imageiconMesa = new ImageIcon(classLoader.getResource("comedor.png"));
		imageiconMesa.setImage(imageiconMesa.getImage().getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH));

		return imageiconMesa;
	}

	private static JToggleButton[]  generarBotonesMesasYArray(ButtonGroup buttonGroupMesas, int numMesas, JPanel mesas) {
		
		JToggleButton[] botonesMesas = new JToggleButton[numMesas];
		JToggleButton btnMesa = new JToggleButton("Mesa ");
		for (int i = 0; i < numMesas; i++) {

			
			buttonGroupMesas.add(btnMesa);
			btnMesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnMesa.setVerticalAlignment(SwingConstants.BOTTOM);
			btnMesa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnMesa.setText("Mesa " + (i + 1));
			btnMesa.setVisible(true);
			btnMesa.setIcon(iconoMesas());
			System.out.println(numMesas);
			mesas.add(btnMesa);

			btnMesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			botonesMesas[i]=btnMesa;
		}
		
		return botonesMesas;
	}
	

}

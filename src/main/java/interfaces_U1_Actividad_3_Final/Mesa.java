package interfaces_U1_Actividad_3_Final;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Mesa extends JPanel {

	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupMesas = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public Mesa() {
		
		CardLayout cardLayoutMesas = new CardLayout(0, 0);
		setLayout(cardLayoutMesas);
		
		JPanel mesas = new JPanel();
		add(mesas, "mesas");
		mesas.setLayout(new GridLayout(0, 3, 0, 0));
		mesas.setVisible(true);
		
		JButton btnNewButton = new JButton("New button");
		mesas.add(btnNewButton);
		
		int numMesas=Integer.parseInt(JOptionPane.showInputDialog("¿CUANTAS MESAS TIENES EN EL SERVICIO?"));
		//System.out.println(numMesas);
		
		JToggleButton btnMesa = new JToggleButton("Mesa ");
		for (int i = 0; i < numMesas; i++) {
			

			buttonGroupMesas.add(btnMesa);
			btnMesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnMesa.setVerticalAlignment(SwingConstants.BOTTOM);
			btnMesa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnMesa.setText("Mesa "+(i+1));
			btnMesa.setVisible(true);
			System.out.println(numMesas);
			mesas.add(btnMesa);
			
			btnMesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			
		}
		
		
		

	}

}

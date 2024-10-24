package interfaces_U1_Actividad_3_Final;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.table.TableModel;

public class Comanda extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tablaComandas;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Comanda dialog = new Comanda();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Comanda(JFrame frame,DefaultTableModel modeloTabla) {
		super(frame, "COMANDA", true);
		setLocationRelativeTo(frame);
		setBounds(100, 100, 1067, 524);
		getContentPane().setLayout(new BorderLayout());
		
		
		tablaComandas=new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaComandas);

       
        getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
				JButton aniadirButton = new JButton("AÑADIR");
				aniadirButton.setActionCommand("OK");
				buttonPane.add(aniadirButton);
			
				JButton modificarButton = new JButton("MODIFICAR");
				modificarButton.setActionCommand("OK");
				buttonPane.add(modificarButton);
				getRootPane().setDefaultButton(modificarButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
				
		
		
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cerrarDialogo();
			}
		});
	}
	private void cerrarDialogo() {
        getOwner().setVisible(true); 
        setVisible(false);
    }

}

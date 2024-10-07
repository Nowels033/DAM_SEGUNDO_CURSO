package interfaces_U1_Actividad_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tareas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tareas frame = new Tareas();
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
	public Tareas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		DefaultListModel listModel = new DefaultListModel<String>();
		list.setModel(listModel);
		//list.add("HOLA");
		list.setBounds(37, 42, 354, 136);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("AÑADIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement("HOLA");
				
			}
		});
		btnNewButton.setBounds(25, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(124, 227, 103, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionado = list.getSelectedIndex();
				if(seleccionado != -1) {
					
					System.out.println(" "+listModel.getSize()+" "+seleccionado);
					listModel.remove(seleccionado);
					//System.out.println(" "+listModel.getSize());
				}
				else {
					JOptionPane.showMessageDialog(null, "No seleccionaste NINGUN elemento de la lista para BORRAR");
				}

			}
		});
		btnEliminar.setBounds(237, 227, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnNewButton_2_1 = new JButton("SALIR");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("TAREAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel.setBounds(103, 17, 197, 14);
		contentPane.add(lblNewLabel);
	}
}

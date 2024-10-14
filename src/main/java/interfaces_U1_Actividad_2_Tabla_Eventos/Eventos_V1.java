package interfaces_U1_Actividad_2_Tabla_Eventos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Eventos_V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnCrear;
	private JButton btnBorrar;
	private JPanel panel2;
	private JTextField nombre;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventos_V1 frame = new Eventos_V1();
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
	public Eventos_V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "panel1");
		panel.setLayout(null);
		
		String[] columnNames = {"Nombre", "Tipo", "Fecha"};
	        
	       
	    Object[][] data = {
	            {"PONER UN 10 A NOEL", "EXAMENES", "TODOS LOS EXAMENES"},
	          
	        };
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable();
		table.setModel(model);
		table.setBounds(25, 47, 475, 170);
		panel.add(table);
		
		
		
		JLabel lblNewLabel = new JLabel("EVENTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(158, 22, 174, 14);
		panel.add(lblNewLabel);
		
		btnCrear = new JButton("Nuevo");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.show(contentPane, "panel2");
				
			}
		});
		btnCrear.setBounds(59, 228, 89, 23);
		panel.add(btnCrear);
		
		btnBorrar = new JButton("Borrar");
		
		btnBorrar.setBounds(327, 228, 89, 23);
		panel.add(btnBorrar);
		
		panel2 = new JPanel();
		contentPane.add(panel2, "panel2");
		panel2.setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(160, 8, 110, 20);
		panel2.add(nombre);
		nombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Introduce el Nombre");
		lblNewLabel_1.setBounds(23, 11, 127, 14);
		panel2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Evento");
		lblNewLabel_2.setBounds(23, 43, 110, 14);
		panel2.add(lblNewLabel_2);
		
		JComboBox evento = new JComboBox();
		evento.setModel(new DefaultComboBoxModel(new String[] {"Fiesta", "Concierto", "Vip"}));
		evento.setBounds(160, 39, 110, 22);
		panel2.add(evento);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha");
		lblNewLabel_2_1.setBounds(23, 72, 110, 14);
		panel2.add(lblNewLabel_2_1);
		
		JButton btnOk = new JButton("Ok");
		
		btnOk.setBounds(397, 57, 89, 54);
		panel2.add(btnOk);
		
		JButton btnNewButton = new JButton("Cancelar");
		
		btnNewButton.setBounds(397, 141, 89, 55);
		panel2.add(btnNewButton);
		
		JSlider slider_dia = new JSlider();
		slider_dia.setPaintTicks(true);
		slider_dia.setPaintLabels(true);
		
		slider_dia.setValue(1);
		slider_dia.setMaximum(31);
		slider_dia.setMinimum(1);
		slider_dia.setBounds(57, 120, 139, 44);
		panel2.add(slider_dia);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Dia:");
		lblNewLabel_2_1_1.setBounds(47, 97, 110, 14);
		panel2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mes:");
		lblNewLabel_2_1_1_1.setBounds(47, 161, 110, 14);
		panel2.add(lblNewLabel_2_1_1_1);
		
		JSlider slider_mes = new JSlider();
		slider_mes.setValue(1);
		slider_mes.setMaximum(12);
		slider_mes.setMinimum(1);
		slider_mes.setBounds(57, 197, 139, 26);
		panel2.add(slider_mes);
		
		JLabel labelDia = new JLabel(slider_dia.getValue()+"");
		labelDia.setBounds(207, 128, 46, 14);
		panel2.add(labelDia);
		
		JLabel labelMes = new JLabel(slider_mes.getValue()+"");
		labelMes.setBounds(207, 197, 46, 14);
		panel2.add(labelMes);
		
		slider_dia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				labelDia.setText(slider_dia.getValue()+"");
			}
		});
		slider_mes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				labelMes.setText(slider_mes.getValue()+"");
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int seleccion = table.getSelectedRow();
			
			if (seleccion >= 0) {
				model.removeRow(seleccion);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No seleccionaste ninguna fila");
			}
			
			
			
			
				
				
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] introducir = new Object[3];
				introducir[0] = nombre.getText();
				introducir[1] = (String)evento.getSelectedItem();
				introducir[2] = "Dia: "+slider_dia.getValue()+",Mes: "+slider_mes.getValue()+", Año : 2024";
				
				model.addRow(introducir);
				cardLayout.show(contentPane, "panel1");
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "panel1");
			}
		});
		
//		Ejercicio 3: Tabla de Eventos
//
//		Crear una aplicación que muestre una tabla con 3 columnas "Nombre"-"Tipo"-"Fecha" y un botón "Incluir evento" que habra una ventana de diálogo.
//		En esta ventana habrá un formulario dónde incluir el Nombre como TextField, el tipo dentro de una serie de posibilidades "Fiesta"-"Concierto"-"VIP",
//		y la fecha a través de slider.
		
		
	}
}

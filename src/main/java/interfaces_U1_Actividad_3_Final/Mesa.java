package interfaces_U1_Actividad_3_Final;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import javax.swing.table.DefaultTableModel;

public class Mesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupMesas = new ButtonGroup();
	private int numMesas = 0;
	private JToggleButton[] botonesMesas;
	private DefaultTableModel[] modelosDeTabla;
	private Comanda dialogoComanda;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Mesa() {
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 524);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setVisible(true);
		CardLayout cardLayoutMesas = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayoutMesas);
		// add(contentPane,"panelInicial");

		JPanel mesas = new JPanel();
		getContentPane().add(mesas, "mesas");

		mesas.setVisible(true);
		mesas.setLayout(new GridLayout(0, 3, 0, 0));

		setNumMesas(Integer.parseInt(JOptionPane.showInputDialog("¿CUANTAS MESAS TIENES EN EL SERVICIO?")));
		
		setModelosDeTabla(generarModelosDeLasTablasDeMesas(getNumMesas()));
		
		setBotonesMesas(generarBotonesMesasYArray(getButtonGroupMesas(), mesas,getModelosDeTabla()));
		
		

	}

	public JPanel getContentPane() {
		return contentPane;
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

	public DefaultTableModel[] getModelosDeTabla() {
		return modelosDeTabla;
	}

	public void setModelosDeTabla(DefaultTableModel[] modelosDeTabla) {
		this.modelosDeTabla = modelosDeTabla;
	}
	
	public Comanda getDialogoComanda() {
		return dialogoComanda;
	}

	public void setDialogoComanda(Comanda dialogoComanda) {
		this.dialogoComanda = dialogoComanda;
	}
	
	///////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////

	

	private static ImageIcon iconoMesas() {
		// ICONO DE MESA

		ClassLoader classLoader = Mesa.class.getClassLoader();// getClass().getClassLoader();
		ImageIcon imageiconMesa = new ImageIcon(classLoader.getResource("comedor.png"));
		imageiconMesa.setImage(imageiconMesa.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));

		return imageiconMesa;
	}

	private JToggleButton[] generarBotonesMesasYArray(ButtonGroup buttonGroupMesas, JPanel mesas,DefaultTableModel[] modelosDeTabla ) {

		JToggleButton[] botonesMesas = new JToggleButton[modelosDeTabla.length];

		for (int i = 0; i < modelosDeTabla.length; i++) {

			JToggleButton btnMesa = new JToggleButton("Mesa ");
			buttonGroupMesas.add(btnMesa);
			btnMesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnMesa.setVerticalAlignment(SwingConstants.CENTER);
			btnMesa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnMesa.setText("Mesa " + (i + 1));
			btnMesa.setVisible(true);
			btnMesa.setHorizontalTextPosition(SwingConstants.CENTER);
			btnMesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnMesa.setIcon(iconoMesas());
			//System.out.println(numMesas);
			mesas.add(btnMesa);
			setDialogoComanda(new Comanda(this,modelosDeTabla[i]));
			getDialogoComanda().setVisible(false);
			final int index = i;
			btnMesa.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	
			    	
			    	//LISTENER MESA
			    	
			        abrirDialogo(modelosDeTabla[index]);
			    }
			});
			botonesMesas[i] = btnMesa;
		}

		return botonesMesas;
	}

	public static JToggleButton getBotonMesaElegida(int nDeMesa, JToggleButton[] botonesMesas) {
		JToggleButton boton = new JToggleButton("MESA NO ENCONTRADA");
		for (int i = 0; i < botonesMesas.length; i++) {

			if (botonesMesas[i].getText().equalsIgnoreCase("Mesa " + nDeMesa)) {

				return botonesMesas[i];
			}
		}
		return boton;
	}

	private static DefaultTableModel[] generarModelosDeLasTablasDeMesas(int numMesas) {
		DefaultTableModel[] modelosTablas = new DefaultTableModel[numMesas];

		// MODELOS DE LAS TABLAS DE LAS MESAS

		String[] columnNames = { "Nombre", "Tipo", "Cantidad", "Precio", "Precio Total" };

		Object[][] data = { {},

		};

		for (int i = 0; i < numMesas; i++) {

			DefaultTableModel modelMesa = new DefaultTableModel(data, columnNames);
			modelMesa.removeRow(0);
			modelosTablas[i] = modelMesa;

		}

		return modelosTablas;

	}
	
	private void abrirDialogo(DefaultTableModel modeloTabla) {
		Comanda dialogoComanda = new Comanda(this, modeloTabla);
        setVisible(false);
        dialogoComanda.setVisible(true);
        getButtonGroupMesas().clearSelection();
    }

}

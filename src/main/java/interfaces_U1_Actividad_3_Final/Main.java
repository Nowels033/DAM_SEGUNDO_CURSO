package interfaces_U1_Actividad_3_Final;

import java.awt.EventQueue;

import interfaces_U1_Actividad_3.Tpv_V5FINAL;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesa frame = new Mesa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

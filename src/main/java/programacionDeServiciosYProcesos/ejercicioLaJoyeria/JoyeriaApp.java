package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

import java.util.ArrayList;
import java.util.Scanner;

public class JoyeriaApp {
    public static void main(String[] args) {
        Cesto cesto = new Cesto();
        ArrayList<Empleado> empleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int numeroEmpleados;
        System.out.println("Ingrese el numero de empleados: ");
        numeroEmpleados = sc.nextInt();



    
        for (int i = 0; i < numeroEmpleados; i++) {
            empleados.add(new Empleado(cesto));
        }

        for (Empleado empleado : empleados) {
            empleado.start();
            
        }

       
        for (Empleado empleado : empleados) {
            try {
                empleado.join();
//                try {
//    				empleado.sleep(500);
//    			} catch (InterruptedException e) {
//    				// TODO Auto-generated catch block
//    				e.printStackTrace();
//    			}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalCollares = 0;
        for (Empleado empleado : empleados) {
            System.out.println("Empleado : "+empleado.getNombre()+", fabrico : "+empleado.getCollaresFabricados()+" collares");
            totalCollares += empleado.getCollaresFabricados();
        }

        System.out.println("Número total de collares fabricados: " + totalCollares);
    }
}
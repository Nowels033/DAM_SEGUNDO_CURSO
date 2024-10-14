package programacionDeServiciosYProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrearProceso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//String[] params = {"notepad.exe","pepe.txt"};
			String[] params = {"cmd.exe","/c dir"};
			
			//Process proceso1 = Runtime.getRuntime().exec("notepad.exe");
//			Process proceso1 = Runtime.getRuntime().exec(params);
			Process proceso1 = Runtime.getRuntime().exec("cmd /c dir .");
			
			//leemos la salida del proceso creado:
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
			
			System.out.println("SALIDA DEL SUB-PROCESO\n");//+br.readLine());
			String line =null;
			do {
				line = br.readLine();
				
				System.out.println(line);
				
				
				
				
			//} while (!line.equalsIgnoreCase(""));
			} while (!br.readLine().isEmpty());
			int retValue = proceso1.waitFor();
			System.out.println("El proceso termino con un codigo de : "+retValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

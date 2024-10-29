package programacionDeServiciosYProcesos.crearProceso;

import java.io.File;
import java.io.IOException;

public class CrearProcesoProcessBuilder {

	public static void main(String[] args) {
		String[] parametros = {"notepad.exe","juan.txt"};
		//ProcessBuilder pBuilder = new ProcessBuilder("cmd /c dir .");
		ProcessBuilder pBuilder = new ProcessBuilder("notepad.exe", "pepe.txt");// C:\\Users\\ALUMNO CCC - TARDE\\pruebas\\juan.txt");
		//ProcessBuilder pBuilder = new ProcessBuilder(parametros);// C:\\Users\\ALUMNO CCC - TARDE\\pruebas\\juan.txt");
		
		try {

			pBuilder.directory(new File("C:\\Users\\ALUMNO CCC - TARDE\\pruebas"));
			Process p = pBuilder.start();
			
			int codigoRetorno = p.waitFor();
			
			System.out.println("El proceso finalizo con codigo :"+codigoRetorno);
			System.out.println("");
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

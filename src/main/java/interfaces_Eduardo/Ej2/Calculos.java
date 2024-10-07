package interfaces_Eduardo.Ej2;

public class Calculos {
	
	// CALCULOS DE MEDIDAS
	public static double milimetroCentimetro(double numero) {
		return numero/10;
	}
	
	public static double milimetroMetro(double numero) {
		return numero/1000;
	}
	
	public static double milimetroKm(double numero) {
		return numero/1000000;
	}
	
	public static double centimetroMilimetro(double numero) {
		return numero*10;
	}
	
	public static double centimetroMetro(double numero) {
		return numero/100;
	}
	public static double centimetroKm(double numero) {
		return numero/100000;
	}
	
	
	
	//CALCULOS DE TEMPERATURAS
	
	
	public static double gradosToKelvin(double num1) {
		return num1+273.15;
		
	}
	
	public static double gradosToFaren(double num1) {
		 return (num1 * 9.0 / 5.0) + 32.0;
		
	}
	
	public static double kelvinToGrados(double num1) {
		 return num1-273.15;
		
	}
	public static double kelvinToFaren(double num1) {
		 return (num1 - 273.15) * 9.0 / 5.0 + 32.0;
		
	}
	
	public static double farenToGrados(double num1) {
		return (num1 - 32) * 5.0 / 9.0;
		
	}
	
	public static double farenToKelvin(double num1) {
		 return (num1 - 32) * 5.0 / 9.0 + 273.15;
		
	}
}

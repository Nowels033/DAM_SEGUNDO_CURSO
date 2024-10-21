package prueba;

public class Persona {

	private String nombre;
	private int edad;
	private String traumas;
	private String vicios;
	private String miedos;
	private boolean sex;

	public Persona() {
		this.sex=false;

	}

	public Persona(String nombre) {
		this.nombre = nombre;
		this.sex=false;
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}

	private String getTraumas() {
		return traumas;
	}

	private void setTraumas(String traumas) {
		this.traumas = traumas;
	}

	private String getVicios() {
		return vicios;
	}

	private void setVicios(String vicios) {
		this.vicios = vicios;
	}

	private String getMiedos() {
		return miedos;
	}

	private void setMiedos(String miedos) {
		this.miedos = miedos;
	}

	private boolean isFollada() {
		return sex;
	}

	private void setFollada(boolean follada) {
		this.sex = follada;
	}

}

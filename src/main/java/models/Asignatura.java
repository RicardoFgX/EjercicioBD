package models;

public class Asignatura {
	private int id;
	private String nombre;
	private String clase;
	private String profesor_encargado;
	private int numero_alumnos;
	
	public Asignatura() {
		
	}
	
	public Asignatura(int id, String nombre, String clase, String profesor_encargado, int numero_alumnos) {
		this.id = id;
		this.nombre = nombre;
		this.clase = clase;
		this.profesor_encargado = profesor_encargado;
		this.numero_alumnos = numero_alumnos;
	}
	public Asignatura(String nombre, String clase, String profesor_encargado, int numero_alumnos) {
		this.nombre = nombre;
		this.clase = clase;
		this.profesor_encargado = profesor_encargado;
		this.numero_alumnos = numero_alumnos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getProfesor_encargado() {
		return profesor_encargado;
	}
	public void setProfesor_encargado(String profesor_encargado) {
		this.profesor_encargado = profesor_encargado;
	}
	public int getNumero_alumnos() {
		return numero_alumnos;
	}
	public void setNumero_alumnos(int numero_alumnos) {
		this.numero_alumnos = numero_alumnos;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", clase=" + clase + ", profesor_encargado="
				+ profesor_encargado + ", numero_alumnos=" + numero_alumnos + "]";
	}
	
	
	
}

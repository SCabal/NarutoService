package model;

public class Nodo {
	private Nodo siguiente;
	private Habilidad habilidad;
//Constructor	
	public Nodo(Habilidad habilidad) {
		this.siguiente = null;
		this.habilidad = habilidad;
	}
//Getters y Setters	
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Habilidad getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}
//Metodos
	
	
	
}

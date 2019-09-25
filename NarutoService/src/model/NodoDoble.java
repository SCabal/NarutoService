package model;

public class NodoDoble {
//Atributos	
	private NodoDoble siguiente;
	private NodoDoble anterior;
	private Personaje personaje;
//Constructor	
	public NodoDoble(Personaje personaje) {
		this.personaje = personaje;
		this.siguiente = null;
		this.anterior = null;
	}
//Getters y Setters
	public NodoDoble getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDoble getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
}

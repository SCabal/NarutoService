package model;

import exceptions.ExceptionNoEncontrada;

public class Clan {
//Atributos
	private String nombre;
	private NodoDoble principalito;
//Constructor	
	public Clan(String nombre) {
		this.nombre = nombre;
		this.principalito = null;
	}
//Getters y Setters	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public NodoDoble getPrincipalito() {
		return principalito;
	}
	public void setPrincipalito(NodoDoble principalito) {
		this.principalito = principalito;
	}
//Metodos
	public void sortPersonajesInsercion() {
		NodoDoble actual= principalito.getSiguiente();
		NodoDoble tmp = null;
		
		while(actual != null) {
			NodoDoble aux = actual;
			tmp = actual.getAnterior();
			while(tmp != null && actual.getPersonaje().compare(actual.getPersonaje(), tmp.getPersonaje())<0) {
				actual.setPersonaje(tmp.getPersonaje());;
				actual = actual.getAnterior();
				tmp = actual.getAnterior();
			}
			actual.setPersonaje(aux.getPersonaje());
			actual = actual.getSiguiente();
		}
		
	}
	public void agregarPersonaje(Personaje p) {
		if(principalito == null) {
			principalito = new NodoDoble(p);
		}else {
			NodoDoble actual = principalito;
			boolean flag = false;
			Personaje tmp = null;
			NodoDoble temporal = null;
			while((actual.getSiguiente()!= null) && (!flag)) {
				if(actual.getPersonaje().compare(p, tmp)>= 0) {
					tmp = actual.getPersonaje();
					actual.setPersonaje(p);
					NodoDoble nuevo = new NodoDoble(tmp);
					if(actual.getSiguiente() != null) {
						temporal = actual.getSiguiente();
						nuevo.setSiguiente(temporal);
						actual.setSiguiente(nuevo);
					}else {
						actual.setSiguiente(nuevo);
					}
				}
				
			}
		}
	
	}
	public void eliminarPersonaje(Personaje p) throws ExceptionNoEncontrada {
		NodoDoble anterior = null;
		NodoDoble actual = principalito;
		Personaje per = actual.getPersonaje();
		while(per.getNombre() != p.getNombre() && per.getPoder() != p.getPoder() && actual != null) {
			anterior = actual;
			actual = actual.getSiguiente();
			if(actual != null)
				per = actual.getPersonaje();
		}
		if(actual == null) {
			throw new ExceptionNoEncontrada("El Personaje");
		}else if(anterior == null) {
			setPrincipalito(actual.getSiguiente());
		}else {
			anterior.setSiguiente(actual.getSiguiente());
		}
	}
}

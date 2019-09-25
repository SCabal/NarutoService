package model;

import java.util.Comparator;

import exceptions.ExceptionNoEncontrada;

public class Personaje implements Comparator<Personaje> {
//Atributos		
		private String nombre;
		private double poder;
		private String personalidad;
		private Nodo principal;
		private int dia;
		private int mes;
		private int anio;
//Constructor		
		public Personaje(String nombre, String personalidad, int dia, int mes, int anio) {
			super();
			this.nombre = nombre;
			this.poder = 1;
			this.personalidad = personalidad;
			this.dia = dia;
			this.mes = mes;
			this.anio = anio;
			this.principal = null;
		}
//Getters y Setters		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public double getPoder() {
			return poder;
		}
		public void setPoder(double poder) {
			this.poder = poder;
		}
		public String getPersonalidad() {
			return personalidad;
		}
		public void setPersonalidad(String personalidad) {
			this.personalidad = personalidad;
		}
		public Nodo getPrincipal() {
			return principal;
		}
		public void setPrincipal(Nodo principaln) {
			principal = principaln;
		}
		
		public int getDia() {
			return dia;
		}
		public void setDia(int dia) {
			this.dia = dia;
		}
		public int getMes() {
			return mes;
		}
		public void setMes(int mes) {
			this.mes = mes;
		}
		public int getAnio() {
			return anio;
		}
		public void setAnio(int anio) {
			this.anio = anio;
		}
		//Metodos
		public void agregarHabilidad(Habilidad h) {
			if(principal == null) {
				principal = new Nodo(h);
			}else {
				Nodo actual = principal;
				boolean flag = false;
				Habilidad tmp = null;
				Nodo temporal = null;
				while((actual.getSiguiente()!= null) && (!flag)) {
					if(actual.getHabilidad().compareTo(h)>= 0) {
						tmp = actual.getHabilidad();
						actual.setHabilidad(h);
						Nodo nuevo = new Nodo(tmp);
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
			calcularPoder();
		}
		
		public void eliminarHabilidad(Habilidad h) throws ExceptionNoEncontrada {
			Nodo anterior = null;
			Nodo actual = principal;
			Habilidad hab = actual.getHabilidad();
			while(hab.getNombre() != h.getNombre() && hab.getFactor() != h.getFactor() && actual != null) {
				anterior = actual;
				actual = actual.getSiguiente();
				if(actual != null)
					hab = actual.getHabilidad();
			}
			if(actual == null) {
				throw new ExceptionNoEncontrada("La habilidad");
			}else if(anterior == null) {
				setPrincipal(actual.getSiguiente());
			}else {
				anterior.setSiguiente(actual.getSiguiente());
			}
			calcularPoder();
		}
		
		private void calcularPoder() {
			Nodo actual = principal;
			this.poder = 1;
			while(actual!=null) {
				this.poder *= actual.getHabilidad().getFactor();
				actual = actual.getSiguiente();
			}
		}
		@Override
		public int compare(Personaje o1, Personaje o2) {
			int respuesta = 0;
			if ((o1.getNombre().compareTo(o2.getNombre())>0)) {
				respuesta = -1;
			}
			if (o1.getNombre().compareTo(o2.getNombre())<0) {
				respuesta = 1;
			}
			return respuesta;
		}
		
		
		
}

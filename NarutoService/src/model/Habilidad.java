package model;

public class Habilidad implements Comparable<Habilidad>{
//atributos
	private String nombre;
	private int factor;
//constructor	
	public Habilidad(String nombre, int factor) {
		super();
		this.nombre = nombre;
		this.factor = factor;
	}
//Getters y Setters	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}
//Metodos	
	@Override
	public int compareTo(Habilidad h) {
		if(h.getFactor()>this.factor) {
			return -1;
		}else if(h.getFactor()<this.factor) {
			return 1;
		}
		
		return 0;
	}

}

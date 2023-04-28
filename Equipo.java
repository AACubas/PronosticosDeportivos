package Integrador2.pronosticosPorRonda;


public class Equipo {
	private String nombre;
	private ResEnum result;
	public Equipo() {
		
	}
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ResEnum getResult() {
		return result;
	}
	public void setResult(ResEnum result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	public boolean equals(String nombre) {
		if(this.nombre.equalsIgnoreCase(nombre))
			return true;
		return false;
	}

}

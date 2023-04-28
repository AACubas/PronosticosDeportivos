package Integrador2.pronosticosPorRonda;



public class Pronostico {
	String apostador;
	Partido partido;
	Equipo equipo;
	int puntos = 1;
	ResEnum res;
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getPuntosBase() {
		return this.puntos;
	}
	public ResEnum getRes() {return res;}
	public void setRes(ResEnum res) {this.res = res;}
	public Partido getPartido() {return partido;}
	public void setPartido(Partido partido) {this.partido = partido;}
	public Equipo getEquipo() {return equipo;}
	public void setEquipo(Equipo equipo) {this.equipo = equipo;}

	@Override
	public String toString() {
		return "Pronostico [equipo=" + equipo + ", res=" + res + "]";
	}	
}

package Integrador2.pronosticosPorRonda;

import java.util.ArrayList;

public class Ronda {
	private String nroRonda;
	ArrayList<Partido> partidos= new ArrayList<>();
	public Ronda() {}
	public Ronda(String nroRonda) {
		this.nroRonda = nroRonda;
	}
	public String getNumeroDeRonda() {
		return nroRonda;
	}
	public void setNumGrupo(String numGrupo) {
		this.nroRonda = numGrupo;
	}
	public void addPartido(Partido partido) {
		this.partidos.add(partido);
	}
	public Partido getPartido(int i) {
		return this.partidos.get(i);
	}
	public int getCantPArtidos() {
		return this.partidos.size();
	}
	 public ArrayList<Partido> getPartidos() {
	        return this.partidos;
	    }
	
}

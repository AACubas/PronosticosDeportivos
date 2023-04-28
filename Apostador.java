package Integrador2.pronosticosPorRonda;

import java.util.ArrayList;

public class Apostador {
	private String nombre;
	private ArrayList<Pronostico> pron = new ArrayList<>();
	private int puntos= 0;
	public int getPuntos() {return puntos;}
	public void sumarPuntos(int puntos) {this.puntos += puntos;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void agregarPron(Pronostico pron) {this.pron.add(pron);}
	public Pronostico getPron(int i) {return this.pron.get(i);}
	public ArrayList<Pronostico> getPronosticos() {
		return this.pron;
	}
	public int cantidadPronosticos() {return pron.size();}
	
}

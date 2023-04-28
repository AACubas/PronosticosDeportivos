package Integrador2.pronosticosPorRonda;


public class Partido {
	private Equipo equipoUno;
	private Equipo equipoDos;
	private int golesEquipoUno;
	private int golesEquipoDos;
	private Equipo equipo;
	private ResEnum res;
	public Partido() {
		
	}
	public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2) {
			this.equipoUno = equipo1;
			this.equipoDos = equipo2;
			this.golesEquipoUno = goles1;
			this.golesEquipoDos = goles2;
	}
	void resultado() {
		if (golesEquipoUno == golesEquipoDos) {
			equipoUno.setResult(ResEnum.EMPATE);
			equipoDos.setResult(ResEnum.EMPATE);
			equipo=equipoUno;
			res = ResEnum.EMPATE;
		} else if (golesEquipoUno > golesEquipoDos) {
			equipoUno.setResult(ResEnum.GANADOR);
			equipoDos.setResult(ResEnum.PERDEDOR);
			equipo=equipoUno;
			res = ResEnum.GANADOR;
		} else {
			equipoUno.setResult(ResEnum.PERDEDOR);
			equipoDos.setResult(ResEnum.GANADOR);
			equipo=equipoDos;
			res = ResEnum.GANADOR;
		}
	}
	public Equipo getEquipo() {return this.equipo;}
	public ResEnum getResultado() {return this.res;}
	public int getGolesEquipoUno() {return golesEquipoUno;}
	public void setGoles1(int goles1) {this.golesEquipoUno = goles1;}
	public int getGolesEquipoDos() {return golesEquipoDos;}
	public void setGoles2(int goles2) {this.golesEquipoDos = goles2;}
	public Equipo getEquipoUno() {return equipoUno;}
	public void setEquipo1(Equipo equipo) {this.equipoUno = equipo;}
	public Equipo getEquipoDos() {return equipoDos;}
	public void setEquipo2(Equipo equipo) {this.equipoDos = equipo;}

	@Override
	public String toString() {
		return equipoUno + " vs " + equipoDos;
	}
}

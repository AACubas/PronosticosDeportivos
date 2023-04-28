package Integrador2.pronosticosPorRonda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String resultados = System.getProperty("user.dir") + "/Partidos y apuestas/Resultados.txt";
		String pronosticos = System.getProperty("user.dir") + "/Partidos y apuestas/Pronosticos.txt";
		//Pruebo usando Array y ArrayList
		ArrayList<Ronda> rondas = new ArrayList<>();
		Apostador[] apostadores = new Apostador[3];
		for (int i = 0; i < apostadores.length; i++) {
			apostadores[i] = new Apostador();
		}
		try {
			//Leo el Archivo Resultados.txt y guardo los valores rondas 
			Scanner entrada = new Scanner(new File(resultados));
			while (entrada.hasNextLine()) {
				String line = entrada.nextLine();
				String[] parts = line.split("\t");
				String numeroDeRonda = parts[0];
				String nombreEquipoUno = parts[1];
				int golesEquipoUno = Integer.parseInt(parts[2]);
				int golesEquipoDos = Integer.parseInt(parts[3]);
				String nombreEquipoDos = parts[4];
				Equipo equipoUno = new Equipo(nombreEquipoUno);
				Equipo equipoDos = new Equipo(nombreEquipoDos);
				Partido partido = new Partido(equipoUno, equipoDos, golesEquipoUno, golesEquipoDos);
				partido.resultado();
				Ronda ronda = null;
				for (Ronda r : rondas) {
					if (r.getNumeroDeRonda().equals(numeroDeRonda)) {
						ronda = r;
						break;
					}
				}
				if (ronda == null) {
					ronda = new Ronda(numeroDeRonda);
					rondas.add(ronda);
				}
				ronda.addPartido(partido);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo resultados no encontrado");
			return;
		}

		try {
			//Leo el archivo Pronosticos.txt y guardo los valores en apostadores
			boolean primeravez = true;
			Scanner entrada = new Scanner(new File(pronosticos));
			int i = 0;
			while (entrada.hasNextLine()) {
				Equipo equipo1 = new Equipo();
				Equipo equipo2 = new Equipo();
				Partido partido = new Partido();
				Pronostico pron = new Pronostico();
				String[] campos = entrada.nextLine().split("\t");
				if (primeravez || apostadores[i].getNombre().equalsIgnoreCase(campos[0])) {
					apostadores[i].setNombre(campos[0]);
					primeravez = false;
				} else {
					i++;
					apostadores[i].setNombre(campos[0]);
				}
				equipo1.setNombre(campos[1]);
				if (campos[2].equalsIgnoreCase("X")) {
					equipo1.setResult(ResEnum.GANADOR);
					equipo2.setResult(ResEnum.PERDEDOR);
					pron.setEquipo(equipo1);
					pron.setRes(equipo1.getResult());
				} else if (campos[3].equalsIgnoreCase("X")) {
					equipo1.setResult(ResEnum.EMPATE);
					equipo2.setResult(ResEnum.EMPATE);
					pron.setEquipo(equipo1);
					pron.setRes(equipo1.getResult());
				} else {
					equipo2.setResult(ResEnum.GANADOR);
					equipo1.setResult(ResEnum.PERDEDOR);
					pron.setEquipo(equipo2);
					pron.setRes(equipo2.getResult());
				}
				equipo2.setNombre(campos[5]);
				partido.setEquipo1(equipo1);
				partido.setEquipo2(equipo2);
				pron.setPartido(partido);
				apostadores[i].agregarPron(pron);
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo resultados no encontrado");
			return;
		}
		//Comparo los valores de ronda con los pronosticos y le asigno los puntos correspondientes al jugador
		for (Ronda ronda : rondas) {
		    for (Partido partido : ronda.getPartidos()) {
		        for (Apostador apostador : apostadores) {
		            for (Pronostico pronostico : apostador.getPronosticos()) {
		            	if (pronostico.getPartido().getEquipoUno().getNombre().equals(partido.getEquipoUno().getNombre()) && 
		            		    pronostico.getPartido().getEquipoDos().getNombre().equals(partido.getEquipoDos().getNombre()) && 
		            		    pronostico.getRes().equals(partido.getResultado())) {
		            		        apostador.sumarPuntos(pronostico.getPuntosBase());
		            		}
		               
		            }
		        }
		    }
		}
		//Muestro cada apostador y cuantos puntos obtuvo
		for (Apostador apos : apostadores) {
			System.out.println(apos.getNombre() + " obtuvo " + apos.getPuntos() + " puntos. "+
		"Acertó "+apos.getPuntos()/1+ " pronosticos.");
		}
	}
}

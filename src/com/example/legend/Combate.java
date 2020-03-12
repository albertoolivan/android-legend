package com.example.legend;

public class Combate {

	private Jugador jugador1;
	private Jugador jugador2;
	
	// excepcionales
	private int total_dificultad_hiruma1 = 0;
	private int total_dificultad_hiruma2 = 0;
	private int hiruma = 0;
	private int iniciativa_bayusi1 = 0;
	private int iniciativa_bayusi2 = 0;
	private int iniciativa_kakita1 = 0;
	private int iniciativa_kakita2 = 0;
	
	private int numeroPruebas = 1000;
	
	public String resultado;
	
	// constructor
	public Combate (Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
		
	public void simuladorCombateCompleto() {
		
		
		int[] serie_ganador = new int[numeroPruebas];
		int[] serie_asaltos = new int[numeroPruebas];
		int[] res;
		
		for(int i=0;i<numeroPruebas;i++) {
			res = this.simulaCombate();
			serie_ganador[i] = res[0];
			serie_asaltos[i] = res[1];
		}
		
		int gana1 = 0;
		int gana2 = 0;
		//int empate = 0;
		for(int i=0;i<numeroPruebas;i++) {
			if (serie_ganador[i] == 1) gana1++;
			if (serie_ganador[i] == 2) gana2++;
			//if (serie_ganador[i] == 0) empate++;
		}
		
		float media_asaltos = Matematicas.calcula_media(serie_asaltos);
		
		gana1 = (int) (gana1*100) / numeroPruebas;
		gana2 = (int) (gana2*100) / numeroPruebas;
		
		resultado = "\nGana j1 "+gana1+"%";
		resultado += "\nGana j2 "+gana2+"%";
		resultado += "\nMedia asaltos: "+String.format("%.2f", media_asaltos);
		//resultado += "\nEmpate "+empate+"%";
	}
		
	// realiza una tirada
	public int[] simulaCombate () {
		// si gana el jugador 1 devuelve 1, si gana el jugador 2, devuelve 2
		// si es empate, devuelve 0
		int gana = 0;
		
		int ini1 = 0, ini2 = 0;
		int asalto = 0;
		
		int reducc = 0;
		
		// primero: INICIATIVA
		// se determina quien va primero en todo el combate, no puede haber empates
		while (ini1 == ini2) {
			ini1 = TiradaBase.simular(jugador1.getDadoTirarIni(), jugador1.getDadoGuardarIni());
			ini1 += jugador1.getBonusIni();
			
			ini2 = TiradaBase.simular(jugador2.getDadoTirarIni(), jugador2.getDadoGuardarIni());
			ini2 += jugador2.getBonusIni();
		}
		
		//System.out.println("Iniciativas: "+ini1+" "+ini2);
		
		// EXCEPCION: Bayusi rango >=1 que gane iniciativa, gana +5 dificultad
		if (ini1 > ini2 && jugador1.getEscuela().equals("Bayusi")) {
			jugador1.setDificultad(jugador1.getDificultad() +5);
			iniciativa_bayusi1 += 5;
		}
		if (ini2 > ini1 && jugador2.getEscuela().equals("Bayusi")) {
			jugador2.setDificultad(jugador2.getDificultad() +5);
			iniciativa_bayusi2 += 5;
		}
		
		// EXCEPCION: Kakita rango >=2 que gane iniciativa, gana 2g0 en Tirar
		if (ini1 > ini2 && jugador1.getEscuela().equals("Kakita") && jugador1.getRango() >= 2) {
			jugador1.setDadoTirarDar(jugador1.getDadoTirarDar()+2);
			iniciativa_kakita1 += 2;
		}
		if (ini2 > ini1 && jugador2.getEscuela().equals("Kakita") && jugador2.getRango() >= 2) {
			jugador2.setDadoTirarDar(jugador2.getDadoTirarDar()+2);
			iniciativa_kakita2 += 2;
		}
		
		// SEGUNDO
		// combate general, hasta que un jugador se queda sin vida
		// la iniciativa se mantiene
		while (jugador1.getVida() > 0 && jugador2.getVida() > 0) {
			
			asalto++;
			
			// EXCEPCIONES DEL PRIMER ASALTO
			if (asalto == 1) {
				// akodo gana un dado primer asalto en combate
				if (jugador1.getEscuela().equals("Akodo")) {
					jugador1.setDadoTirarDar(jugador1.getDadoTirarDar() +1);
				}
				if (jugador2.getEscuela().equals("Akodo")) {
					jugador2.setDadoTirarDar(jugador2.getDadoTirarDar() +1);
				}
				
				// armas de lanza quitan reductor
				if (jugador1.getArma() >80 && jugador1.getArma() <80) {
					reducc = jugador2.getReduccion();
					if (jugador2.getReduccion() < 3) {
						jugador2.setReduccion(0);
					}
					if (jugador2.getReduccion() >= 3) {
						jugador2.setReduccion(jugador2.getReduccion() -3);
					}
				}
				if (jugador2.getArma() >80 && jugador2.getArma() <80) {
					reducc = jugador1.getReduccion();
					if (jugador1.getReduccion() < 3) {
						jugador1.setReduccion(0);
					}
					if (jugador1.getReduccion() >= 3) {
						jugador1.setReduccion(jugador1.getReduccion() -3);
					}
				}
			} 
			
			if (asalto == 2) {
				// se lo resto al akodo
				if (jugador1.getEscuela().equals("Akodo")) {
					jugador1.setDadoTirarDar(jugador1.getDadoTirarDar() -1);
				}
				if (jugador2.getEscuela().equals("Akodo")) {
					jugador2.setDadoTirarDar(jugador2.getDadoTirarDar() -1);
				}
				
				// armas de lanza quitan reductor
				if (jugador1.getArma() > 80 && jugador1.getArma() < 80) {
					jugador2.setReduccion(jugador2.getReduccion() + reducc);
				}
				if (jugador2.getArma() > 80 && jugador2.getArma() < 80) {
					jugador1.setReduccion(jugador1.getReduccion() + reducc);
				}
			}
			
			
			
			// jugador1 primero
			if (ini1 > ini2) {
				ataqueJugador1(1, jugador1, jugador2);
				if (jugador1.getNum_ataques() == 2) {ataqueJugador1(2, jugador1, jugador2);}
				ataqueJugador2(1, jugador1, jugador2);
				if (jugador2.getNum_ataques() == 2) {ataqueJugador2(2, jugador1, jugador2);}
			}
			if (ini2 > ini1) {
				ataqueJugador2(1, jugador1, jugador2);
				if (jugador2.getNum_ataques() == 2) {ataqueJugador2(2, jugador1, jugador2);}
				ataqueJugador1(1, jugador1, jugador2);
				if (jugador1.getNum_ataques() == 2) {ataqueJugador1(2, jugador1, jugador2);}
			}
			
			//System.out.println("Vida 1: "+jugador1.getVida()+" 2: "+jugador2.getVida());
			
				
		} // fin while, alguien ha muerto
		
		
		// TERCERO
		// se determina quien gana
		if (jugador1.getVida() > 0 && jugador2.getVida() <= 0) {
			gana = 1;
		}
		if (jugador2.getVida() > 0 && jugador1.getVida() <= 0) {
			gana = 2;
		}
		if (jugador2.getVida() <= 0 && jugador1.getVida() <= 0) {
			gana = 0;
		}
		
		//System.out.println("Gana: "+gana);
		
		int[] resumen = new int[2];
		resumen[0] = gana;
		resumen[1] = asalto;
		
		// reseteo las variables de cada combate y la vida de los jugadores
		resetCombate();
		
	
		return resumen;
	}
	
	// reseteo las variables de cada combate y la vida de los jugadores
	private void resetCombate () {
		
		jugador1.reset();
		jugador2.reset();
		
		// reseteo las excepciones Hiruma / kakita / bayusi
		hiruma = 0;
		jugador1.setDificultad(jugador1.getDificultad() - total_dificultad_hiruma1);
		total_dificultad_hiruma1 = 0;
		jugador2.setDificultad(jugador2.getDificultad() - total_dificultad_hiruma2);
		total_dificultad_hiruma2 = 0;
		
		jugador1.setDificultad(jugador1.getDificultad() - iniciativa_bayusi1);
		iniciativa_bayusi1 = 0;
		jugador2.setDificultad(jugador2.getDificultad() - iniciativa_bayusi2);
		iniciativa_bayusi2 = 0;
		
		jugador1.setDadoTirarDar(jugador1.getDadoTirarDar() - iniciativa_kakita1);
		iniciativa_kakita1 = 0;
		jugador2.setDadoTirarDar(jugador2.getDadoTirarDar() - iniciativa_kakita2);
		iniciativa_kakita2 = 0;
	}
	
	
	// el jugador1 ataca al jugador2
	private void ataqueJugador1(int ataque, Jugador jugador1, Jugador jugador2) {
		
		int dar, damage;
		
		// ataca jugador1
		dar = TiradaBase.simular(jugador1.getDadoTirarDar(), jugador1.getDadoGuardarDar());
		dar -= jugador1.getPenalizador();
		dar += jugador1.getBonusDar();
		if (ataque == 1) {
			dar += jugador1.getBonusAtaque1();
		}
		
		if (dar >= jugador2.getDificultad()) {
			
			// EXCEPCION: la escuela Hiruma cuando golpea con exito gana +5 dificultad, maximo rango
			if (jugador1.getEscuela().equals("Hiruma") && jugador1.getRango() >= 2 && hiruma < jugador1.getRango()) {
				jugador1.setDificultad(jugador1.getDificultad() + 5);
				hiruma++;
				total_dificultad_hiruma1 += 5;
			}
			
			// daña el jugador 1
			damage = TiradaBase.simular(jugador1.getDadoTirarDamage(), jugador1.getDadoGuardarDamage());
			damage += jugador1.getBonusDamage();
			damage -= jugador2.getReduccion();
			jugador2.restaVida(damage);
		}
	}
	
	// el jugador2 ataca al jugador1
	private void ataqueJugador2(int ataque, Jugador jugador1, Jugador jugador2) {
		
		int dar, dam;
		
			
		// ataca jugador2
		dar = TiradaBase.simular(jugador2.getDadoTirarDar(), jugador2.getDadoGuardarDar());
		dar -= jugador2.getPenalizador();
		dar += jugador2.getBonusDar();
		if (ataque == 1) {
			dar += jugador2.getBonusAtaque1();
		}
		
		if (dar >= jugador1.getDificultad()) {
			
			// EXCEPCION: la escuela Hiruma cuando golpea con exito gana +5 dificultad, maximo rango
			if (jugador2.getEscuela().equals("Hiruma") && jugador2.getRango() >= 2 && hiruma < jugador2.getRango()) {
				jugador2.setDificultad(jugador2.getDificultad() + 5);
				hiruma++;
				total_dificultad_hiruma2 += 5;
			}
			
			// daña el jugador 2
			dam = TiradaBase.simular(jugador2.getDadoTirarDamage(), jugador2.getDadoGuardarDamage());
			dam += jugador2.getBonusDamage();
			dam -= jugador1.getReduccion();
			jugador1.restaVida(dam);
		}
	}
		
}

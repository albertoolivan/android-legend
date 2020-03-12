package com.example.legend;


public class Jugador implements  java.io.Serializable ,  Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int dadoTirarIni = 0, dadoGuardarIni = 0, dadoTirarDar = 0, dadoGuardarDar = 0, dadoTirarDamage = 0, dadoGuardarDamage = 0;
	
	private int dificultad = 0, reduccion = 0, habilidadDar = 0,  vida = 0;
	
	private int rango = 0, agilidad = 0, fuerza = 0, tierra = 0, reflejos = 0;
	
	private int bonusDamage = 0, bonusDar = 0, bonusAtaque1 = 0, bonusIni = 0;
	
	// 0-> sin armadura | 1-> asigaru | 2-> ligera | 3-> pesada
	private int honor = 0, armadura = 0;	
			
	private String escuela = "";
		
	// se adapta cuando se pierde vida u otras causas
	private int penalizador = 0;
	
	private int num_ataques = 1;
		
	private boolean manos_de_tierra= false;
		
	// 1: abanico
		// 11: abanico guerra
	// 2: arma asta
		// 21: bisento
		// 22: nagamaki
		// 23: naginata
		// 24: sashumata
		// 25: sodegarami
	// 3: cadena
		// 31: kusarigama
		// 32: kyoketsu-shoge
		// 33: manrikigusari
	// 4: pesada
		// 41: dai-tsuchi
		// 42: masakari
		// 43: ono
		// 44: tebsubo
	// 5: baston
		// 51: bo / numchaku / shankau
		// 52: ho-machekansisha
		// 53: tonfa
	// 6: cuchillo
		// 61: aiguchi / tanto / jitte / shai
		// 62: kama
	// 7: espada
		// 71: cimitarra
		// 72: katana
		// 73: nodachi
		// 74: ninjato / parangu / wakizasi
	// 8: lanza
		// 81: kumaden
		// 82: maichon
		// 83: nague-yari
		// 84: yari
	private int arma = 0;
	private String resumen;
	private String arma_nombre, armadura_nombre;
	

	// constructor
	public Jugador () {
	}
	
	// constructor cloneable
	public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
	
	public void asigna_arma (Jugador enemigo) {
		
		switch (arma) {
		case 11: arma_nombre = "abanico guerra"; break;
		case 21: arma_nombre = "bisento"; break;
		case 22: arma_nombre = "nagamaki"; break;
		case 23: arma_nombre = "naginata"; break;
		case 24: arma_nombre = "sashumata"; break;
		case 25: arma_nombre = "sodegarami"; break;
		case 31: arma_nombre = "kusarigama"; break;
		case 32: arma_nombre = "kyoketsu-shoge"; break;
		case 33: arma_nombre = "manrikigusari"; break;
		case 41: arma_nombre = "dai-tsuchi"; break;
		case 42: arma_nombre = "masakari"; break;
		case 43: arma_nombre = "ono"; break;
		case 44: arma_nombre = "tebsubo"; break;
		case 51: arma_nombre = "bo / numchaku / shankau"; break;
		case 52: arma_nombre = "ho-machekansisha"; break;
		case 53: arma_nombre = "tonfa"; break;
		case 61: arma_nombre = "aiguchi / tanto / jitte / shai"; break;
		case 62: arma_nombre = "kama"; break;
		case 71: arma_nombre = "cimitarra"; break;
		case 72: arma_nombre = "katana"; break;
		case 73: arma_nombre = "nodachi"; break;
		case 74: arma_nombre = "ninjato / parangu / wakizasi"; break;
		case 81: arma_nombre = "kumaden"; break;
		case 82: arma_nombre = "maichon"; break;
		case 83: arma_nombre = "nague-yari"; break;
		case 84: arma_nombre = "yari"; break;
		case 91: arma_nombre = "desarmado"; break;
		}
		
		// primero se ponen los bonos de cada grupo de armas a habilidadDar (se neceita tener los atributos asigandos previamente
		// abanicos
		if (arma>0 && arma <20) {
			if (habilidadDar >= 5) {
				dificultad += 1;
			}
			if (habilidadDar >= 7) {
				dificultad += 2;
			}
		}
		// asta
		if (arma>20 && arma <30) {
			if (habilidadDar >= 3) {
				// +5 iniciativa primer asalto -> futurooo
			}
		}
		// cadena
		if (arma>30 && arma <40) {
			// solo presas
		}
		// pesadas
		if (arma>40 && arma <50) {
			if (habilidadDar >= 3) {
				if (enemigo.getReduccion() >= 2) {
					enemigo.setReduccion(enemigo.getReduccion()-2);
				}
				if (enemigo.getReduccion() == 1) {
					enemigo.setReduccion(enemigo.getReduccion()-1);
				}
			}
			// con rango 7 se rerolea con 9's, PASO
		}
		// bastones
		if (arma>50 && arma <60) {
			if (habilidadDar < 3) {
				if (enemigo.getArmadura() == 1) {
					enemigo.setDificultad(enemigo.getDificultad() +3);
				}
				if (enemigo.getArmadura() == 2) {
					enemigo.setDificultad(enemigo.getDificultad() +5);
				}
				if (enemigo.getArmadura() == 3) {
					enemigo.setDificultad(enemigo.getDificultad() +10);
				}
			} else {
				if (habilidadDar >= 7) {
					dadoTirarDar++;
				}
			}
		}
		// cuchillos
		if (arma>60 && arma <70) {
			// dos armas, no me sale de las pelotas
		}
		// espadas
		if (arma>70 && arma <80) {
			if (habilidadDar >= 3) {
				dadoTirarDar += 1;
			}
		}
		// lanzas
		if (arma>80 && arma <90) {
			if (habilidadDar >= 3) {
				// primer asalto ignoras 3 reduccion, mas adelante
			}
		}
		// desarmado
		if (arma>90 && arma <100) {
			if (habilidadDar >= 3) {
				dadoTirarDamage += 1;
			}
			if (habilidadDar >= 7) {
				dadoGuardarDamage += 1;
			}
		}
		
		
		
		// tirar 0
		// ono y desarmado. al no sumar no se pone
		
		// tirar 1 
		if (arma == 25 || arma == 33 || arma == 51 || arma == 61 || arma == 81 || arma == 83 ) {
			dadoTirarDamage += 1;
		}
		// tirar 2
		if (arma == 22 || arma == 42 || arma == 71 || arma == 71 || arma == 84) {
			dadoTirarDamage += 2;
		}
		// tirar 3
		if (arma == 21 || arma == 23 || arma == 44 || arma == 72 || arma == 73) {
			dadoTirarDamage += 3;
		}
		// tirar 5
		if (arma == 41) {
			dadoTirarDamage += 5;
		}
		
		// guardar 1 
		if (arma == 11 || arma == 25 || arma == 32 || arma == 33 || arma == 61 || arma == 81 || arma == 91) {
			dadoGuardarDamage += 1;
		}
		// guardar 2
		if (arma == 23 || arma == 24 || arma == 41 || arma == 51 || arma == 52 || arma == 72 || arma == 74 || arma == 83 || arma == 84) {
			dadoGuardarDamage += 2;
		}	
		// guardar 3
		if (arma == 21 || arma == 22 || arma == 42 || arma == 44 || arma == 53 || arma == 71 || arma == 73 || arma == 82) {
			dadoGuardarDamage += 3;
		}
		// guardar 4 
		if (arma == 43) {
			dadoGuardarDamage += 4;
		}
		
	}
	
	public void asigna_armadura (int armadura1) {
		if (armadura1 < 0 || armadura1 > 3) {
			armadura1 = 0;
		}
		
		armadura = armadura1;
		
		switch (armadura) {
			case 0:
				dificultad += 0;
				reduccion += 0;
				armadura_nombre = "Niguna";
				break;
			case 1:
				dificultad += 3;
				reduccion += 1;
				armadura_nombre = "Asigaru";
				break;
			case 2:
				dificultad += 5;
				reduccion += 3;
				armadura_nombre = "Ligera";
				break;
			case 3:
				dificultad += 10;
				reduccion += 5;
				bonusDar -= 5;
				armadura_nombre = "Pesada";
				break;
		}
	}
	
	public void restaVida(int dam) {
		vida = vida - dam;
		calcula_penalizador();
	}

	public void asignaAtributos () {
		dadoTirarIni += rango + reflejos;
		dadoGuardarIni += reflejos;
		
		dadoTirarDar += habilidadDar + agilidad;
		dadoGuardarDar += agilidad;
		
		dadoTirarDamage += fuerza;
		
		dificultad += 5 + 5*reflejos; // necesita asigaArmadura()
		
		vida = tierra*19;
	}
	
	// Akodo
	// Matsu
	// Hida
	// Hiruma
	// Bayusi
	// Mirumoto
	// Shiba
	// Kakita
	// Moto
	// Otaku
	public void asigna_escuela (Jugador enemigo) {
		
		// 1) LEON
		// Akodo
		if (escuela.equals("Akodo")) {
				if (rango >= 1) {
					if (enemigo.getArmadura() < 2) {
						bonusDar += 5;
					} else {
						//enemigo.asigna_armadura(0);
						if (enemigo.getArmadura() == 2) {
							enemigo.setDificultad(enemigo.getDificultad() - 5);
						}
						if (enemigo.getArmadura() == 3) {
							enemigo.setDificultad(enemigo.getDificultad() - 10);
						}
					}
					// falta el dado por primer asalto
					
				}
				if (rango >= 2) {
					bonusAtaque1 += honor;
				}
				if (rango >= 3) {
					num_ataques = 2;
				}
		}
		// Matsu
		if (escuela.equals("Matsu")) {
			if (rango >= 1) {
				dadoTirarDar += 2;
				dadoGuardarDar += 1;
				dificultad -= 10;
				bonusDamage += honor;
			}
			if (rango >= 2) {
				// no aplica, miedo
			}
			if (rango >= 3) {
				num_ataques = 2;
			}
			if (rango >= 4) {
				// aplicado en contador de penalizador
			}
		}
		
		// 2) CANGREJO
		// Hida
		if (escuela.equals("Hida")) {
			if (rango >= 1) {
				if (armadura == 3) {
					bonusDar += 5;
				}
				if (arma > 39 && arma < 50) {
					dadoTirarDar++;
				}
			}
			if (rango >= 2) {
				reduccion += tierra;
			}
			if (rango >= 3) {
				num_ataques = 2;
			}
		}
		
		// Hiruma
		if (escuela.equals("Hiruma")) {
			if (rango >= 1) {
				dadoTirarDar += 1;
			}
			if (rango >= 2) {
				// puesto el aumento de dificultad en combate.java
			}
			if (rango >= 3) {
				int bon = enemigo.getBonusAtaque1();
				bon -= (rango*2);
				enemigo.setBonusAtaque1(bon);
			}
			if (rango >= 4) {
				num_ataques = 2;
			}
		}
		
		// 3) ESCORPION
		// Bayusi
		if (escuela.equals("Bayusi")) {
			if (rango >= 1) {
				dadoTirarIni += 1;
				dadoGuardarIni += 1;
				// mejorada iniciativa en combate.java
			}
			if (rango >= 2) {
				// fintas, no aplica
			}
			if (rango >= 3) {
				//  no aplica
			}
			if (rango >= 4) {
				num_ataques = 2;
			}
		}
		
		// 4) DRAGON
		// Mirumoto
		if (escuela.equals("Mirumoto")) {
			if (rango >= 1) {
				dificultad += rango*2;
			}
			if (rango >= 2) {
				// no aplica
			}
			if (rango >= 3) {
				num_ataques = 2;
			}
		}
		
		// 5) FENIX
		// Shiba
		if (escuela.equals("Shiba")) {
			if (rango >= 1) {
				// no aplica
			}
			if (rango >= 2) {
				// no aplica
			}
			if (rango >= 3) {
				// no aplica
			}
			if (rango >= 4) {
				num_ataques = 2;
			}
		}
		
		// 6) GRULLA
		// Kakita
		if (escuela.equals("Kakita")) {
			if (rango >= 1) {
				bonusIni += 2*habilidadDar;
			}
			if (rango >= 2) {
				//cambiado en  Combate temas de iniciativa, igual que Bayusi
			}
			if (rango >= 3) {
				// solo duelos, no aplica
			}
			if (rango >= 4) {
				num_ataques = 2;
			}
		}
		
		// 7) UNICORNIO
		// Moto
		if (escuela.equals("Moto")) {
			if (rango >= 1) {
				dadoTirarDar += 1;
				// cimitarras ganan tipo 'samurai' ?
			}
			if (rango >= 2) {
				bonusDar += (int) enemigo.getPenalizador() / 2;
			}
			if (rango >= 3) {
				num_ataques = 2;
			}
			if (rango >= 4) {
				// no aplica
			}
			if (rango >= 5) {
				// no aplica, locura
			}
		}
		
		// Otaku
		if (escuela.equals("Otaku")) {
			if (rango >= 1) {
				bonusAtaque1 += honor;
			}
			if (rango >= 2) {
				dificultad += 5;
			}
			if (rango >= 3) {
				// num_ataques = 2; solo montada
			}
		}
		
		// Generico
		if (escuela.equals("Generico")) {
			// NADA
		}
		
	}
	
	
	// calcula el penalizados de heridas segun la tierra y la vida restante
	private void calcula_penalizador () {
				
		if (vida > tierra*2*7) {
			penalizador = 0;
		}
		if (vida > tierra*2*6) {
			penalizador = 3;
		}
		if (vida > tierra*2*5) {
			penalizador = 5;
		}
		if (vida > tierra*2*4) {
			penalizador = 10;
		}
		if (vida > tierra*2*3) {
			penalizador = 15;
		}
		if (vida > tierra*2*2) {
			penalizador = 20;
		}
		if (vida > tierra*2) {
			penalizador = 40;
		}
		if (vida <= tierra*2) {
			penalizador = 999;
		}
		
		// particularidad Ventaja
		if (manos_de_tierra && penalizador >= 3) {
			penalizador += 3;
		}
		
		// particularidad escuela Matsu
		if (escuela.equals("Matsu") && rango >= 4) {
			penalizador -= honor*2;
			if (penalizador < 0) {
				penalizador = 0;
			}
		}
						
	}
	
	
	// devuelve los valores iniciales
	public void reset() {
		vida = tierra*19;
		penalizador = 0;
	}
	
	
	////////////////////////////////////////////
	// Getters y Setters
	public int getDadoTirarIni() {
		return dadoTirarIni;
	}
	public void setDadoTirarIni(int dadoTirarIni) {
		this.dadoTirarIni = dadoTirarIni;
	}

	public int getDadoGuardarIni() {
		return dadoGuardarIni;
	}
	public void setDadoGuardarIni(int dadoGuardarIni) {
		this.dadoGuardarIni = dadoGuardarIni;
	}

	public int getDadoTirarDar() {
		return dadoTirarDar;
	}
	public void setDadoTirarDar(int dadoTirarDar) {
		this.dadoTirarDar = dadoTirarDar;
	}

	public int getDadoGuardarDar() {
		return dadoGuardarDar;
	}
	public void setDadoGuardarDar(int dadoGuardarDar) {
		this.dadoGuardarDar = dadoGuardarDar;
	}

	public int getDadoTirarDamage() {
		return dadoTirarDamage;
	}
	public void setDadoTirarDamage(int dadoTirarDam) {
		this.dadoTirarDamage = dadoTirarDam;
	}

	public int getDadoGuardarDamage() {
		return dadoGuardarDamage;
	}
	public void setDadoGuardarDamage(int dadoGuardarDam) {
		this.dadoGuardarDamage = dadoGuardarDam;
	}

	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	
	
	public int getTierra() {
		return tierra;
	}
	public void setTierra(int tierra1) {
		if (tierra1 < 0 || tierra1 > 5) {
			tierra1 = 2;
		}
		this.tierra = tierra1;
	}

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getPenalizador() {
		return penalizador;
	}
	public void setPenalizador(int penalizador) {
		this.penalizador = penalizador;
	}
	
	public int getBonusDamage() {
		return bonusDamage;
	}
	public void setBonusDam(int bonusDam) {
		this.bonusDamage = bonusDam;
	}
	
	public int getReduccion() {
		return reduccion;
	}

	public void setReduccion(int reduccion) {
		this.reduccion = reduccion;
	}
	

	public int getNum_ataques() {
		return num_ataques;
	}
	public void setNum_ataques(int num_ataques) {
		this.num_ataques = num_ataques;
	}


	public int getBonusDar() {
		return bonusDar;
	}
	public void setBonusDar(int bonusDar) {
		this.bonusDar = bonusDar;
	}
	
	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura1) {
		if (armadura1 < 0 || armadura1 > 3) {
			armadura1 = 0;
			System.out.println("#2.3 Alarma: Jugador armadura mal pasado");
		}
		this.armadura = armadura1;
	}
	
	public int getHonor() {
		return honor;
	}
	public void setHonor(int honor1) {
		if (honor1 < 0 || honor1 > 10) {
			honor1 = 3;
			System.out.println("#2.3 Alarma: Jugador honor mal pasado");
		}
		this.honor = honor1;
	}
	
	public int getBonusAtaque1() {
		return bonusAtaque1;
	}
	public void setBonusAtaque1(int bonusAtaque1) {
		this.bonusAtaque1 = bonusAtaque1;
	}
	
	public int getHabilidadDar() {
		return habilidadDar;
	}
	public void setHabilidadDar(int habilidadDar1) {
		if (habilidadDar1 < 0 || habilidadDar1 > 5) {
			habilidadDar1 = 2;
			System.out.println("#2.3 Alarma: Jugador habilidad mal pasado");
		}
		this.habilidadDar = habilidadDar1;
	}
	
	public int getBonusIni() {
		return bonusIni;
	}
	public void setBonusIni(int bonusIni) {
		this.bonusIni = bonusIni;
	}
	
	public int getAgilidad() {
		return agilidad;
	}
	public void setAgilidad(int agilidad1) {
		if (agilidad1 < 0 || agilidad1 > 5) {
			agilidad1 = 2;
			System.out.println("#2.7 Alarma: Jugador agilidad mal pasado");
		}
		this.agilidad = agilidad1;
	}

	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza1) {
		if (fuerza1 < 0 || fuerza1 > 5) {
			fuerza1 = 2;
			System.out.println("#2.6 Alarma: Jugador fuerza mal pasada");
		}
		this.fuerza = fuerza1;
	}


	public int getReflejos() {
		return reflejos;
	}
	public void setReflejos(int reflejos1) {
		if (reflejos1 < 0 || reflejos1 > 5) {
			reflejos1 = 2;
			System.out.println("#2.4 Alarma: Jugador reflejos mal pasado");
		}
		this.reflejos = reflejos1;
	}

	public int getArma() {
		return arma;
	}
	public void setArma(int arma1) {
		if (arma1 < 11 || arma1 > 90) {
			arma1 = 11;
			System.out.println("#2.2 Alarma: Jugador arma mal pasada");
		}
		this.arma = arma1;
	}

	public int getRango() {
		return rango;
	}
	public void setRango(int rango1) {
		if (rango1 < 0 || rango1 > 5) {
			rango1 = 11;
			System.out.println("#2.3 Alarma: Jugador rango mal pasado");
		}
		this.rango = rango1;
	}


	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}


	public boolean isManos_de_tierra() {
		return manos_de_tierra;
	}
	public void setManos_de_tierra(boolean manos_de_tierra) {
		this.manos_de_tierra = manos_de_tierra;
	}


	public void setBonusDamage(int bonusDamage) {
		this.bonusDamage = bonusDamage;
	}
	
	public String getResumen() {
		resumen = 
				"Escuela: "+escuela+
				"\nArma: "+arma_nombre+
				"\nFuerza: "+fuerza+" Agilidad: "+agilidad+
				"\nTierra: "+tierra+" Reflejos: "+reflejos+"" +
				"\nArmadura: "+armadura_nombre+" Rango: "+rango+
				"\nHabilidad: "+habilidadDar+" Honor:"+honor+
				"\nReducc: "+reduccion+" dificultad: "+dificultad+
				"\nbonusDam: "+bonusDamage+" bonusAtaq1:"+bonusAtaque1+
				"\nIni: "+dadoTirarIni+"g"+dadoGuardarIni+" Dar: "+dadoTirarDar+"g"+dadoGuardarDar+" Dam: "+dadoTirarDamage+"g"+dadoGuardarDamage;
		
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	public String getArma_nombre() {
		return arma_nombre;
	}
	public void setArma_nombre(String arma_nombre) {
		this.arma_nombre = arma_nombre;
	}
	public String getArmadura_nombre() {
		return armadura_nombre;
	}
	public void setArmadura_nombre(String armadura_nombre) {
		this.armadura_nombre = armadura_nombre;
	}
}

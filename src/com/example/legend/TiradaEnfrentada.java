package com.example.legend;

public class TiradaEnfrentada {
	
	public String resultado;
	
	private int numeroPruebas = 1000;
	
	private float media1;
	private float media2;
	
	private float covarianza;
	private float correlacion;
	
	// getters
	public float getMedia1() {
		return media1;
	}
	// getters
	public float getMedia2() {
		return media2;
	}
	public float getCovarianza() {
		return covarianza;
	}
	public float getCorrelacion() {
		return correlacion;
	}
	
	
	Tirada jugador1;
	Tirada jugador2;
	
	int[] serie = new int[numeroPruebas];
	
	public TiradaEnfrentada (int dadosTirar1, int dadosGuardar1, int dadosTirar2, int dadosGuardar2) {
		this.jugador1 = new Tirada(dadosTirar1, dadosGuardar1);
		this.jugador2 = new Tirada(dadosTirar2, dadosGuardar2);
	}
	
	// funcion principal
		public void simularEnfrentada () {
			
			jugador1.simularCompleto();
			jugador2.simularCompleto();
			
			int[] serie1 = jugador1.getSerie();
			int[] serie2 = jugador2.getSerie();
			
			covarianza = Matematicas.calcula_covarianza(serie1, serie2);
			correlacion = Matematicas.calcula_coeficiente_correlacion(serie1, serie2);
			
			float gana1=0;
			float gana2=0;
			float empate=0;
			
			for (int i=0; i<numeroPruebas;i++) {
			
				serie[i] = serie1[i] - serie2[i];
				if (serie[i] > 0) {
					gana1++;
				}
				if (serie[i] < 0) {
					gana2++;
				}
				if (serie[i] == 0) {
					empate++;
				}
				
				//System.out.println("i: "+i+"_ "+serie[i]+" 1:"+serie1[i]+" 2:"+serie2[i]);
				//System.out.println("gana "+gana1+" pierde "+gana2);
			}
			
			gana1 = (gana1 / numeroPruebas)*100;
			gana2 =(gana2 / numeroPruebas)*100;
			empate = (empate / numeroPruebas)*100;
			
			
			resultado = "Jug1 "+String.format("%.2f", gana1)+"%\n Jug2 "+String.format("%.2f", gana2)+"%\nEmpate "+String.format("%.2f", empate)+"%";
			//resultado += "\nCovar. "+String.format("%.2f", covarianza)+" \nCorrel. "+String.format("%.2f", correlacion);
		}
}

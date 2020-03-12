package com.example.legend;



public class Tirada {
	
	public String resultado;
	
	private int numeroPruebas = 1000;
	private int numeroPruebas_sesgo = 900;
	
	private int dadosTirar;
	private int dadosGuardar;
	
	private float media;
	private float moda;
	private float mediana;
	private float desviacion;
	private float rango1;
	private float rango2;
	
	
	private int[] serie = new int[numeroPruebas];
	
	private int[] serie2 = new int[numeroPruebas_sesgo];
	
	// getters
	public float getMedia() {
		return media;
	}
	public float getModa() {
		return moda;
	}
	public float getMediana() {
		return mediana;
	}
	public float getDesviacion() {
		return desviacion;
	}
	public float getRango1() {
		return rango1;
	}
	public float getRango2() {
		return rango2;
	}
	
	public int[] getSerie() {
		return serie;
	}
	public int[] getSerie2() {
		return serie2;
	}

	
	// constructor
	public Tirada (int dadosTirar1, int dadosGuardar1) {
		
		if (dadosTirar1 < 0 || dadosTirar1 > 10) {
			dadosTirar1 = 5;
		}
		if (dadosGuardar1 < 0 || dadosGuardar1 > 10) {
			dadosGuardar1 = 3;
		}
		
		this.dadosTirar = dadosTirar1;
		this.dadosGuardar = dadosGuardar1;
		
		// los dados guardados no pueden superar a los tirados
		if (this.dadosGuardar > this.dadosTirar) {
			this.dadosGuardar =  this.dadosTirar;
		}
		
		// obtengo la serie entera de tiradas con los parametros de tirar/guardar recibido
		for (int i=0; i<numeroPruebas; i++) {
			serie[i] = TiradaBase.simular (dadosTirar,dadosGuardar);
		}
	}
	
	
	// funcion principal
	public void simularCompleto () {
		
		int[] serie_copia = new int[numeroPruebas];
		
		// hago una copia de la serie original, ya que aqui la necesito ordenada pero en otros sitios no
		for (int i=0; i<numeroPruebas; i++) {
			serie_copia[i] = serie[i];
		}
		
		// elimino el 10% de los casos extremos
		serie2 = Matematicas.elimina_sesgo(serie_copia);
		
		// obtengo la media y otros valores estadisiticos
		media = Matematicas.calcula_media(serie2);
		moda = Matematicas.calcula_moda(serie2);
		mediana = serie2[numeroPruebas_sesgo/2];
		desviacion =  Matematicas.calcula_desviacion(serie2, 1);
		
		rango1 = media - desviacion;
		rango2 = media - 2*desviacion;
		
		resultado = "Media "+String.format("%.2f", media)+"\nModa: "+moda;
		resultado += "\nMediana "+mediana;
		resultado += "\nAl 16% "+String.format("%.2f", rango1)+"\nAl 2,5% "+String.format("%.2f", rango2);
	}
	
	
}

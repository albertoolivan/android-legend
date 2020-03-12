package com.example.legend;

import java.util.Arrays;

public class TiradaBase {

	// realiza una tirada
	public static int simular (int dadosTirar, int dadosGuardar) {
		
		if (dadosTirar < 0 || dadosTirar > 10) {
			dadosTirar = 1;
			System.out.println("#1.1 Alarma: TiradaBaseSimular revisar dados pasados");
		}
		if (dadosGuardar < 0 || dadosGuardar > 10) {
			dadosGuardar = 1;
			System.out.println("#1.2 Alarma: TiradaBaseSimular revisar dados pasados");
		}
		
		if (dadosTirar < dadosGuardar) {
			dadosTirar = dadosGuardar;
			System.out.println("#1.3 Alarma: TiradaBaseSimular revisar dados pasados");
		}
		
		int resultado = 0;
		int tirada = 0;
		
		int[] dados = new int[dadosTirar];
		
		for (int i=0; i<dadosTirar; i++) {
			dados[i]=0;
		}
		
		//Creo el vector de dados tirados
		for (int i=0; i<dadosTirar; i++) {
			tirada = Matematicas.getRandom(10);
			dados[i] += tirada;
			//System.out.println("\n && tirada "+tirada+" de i "+(i+1));
			while (tirada == 10){
				tirada =  Matematicas.getRandom(10);
				dados[i] += tirada;
				//System.out.println(" sale 10, tirada "+tirada);
			}
		}
		
		// ordeno ascendentemente
		Arrays.sort(dados);
		
		// recojo los ultimos dados que serán los mayores
		for (int i=0; i<dadosGuardar; i++) {
			resultado += dados[dadosTirar-i-1];
			//System.out.println("\n $$ COGE para resultado "+dados[i]);;
		}
		
		for (int i=0; i<dadosTirar; i++) {
			//System.out.println("\n %% dado "+(i+1)+" resultado "+dados[i]);
		}
			
		//System.out.println("\n FIN Resultado enviado "+resultado);
		
		return resultado;
	}
}

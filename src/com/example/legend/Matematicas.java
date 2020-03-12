package com.example.legend;

import java.util.Arrays;
import java.util.Random;

public class Matematicas {
	
	public static int[] elimina_sesgo(int[] result_array) {
	
		Arrays.sort(result_array);
		
		int n = result_array.length;
		double k2 = n * 0.05;
		
		int k = (int) k2;
		int[] serie = new int[n-k];
		
		int j=0;
		for(int i=0; i<n-k;i++) {
			if (i>k) {
				serie[j] = result_array[i];
				j++;
			}
		}
		
		return serie;
	}
	
	// es tecnicamente un dado de lo que le llegue
	public static int getRandom(int mod) {
		Random rand = new Random();
		return Math.abs(rand.nextInt()) % mod + 1;
	}
	
	// calcula la media aritmetica de un array[i][$key]
	public static float calcula_media (int[] result_array) {
		int n = result_array.length;
		if (n == 0) {
			return -1;
		}
		float media = 0;
		for(int i=0; i<n;i++) {
			media += result_array[i];
		}
		media = media /n;
		
		return media;
	}
	
	// calcula la media aritmetica de un array[i][$key]
		public static float calcula_moda (int[] result_array) {
			int n = result_array.length;
			if (n == 0) {
				return -1;
			}
			
			int moda = 0;
			
			Arrays.sort(result_array);
			
			int cont = 0;
			int cont_max = 0;
			int j = 0;
			for(int i=0; i<n-1;i++) {
				
				if (result_array[i] == result_array[i+1]) {
					cont++;
				} else {
					cont = 0;
				}
				if (cont > cont_max) {
					cont_max = cont;
					j = i;
				}
			}
			
			moda = result_array[j];
			
			return moda;
		}
	
	
	// calcula la varianza de un array[i][key], siendo la suma de los cuadrados/n - media
	// si es varianza  muestral, debera venir con muestra = 1, entonces $acum/$n, será con $n -1
	public static float calcula_varianza (int[] result_array, int muestra) {
		int n = result_array.length;
		
		if (n == 0) {
			return -1;
		}
		float varianza = 0;
		float acum = 0;
		float media = calcula_media(result_array);
		for (int i=0; i<n; i++) {
			acum += Math.pow(result_array[i]-media,2);
		}
		if (muestra == 1) {
			n--;
		}
		
		varianza = acum/n;
		return varianza;
	}

	// Recibe un Array de base de datos y devuelve la desviacion tipica del argumento recibido $key -> array[i][$key]
	// si es desviacion tipico muestral, debera venir con muestra = 1
	public static float calcula_desviacion (int[] result_array,int muestra) {
		float var = calcula_varianza(result_array,muestra);
		float std = (float) Math.sqrt(var);
		return std;
	}
	
	
	// calcula la covarianza de dos arrays, array[i][key]   (arrays de misma longitud)
	// es la multiplicacion de ambos numero/n - menos las medias
	public static float calcula_covarianza (int[] array1, int[] array2) {
		float mult = 0;
		float covarianza = 0;
		
		int n = array1.length; 
		if (n == 0) {
			//echo "<br><b>Error</b> al calcular la covarianza, no hay valores en la serie.";
			//this->errores[this->func][] = "Error al calcular la covarianza, no hay valores en la serie.";
			return -1;
		}
		
		// deben tener misma longitud
		if (array1.length != array2.length) { return -1; }
		
		float media1 = calcula_media(array1);
		float media2 = calcula_media(array2);
		
		for (int i=0; i<n; i++) {
			mult += array1[i] * array2[i];
		}
		covarianza = mult / n - media1 * media2;
		return covarianza;
	}

	// calculo el coeficiente de correlacion de dos array[i][key], usando covarianza y desviaciotn tipica
	public static float calcula_coeficiente_correlacion(int[] array1, int[] array2) {
		float correlacion = 0;
		float desv1 = calcula_desviacion (array1, 0);
		float desv2 = calcula_desviacion (array2, 0);
		float covarianza = calcula_covarianza (array1, array2);
		if (desv1*desv2 == 0) {
			return -1;
		}
		correlacion = covarianza / (desv1*desv2);
		return correlacion;
	}
	

}

package com.example.legend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CargaFicheros extends Activity {
	
	 //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listaFicheros=new ArrayList<String>();
     //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;
    
  //  public int numero_jugador = 1;

	// http://www.javaya.com.ar/androidya/detalleconcepto.php?codigo=143&inicio
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_jugadores);
        
        
        
        System.out.println("llega 1");

        // obtengo los ficheros internos de la aplicacion
      //  String[] archivos = fileList();
        // DE MOMENTO NO HAY FICHEROS
        
        String[] archivos = {"hida1", "akodo2", "bayusi3"};
        		
        ListView listViewJugadores = (ListView) findViewById(R.id.listaJugadores);

        listaFicheros = (ArrayList<String>) Arrays.asList(archivos); 
        
        
        System.out.println("llega 2");

        // This is the array adapter, it takes the context of the activity as a 
        // first parameter, the type of list view as a second parameter and your 
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.listado_jugadores,listaFicheros );

        listViewJugadores.setAdapter(arrayAdapter); 
        
        System.out.println("llega 3");
        
        

    }
    
   
/*

	protected String cargaFichero(String[] archivos, String nombreFichero) {
    	String datosJugador = "";
    	if (existeFichero(archivos, nombreFichero)) {
	        try {
	            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreFichero));
	            BufferedReader br = new BufferedReader(archivo);
	            String linea = br.readLine();
	           
	            while (linea != null) {
	            	datosJugador = datosJugador + linea + "\n";
	                linea = br.readLine();
	            }
	            br.close();
	            archivo.close();

	        } catch (IOException e) {
	        }
	    }
	    return datosJugador;
    }
    

   

    private boolean existeFichero(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }

    public void grabar(String nombreFichero, String datosFichero) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreFichero, Activity.MODE_PRIVATE));
            archivo.write(datosFichero);
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        
        finish();
    }
    
    */
    
}

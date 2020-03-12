package com.example.legend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CargaJugador extends Activity  {
	
	//Spinner jugador1;
	//Spinner jugador2;
	
	Button buttonJugador1;
	Button buttonJugador2;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.carga_jugadores);
	        
	        
	        
	        
	        /*
	        jugador1 = (Spinner) findViewById(R.id.spinnerJugador1);
		    ArrayAdapter<CharSequence> adapter_jugador1 = ArrayAdapter.createFromResource(this, R.array.lista_armas,R.layout.spinner_item);
		    jugador1.setAdapter(adapter_jugador1);
		    
		    jugador2 = (Spinner) findViewById(R.id.spinnerJugador2);
		    ArrayAdapter<CharSequence> adapter_jugador2 = ArrayAdapter.createFromResource(this, R.array.lista_armas,R.layout.spinner_item);
		    jugador2.setAdapter(adapter_jugador2);
		    */
	 }
	 
	 public void myClickHandlerJugador1(View target) {
		    // va al layout listado_ficheros
		 System.out.println("llega 0");
		    Intent i = new Intent(CargaJugador.this, CargaFicheros.class);
		    startActivity(i);
		 }
		 
		 public void myClickHandlerJugador2(View target) {
		    // va al layout listado_ficheros
		    Intent i = new Intent(CargaJugador.this, CargaFicheros.class);
		    startActivity(i);
		 }

}

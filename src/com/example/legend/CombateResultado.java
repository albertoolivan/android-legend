package com.example.legend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CombateResultado extends Activity {
	
	TextView result;
	
	Jugador jugador1;
	Jugador jugador2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.muestra_combate);
	    
	    result = (TextView) findViewById(R.id.textViewResultado);
	    
	    Intent i = getIntent();
	    Jugadores jugadores = (Jugadores) i.getSerializableExtra("jugadores");
	    
	    jugador1 = jugadores.jugador1;
	    jugador2 = jugadores.jugador2;
	    
	    jugador1.asigna_arma(jugador2);
	    jugador2.asigna_arma(jugador1);
	    
	    jugador1.asigna_escuela(jugador2);
	    jugador2.asigna_escuela(jugador1);
	    
	    Combate combate = new Combate (jugador1, jugador2);
	    
	    combate.simuladorCombateCompleto();
	    
	    String res = "Jugador1: \n"+jugador1.getResumen()+"\n\nJugador2: \n"+jugador2.getResumen();
	    
	    res += "\n\n"+combate.resultado;
	    
	    result.setText(res);
	    
	    
	}
	
	public void myClickHandlerCombate(View target) {
		 	
		Combate combate = new Combate (jugador1, jugador2);
		    
		combate.simuladorCombateCompleto();
		    
		String res = "Jugador1: \n"+jugador1.getResumen()+"\n\nJugador2: \n"+jugador2.getResumen();
		    
		res += "\n\n"+combate.resultado;
		    
		result.setText(res);
    }

}

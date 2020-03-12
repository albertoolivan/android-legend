package com.example.legend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCombate extends Activity {
	
	Button buttonSimular;
	Button buttonCargar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.menu_combate);
	    
	    buttonSimular = (Button) findViewById(R.id.buttonSimular);
	    buttonCargar = (Button) findViewById(R.id.buttonCargar);
	    
	}
	
	public void myClickHandlerIrSimular(View target) {
		// va al layout genera_jugador
	    Intent i = new Intent(MenuCombate.this, GeneraJugador.class);
	    startActivity(i);
	}
	
	public void myClickHandlerIrCargar(View target) {
		// va al layout genera_jugador
	    Intent i = new Intent(MenuCombate.this, CargaJugador.class);
	    startActivity(i);
	
	}

}

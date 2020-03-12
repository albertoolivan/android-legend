package com.example.legend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	
	Button buttonTirada;
	Button buttonCombate;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        
	        buttonTirada = (Button) findViewById(R.id.buttonTirar);
	        buttonCombate = (Button) findViewById(R.id.buttonCombate);
	        
	 }
	 
	 public void myClickHandlerIrTirada(View target) {
	    // va al layout genera_jugador
	    Intent i = new Intent(Main.this, TiradaPrincipal.class);
	    startActivity(i);
	 }
	 
	 public void myClickHandlerIrCombate(View target) {
	    // va al layout genera_jugador
	    Intent i = new Intent(Main.this, MenuCombate.class);
	    startActivity(i);
	 }
}

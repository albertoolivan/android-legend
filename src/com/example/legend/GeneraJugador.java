package com.example.legend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GeneraJugador extends Activity {
	
	public int numero_jugador = 1;
	
	Jugador jugador1;
	Jugador jugador2;
	
	Button buttonSiguiente;
	
	Spinner escuela;
	Spinner arma;
	Spinner armadura;
	
	EditText rango;
	EditText reflejos;
	EditText fuerza;
	EditText agilidad;
	EditText tierra;
	EditText honor;
	EditText habilidad;
	
	TextView escuela_;
	TextView arma_;
	TextView armadura_;
	TextView rango_;
	TextView reflejos_;
	TextView fuerza_;
	TextView agilidad_;
	TextView tierra_;
	TextView honor_;
	TextView habilidad_;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.genera_jugador);
	    
	    fuerza_ = (TextView) findViewById(R.id.textViewFuerza);
	    fuerza = (EditText) findViewById(R.id.editTextFuerza);
	    //fuerza.setText("2");
	    
	    agilidad_ = (TextView) findViewById(R.id.textViewAgilidad);
	    agilidad = (EditText) findViewById(R.id.editTextAgilidad);
	    //agilidad.setText("2");
	    
	    agilidad_ = (TextView) findViewById(R.id.textViewAgilidad);
	    reflejos = (EditText) findViewById(R.id.editTextReflejos);
	   // reflejos.setText("2");
	    
	    tierra_ = (TextView) findViewById(R.id.textViewTierra);
	    tierra = (EditText) findViewById(R.id.editTextTierra);
	   // tierra.setText("2");
	    
	    honor_ = (TextView) findViewById(R.id.textViewHonor);
	    honor = (EditText) findViewById(R.id.editTextHonor);
	   // honor.setText("3");
	    
	    
	    escuela_ = (TextView) findViewById(R.id.textViewEscuela);
	    escuela = (Spinner) findViewById(R.id.spinnerEscuela);
	    ArrayAdapter<CharSequence> adapter_escuela = ArrayAdapter.createFromResource(this, R.array.lista_escuelas,R.layout.spinner_item);
	    escuela.setAdapter(adapter_escuela);
	    
	    arma_ = (TextView) findViewById(R.id.textViewArma);
	    arma = (Spinner) findViewById(R.id.spinnerArma);
	    ArrayAdapter<CharSequence> adapter_arma = ArrayAdapter.createFromResource(this, R.array.lista_armas,R.layout.spinner_item);
	    arma.setAdapter(adapter_arma);
	    
	    armadura_ = (TextView) findViewById(R.id.textViewArmadura);
	    armadura = (Spinner) findViewById(R.id.spinnerArmadura);
	    ArrayAdapter<CharSequence> adapter_armadura = ArrayAdapter.createFromResource(this, R.array.lista_armaduras,R.layout.spinner_item);
		armadura.setAdapter(adapter_armadura);
	
		habilidad_ = (TextView) findViewById(R.id.textViewHabilidad);
		habilidad = (EditText) findViewById(R.id.editTextHabilidad);
		//habilidad.setText("3");
	    
		rango_ = (TextView) findViewById(R.id.textViewRango);
	    rango = (EditText) findViewById(R.id.editTextRango);
	   // rango.setText("1");
	    
	   
	    
	    
	    buttonSiguiente  = (Button) findViewById(R.id.buttonSiguiente);
	    
	}
	
	 public void myClickHandlerSiguiente(View target) {
    	// genera un jugador
		
		 if (numero_jugador == 1) {
			 // es el primer jugador, lo almacena y se vuelve a cargar
			 jugador1 = new Jugador();
			 
			 String escuela1 = escuela.getSelectedItem().toString();
			 
			 String arma1 = arma.getSelectedItem().toString();
			 int arma_1 =  Integer.parseInt(arma1.substring(0, 2));
			 
			 System.out.println(arma1+" "+arma1.substring(0, 2));
			 
			 String armadura1 = armadura.getSelectedItem().toString();
			 int armadura_1 =  Integer.parseInt(armadura1.substring(0, 1));
			 
			 System.out.println(armadura1+" "+armadura1.substring(0, 1));
			 
			 
			 jugador1.setArma(arma_1);
			 
			 jugador1.setAgilidad(Integer.parseInt(agilidad.getText().toString()));
			 jugador1.setTierra(Integer.parseInt(tierra.getText().toString()));
			 jugador1.setFuerza(Integer.parseInt(fuerza.getText().toString()));
			 jugador1.setReflejos(Integer.parseInt(reflejos.getText().toString()));
			 jugador1.setRango(Integer.parseInt(rango.getText().toString()));
			 jugador1.setHabilidadDar(Integer.parseInt(habilidad.getText().toString()));
			 jugador1.setHonor(Integer.parseInt(honor.getText().toString()));
			
			 jugador1.asignaAtributos();
			 
			 jugador1.asigna_armadura(armadura_1);
			 
			 jugador1.setEscuela(escuela1);
			 
			 buttonSiguiente.setText("Combate");
			 
			 numero_jugador = 2;
			 
		 } else {
			// es el segundo jugador, lo almancea e inicia el combate 
			 jugador2 = new Jugador();
			 
			 String escuela1 = escuela.getSelectedItem().toString();
			
			 String arma1 = arma.getSelectedItem().toString();
			 int arma_1 =  Integer.parseInt(arma1.substring(0, 2));
			 
			 String armadura1 = armadura.getSelectedItem().toString();
			 int armadura_1 =  Integer.parseInt(armadura1.substring(0, 1));
			 
			 
			 jugador2.setArma(arma_1);
			 
			 jugador2.setAgilidad(Integer.parseInt(agilidad.getText().toString()));
			 jugador2.setTierra(Integer.parseInt(tierra.getText().toString()));
			 jugador2.setFuerza(Integer.parseInt(fuerza.getText().toString()));
			 jugador2.setReflejos(Integer.parseInt(reflejos.getText().toString()));
			 jugador2.setRango(Integer.parseInt(rango.getText().toString()));
			 jugador2.setHabilidadDar(Integer.parseInt(habilidad.getText().toString()));
			 jugador2.setHonor(Integer.parseInt(honor.getText().toString()));
			
			 jugador2.asignaAtributos();
			 
			 jugador2.asigna_armadura(armadura_1);
			 
			 jugador2.setEscuela(escuela1);
			 
			 Jugadores jugadores = new Jugadores();
			 jugadores.jugador1 = jugador1;
			 jugadores.jugador2 = jugador2;
			 
			 
			 // inicia la siguiente pantalla, enviado los dos jugadores
			 Intent i = new Intent(GeneraJugador.this, CombateResultado.class);
			 i.putExtra("jugadores", jugadores);
	         startActivity(i);
			 
		 }
		
    }
	 
	
}

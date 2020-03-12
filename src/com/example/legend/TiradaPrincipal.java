package com.example.legend;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TiradaPrincipal extends Activity {
	
	Button buttonLanzar;
	Button buttonEnfrentada;
	
	 
	TextView result;
	
	EditText tirar1;
	EditText guardar1;
	EditText tirar2;
	EditText guardar2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiradas);
        
        
        buttonLanzar = (Button) findViewById(R.id.buttonLanzar);
        buttonEnfrentada = (Button) findViewById(R.id.buttonEnfrentada);
        
        tirar1 = (EditText) findViewById(R.id.editTextTirar1);
        tirar1.setText("5");
        
        guardar1 = (EditText) findViewById(R.id.editTextGuardar1);
        guardar1.setText("3");
        
        tirar2 = (EditText) findViewById(R.id.editTextTirar2);
        tirar2.setText("4");
        
        guardar2 = (EditText) findViewById(R.id.editTextGuardar2);
        guardar2.setText("2");
        
        
        result = (TextView) findViewById(R.id.textViewResultado);
        
        result.setText("Pulsa un boton");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
     
    
    public void onClickLimpia(View target) {
    	 //result.setText("");
    }
    
    public void myClickHandlerLanzar(View target) {
    	
    	Tirada t = new Tirada (Integer.parseInt(tirar1.getText().toString()),Integer.parseInt(guardar1.getText().toString()));
        
        t.simularCompleto();
        
        result.setText(t.resultado);
    }
    
    
    
    public void myClickHandlerLanzarEnfrentada(View target) {
    	TiradaEnfrentada te = new TiradaEnfrentada (Integer.parseInt(tirar1.getText().toString()),Integer.parseInt(guardar1.getText().toString()), 
    			Integer.parseInt(tirar2.getText().toString()),Integer.parseInt(guardar2.getText().toString()));
        
        te.simularEnfrentada();
        
        result.setText(te.resultado);
    }
    
    
}

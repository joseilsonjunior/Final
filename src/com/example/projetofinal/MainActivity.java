package com.example.projetofinal;

import ifpb.edu.br.projetofinal.asynctask.BuscarNomeAsyncTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	 Button botaobuscarnome = (Button) findViewById(R.id.buscar_nome);

	 botaobuscarnome.setOnClickListener(new View.OnClickListener() {
	    
	                @Override
	                public void onClick(View v) {
	    
	                    Intent intent = new Intent();
	                    intent.setClass(MainActivity.this,
	                            BuscarNomeAsyncTask.class);
	    
	                    startActivity(intent);
	    
	                    finish();
	                }
	            });
  }
}


package com.example.projetofinal;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.projetofinal.asynctask.BuscarNomeAsyncTask;
import ifpb.edu.br.projetofinal.callback.*;
import ifpb.edu.br.projetofinal.entidades.Convidado;


public class BuscarPorNomeActivity extends Activity implements TextWatcher, ProcurarPessoaCallBack{

    private EditText nomeEditText;

    List<Convidado> convidado;

    
	private static int TAMANHO_MINIMO_TEXTO = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar_por_nome);
		nomeEditText = (EditText) findViewById(R.id.editText1);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.listView1);
        convidado = new ArrayList<Convidado>();



	}



	@Override
	public void afterTextChanged(Editable s) {

		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		 Log.i("AtidadeListView", "beforeTextChanged" + s);

		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		Log.i("AtidadeListView", "onTextChanged" + s);

        String nome = s.toString();

            if(nome.length() >= TAMANHO_MINIMO_TEXTO){


                Convidado convidado = new Convidado();
               convidado.setNome(nome);

                BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(this);
                buscarNomeAsyncTask.execute(convidado);

            }else{

                this.convidado.clear();

            }



		
	}

    public void backBuscarNome(List<Convidado> convidado) {

        this.convidado.clear();
        this.convidado.addAll(convidado);

    }


    public void errorBuscarNome(String error) {

        convidado.clear();

        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }
}


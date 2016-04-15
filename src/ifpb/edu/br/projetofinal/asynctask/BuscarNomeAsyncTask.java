package ifpb.edu.br.projetofinal.asynctask;

import ifpb.edu.br.projetofinal.callback.ProcurarPessoaCallBack;
import ifpb.edu.br.projetofinal.entidades.Convidado;
import ifpb.edu.br.util.HttpService;
import ifpb.edu.br.util.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.util.Log;

public class BuscarNomeAsyncTask extends AsyncTask<Convidado, Void, Response>{

	private ProcurarPessoaCallBack procurarPessoaCallBack;

    public BuscarNomeAsyncTask(ProcurarPessoaCallBack procurarPessoaCallBack) {

        this.procurarPessoaCallBack = procurarPessoaCallBack;
    }

    @Override
    protected Response doInBackground(Convidado... convidado) {

        Response response = null;

        Convidado Convidado = convidado[0];

        Gson gson = new Gson();

        Log.i("ProjetoFinal", "doInBackground (GSON): " + convidado);


        try {

            response = HttpService.sendJSONPostResquest("get-byname", gson.toJson(convidado));

        }catch (IOException e){

            Log.e("AtividadeListView", e.getMessage());

        }

        return response;

    }
    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

        	procurarPessoaCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Convidado> convidado = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Convidado>>(){}.getType());

            procurarPessoaCallBack.backBuscarNome(convidado);
        }

    }
}
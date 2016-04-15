package ifpb.edu.br.projetofinal.callback;

import ifpb.edu.br.projetofinal.entidades.Convidado;

import java.util.List;

public interface ProcurarPessoaCallBack {

    void backBuscarNome(List<Convidado> names);

    void errorBuscarNome(String error);


}

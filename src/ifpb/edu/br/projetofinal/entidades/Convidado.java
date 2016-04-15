package ifpb.edu.br.projetofinal.entidades;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Convidado implements Serializable{
	
	

       public Convidado (){}
    

    public void Convidado (String nome, String qrcode) {

        this.nome = nome;
        this.qrcode = qrcode;  

    }

      @SerializedName("id")
      private int id;

      @SerializedName("nome")
      private String nome;

      @SerializedName("qrcode")
      private String qrcode;

       
 
    public String toString() {

        return "[nome: " + nome + "; qrcode: " + qrcode + "]";

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

}
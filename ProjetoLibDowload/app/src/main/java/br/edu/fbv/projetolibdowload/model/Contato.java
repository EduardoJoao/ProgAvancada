package br.edu.fbv.projetolibdowload.model;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import java.util.Random;

import br.edu.fbv.projetolibdowload.Config.ConfiguracaoFirebase;
import br.edu.fbv.projetolibdowload.Helper.Base64;

public class Contato {

    private String url;
    private String nome;
    private String telefone;
    private String email;

    public Contato(){

    }

    public void salvar(){

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("contato")
                .push()
                .setValue(this);

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

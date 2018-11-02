package br.edu.fbv.projetolibdowload.model;

import com.google.firebase.database.DatabaseReference;

import br.edu.fbv.projetolibdowload.Config.ConfiguracaoFirebase;

public class Contato {

    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

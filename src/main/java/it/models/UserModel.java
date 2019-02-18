package it.models;

public class UserModel {
    private int id;
    private String nome;
    private String password;

    public UserModel() {}

    public UserModel(String nome){
        this.nome = nome;
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

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

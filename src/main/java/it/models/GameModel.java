package it.models;

public class GameModel {

    private int id;
    private int idUser;
    private int result;


    public GameModel(){
        result = 0;
    }

    public GameModel(int idUser) {
        this.idUser = idUser;
        result = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

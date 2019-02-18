package it.models;

import it.repository.Dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TryModel  {
    private int  id;
    private int userId;
    private int gameId;
    private int CombinationId;
    private int[] userTry=new int[3];
    private int[] esito=new int[2];

    public TryModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getUserTry() {
        return userTry;
    }

    public void setUserTry(int[] userTry) {
        this.userTry = userTry;
    }

    public int[] getEsito() {
        return esito;
    }

    public void setEsito(int[] esito) {
        this.esito = esito;
    }

}

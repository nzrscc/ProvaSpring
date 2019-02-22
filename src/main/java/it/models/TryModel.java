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
    private String combinationUser ="";
    private int[] esito=new int[2];

    private int numero1, numero2, numero3;

    public int getCombinationId() {
        return CombinationId;
    }

    public void setCombinationId(int combinationId) {
        CombinationId = combinationId;
    }


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

    public void setUserTry(int[] userTry) { this.userTry = userTry; }

    public void setUserTry() {
        this.userTry[0] = this.getNumero1();
        this.userTry[1] = this.getNumero2();
        this.userTry[2] = this.getNumero3();
        combinationUser += this.getNumero1()+",";
        combinationUser += this.getNumero2()+",";
        combinationUser += this.getNumero3();
    }

    public String getCombinationUser() {
        return combinationUser;
    }
    public int[] getEsito() {
        return esito;
    }

    public void setEsito(int[] esito) {
        this.esito = esito;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero3() {
        return numero3;
    }

    public void setNumero3(int numero3) {
        this.numero3 = numero3;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

}

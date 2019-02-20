package it.services;

import java.util.ArrayList;

public class MasterService {

    private ArrayList<Integer> combMaster;
    private ArrayList<Integer> combUser;

    private String usernameSaved;
    private TryService tmpTry;

    public MasterService()
    {
        tmpTry = new TryService();
    }

    //Generatore RANDOM del master
    public ArrayList<Integer> generaMaster() {
        ArrayList<Integer> mastRandom = new ArrayList<>();
        mastRandom.add((int) (Math.random() * 10));
        mastRandom.add((int) (Math.random() * 10));
        mastRandom.add((int) (Math.random() * 10));
        setCombMaster(mastRandom);

        for (int n : mastRandom)
            System.out.print("Master " + n + " - ");

        return mastRandom;
    }

    //Confronta con la classe TryService
    public int[] eseguiConfronto()
    {
        return tmpTry.doCheck(getCombMaster(), getCombUser());
    }


    public String getUsernameSaved() {
        return usernameSaved;
    }

    public void setUsernameSaved(String usernameSaved) {
        this.usernameSaved = usernameSaved;
    }

    public ArrayList<Integer> getCombMaster() {
        return combMaster;
    }

    public void setCombMaster(ArrayList<Integer> combMaster) {
        this.combMaster = combMaster;
    }

    public ArrayList<Integer> getCombUser() {
        return combUser;
    }

    public void setCombUser(ArrayList<Integer> combUser) {
        this.combUser = combUser;
    }
}

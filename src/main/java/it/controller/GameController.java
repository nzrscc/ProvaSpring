package it.controller;


public class GameController {

    private int tentativi;


    public void resetTentativi() { this.tentativi = 10;}

    public int getTentativi() {
        return tentativi;
    }

    public void setTentativi(int tentativi)
    {
        this.tentativi = tentativi;
    }

}

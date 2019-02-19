package it.services;

import java.util.ArrayList;

public class MasterService {

    public ArrayList<Integer> generaMaster() {
        ArrayList<Integer> mastRandom = new ArrayList<>();
        mastRandom.add((int) (Math.random() * 10));
        mastRandom.add((int) (Math.random() * 10));
        mastRandom.add((int) (Math.random() * 10));
        return mastRandom;
    }


}

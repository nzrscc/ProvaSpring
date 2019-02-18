package it.services;

public class ValidatorService {

    private int [] input=new int[3];

    public int[] controlloInput(String combination) {
        if(combination.length()==5 && combination.matches("[0-9][,][0-9][,][0-9]"))
        {
           String[] s = combination.split(",");
            for(int i=0; i<s.length;i++)
            {
                input[i] = Integer.parseInt(s[i]);
            }
        }
        return input;
    }

}

package it.services.utils;

public class CheckerMasterMind implements Checker {
    @Override
    public int [] doCheck(int [] soluzione, int []input) {
        int posizioneEsatta=0;
        int numeriEsatti=0;
        int [] riSoluzione=new int [3];
        int [] riInput=new int [3];
        int [] esito=new int[2];
        for(int i=0;i<3;i++)
        {
            riInput[i]=input[i];
        }
        for(int i=0;i<3;i++)
        {
            riSoluzione[i]=soluzione[i];
        }
        for(int i=0;i<soluzione.length;i++)
        {
            boolean posEsatta=false;
            for(int j=0;j<soluzione.length;j++)
            {
                if(i==j)
                {
                    if(input[i]==riSoluzione[j])
                    {

                        posEsatta=true;
                        j=j+10;
                    }else
                    {
                        posEsatta=false;
                    }
                }
                if(posEsatta==true)
                {
                    posizioneEsatta++;
                    riSoluzione[j-10]=15;
                    riInput[j-10]=11;
                }else{}
            }
        }
        for(int i=0;i<soluzione.length;i++)
        {
            boolean numEsatto;
            for (int j = 0; j < soluzione.length; j++)
            {
                if (riInput[i] == riSoluzione[j])
                {
                    numEsatto = true;
                    j = j + 10;
                }else {
                    numEsatto = false;
                }
                if (numEsatto == true)
                {
                    numeriEsatti++;
                    riSoluzione[j-10]=15;
                    riInput[i]=11;
                } else {}
            }
        }
        esito[0]=posizioneEsatta;
        esito[1]=numeriEsatti;
        if(posizioneEsatta==3)
        {
            System.out.println("Complimenti! Combinazione esatta!");
        }else
        {
            System.out.println("\nI numeri in posizione esatta sono: "+posizioneEsatta+";\nI numeri presenti in posizione errata sono: "+(numeriEsatti)+"\n");
        }
        return esito;

    }

}

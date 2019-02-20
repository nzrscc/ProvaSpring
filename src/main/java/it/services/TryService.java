package it.services;

import java.util.ArrayList;

public class TryService {

    public int[] doCheck(ArrayList<Integer> master, ArrayList<Integer> user) {
        //Controllo se l'utente ha vinto confrontando i 2 vettori
        if (!master.equals(user)) {
            int[] tempListFinale;
            ArrayList<Integer> masterLIst = new ArrayList<Integer>(master);
            ArrayList<Integer> userLIst = new ArrayList<Integer>(user);

            //Mi servirà per verificare quali numeri ho già controllato
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            ArrayList<Boolean> boolList = new ArrayList<Boolean>();
            boolList.add(false);
            boolList.add(false);
            boolList.add(false);

            //Ciclo sul master e controllo i numeri dell'utente
            //Se il numero è uguale lo sostituisco nel mio array provvisorio
            //Metto un 10 al posto del numero uguale
            //La lista booleana si aggiorna quando ottengo il MATCH dei valori
            for (int i = 0; i < masterLIst.size(); i++) {
                if (masterLIst.get(i) == userLIst.get(i)) {
                    tempList.add(10);
                    boolList.set(i, true);
                }
                //Altrimenti aggiungo il numero dell'utente all'array temporaneo
                else
                    tempList.add(userLIst.get(i));
            }

            //Passo il master, il nuovo array e la lista di bool al metodo finale
            tempListFinale = confronta(masterLIst, tempList, boolList);
            return tempListFinale;
        }
        //Se entro qui l'utente ha vinto
        else {
            int[] vittoria = new int[]{3, 0};
            return vittoria;
        }

    }

    private int[] confronta(ArrayList<Integer> master, ArrayList<Integer> tempPosizionato, ArrayList<Boolean> boolList) {

        ArrayList<Integer> masterLIst = new ArrayList<Integer>(master);
        ArrayList<Integer> tempList = new ArrayList<Integer>(tempPosizionato);

        int[] confrontoPosizione;

        for (int i = 0; i < masterLIst.size(); i++) {
            if (boolList.get(i).equals(false)) {
                for (int k = 0; k < tempList.size(); k++) {
                    if (masterLIst.get(i).equals((tempList.get(k)))) {
                        tempList.remove(k);
                        tempList.add(k, 11);
                        break;
                    }
                }
            }
        }
        confrontoPosizione = fineConfronto(tempList);
        return confrontoPosizione;
    }

    private int[] fineConfronto(ArrayList<Integer> temp) {

        int[] confrontoPosizione = new int[]{0, 0};

        for (int a : temp) {
            if (a == 10) {
                confrontoPosizione[0] += 1;
            } else if (a == 11) {
                confrontoPosizione[1] += 1;
            }
        }
        return confrontoPosizione;
    }

}

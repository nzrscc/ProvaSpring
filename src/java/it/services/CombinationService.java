package it.services;

import it.controllers.CombinationController;
import it.models.CombinationModel;
import it.repository.CombinationDao;
import it.services.utils.Checker;


public class CombinationService  {
    private CombinationModel combinationModel;
    private Checker checkerMasterMind;
    private CombinationDao combinationDao;

    public CombinationService() {}
    public CombinationService(CombinationModel combinationModel, Checker checkerMasterMind) {
        this.combinationModel=combinationModel;
        this.checkerMasterMind=checkerMasterMind;
        this.combinationDao = CombinationDao.getInstance();
    }

    public void createCombination()
    {
        int[] soluzione = new int [3];
        for(int i=0;i< soluzione.length;i++)
        {
            soluzione[i]=(int)(Math.random()*10);
        }
        combinationModel.setPcCombination(soluzione);
    }

    public boolean addCombination(int[] pcCombination) {
        return combinationDao.addCombination(pcCombination);
    }

    public int[] getCombination(){
        return combinationModel.getPcCombination();
    }

    public int [] check(int [] soluzione, int [] input)
    {
        return this.checkerMasterMind.doCheck(soluzione, input);
    }
}



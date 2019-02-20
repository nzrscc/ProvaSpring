package it.services;

import it.models.CombinationModel;
import it.models.GameModel;
import it.repository.CombinationDao;
import it.services.utils.Checker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinationService  {
    private CombinationModel combinationModel;
    private Checker checkerMasterMind;
    @Autowired
    private CombinationDao combinationDao;

    public CombinationService() {
        combinationModel = new CombinationModel();
    }
    public CombinationService(CombinationModel combinationModel, Checker checkerMasterMind) {
        this.combinationModel=combinationModel;
        this.checkerMasterMind=checkerMasterMind;
        this.combinationDao = CombinationDao.getInstance();
    }

    private void generateCombination() {
        int[] soluzione = new int [3];
        for(int i=0;i< soluzione.length;i++)
        {
            soluzione[i]=(int)(Math.random()*10);
        }
        combinationModel.setPcCombination(soluzione);
    }

    public boolean createCombination(int idCurrentGame) {
        generateCombination();
        return combinationDao.saveCombination(idCurrentGame, combinationModel);
    }

    public int[] getCombination(){
        return combinationModel.getPcCombination();
    }

    public int [] check(int [] soluzione, int [] input)
    {
        return this.checkerMasterMind.doCheck(soluzione, input);
    }
}



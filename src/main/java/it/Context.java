package it;

import it.controller.Controller;
import it.models.CombinationModel;
import it.models.TryModel;
import it.services.CombinationService;
import it.services.TryService;
import it.services.ValidatorService;
import it.services.utils.Checker;
import it.services.utils.CheckerMasterMind;

public class Context {
    private static Context istanzaContesto;
    private Controller controller;


    public static Context getInstance() {
        if (istanzaContesto == null) {
            istanzaContesto = new Context();
        }
        return istanzaContesto;
    }

    private Context()
    {
        Checker checkerMasterMind=new CheckerMasterMind();
        TryModel tryModel=new TryModel();
        CombinationModel combinationModel=new CombinationModel();
        CombinationService combinationService=new CombinationService(combinationModel, checkerMasterMind);
        TryService tryService=new TryService();
        ValidatorService validatorService=new ValidatorService();
        this.controller=new Controller(validatorService, combinationService, tryService);
        this.controller.setTryModel(tryModel);
    }

    public Controller getController(){
        return  this.controller;
    }

}

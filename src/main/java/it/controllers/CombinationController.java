package it.controllers;

import it.services.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    public CombinationController(){}

    public boolean createCombination(int idCurrentGame) {
      return combinationService.createCombination(idCurrentGame);
    }

    public int getIdCurrentCombination(int idCurrentGame) {
        return combinationService.getIdCurrentCombination(idCurrentGame);
    }

}

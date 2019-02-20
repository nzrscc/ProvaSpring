package it.controllers;

import it.models.GameModel;
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
}

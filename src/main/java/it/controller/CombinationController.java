package it.controller;

import it.services.CombinationService;


public class CombinationController {
    private CombinationService combinationService;

    public CombinationController() {
        combinationService = new CombinationService();
    }

    public boolean addCombination(int[] array) {

        return combinationService.addCombination(array);
    }
}

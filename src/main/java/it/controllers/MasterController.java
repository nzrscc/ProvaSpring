package it.controllers;

import it.models.CombinationModel;
import it.models.TryModel;
import it.models.UserModel;
import it.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MasterController {

    @Autowired
    private DAOService daoService;

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private TryService tryService;

    @Autowired
    private CombinationService combinationService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @RequestMapping("/")
    String home() {
        return "index";
    }


    @RequestMapping(value="/game", method = RequestMethod.POST)
    public ModelAndView game(@ModelAttribute("currentTry") TryModel currentTry, HttpSession session, SessionStatus sessionStatus ) {

        ModelAndView model;
        currentTry.setUserTry();

        int idUser = -1;
        int idGame = -1;
        int idComb = -1;

        if( verificaInput(currentTry.getCombinationUser()) ) {
            int[] currentResult = verificaCombinazione(combinationService.getCombination(),currentTry);

            idUser = (int) session.getAttribute("currentIdUser");
            idGame = (int) session.getAttribute("currentIdGame");
            idComb = (int) session.getAttribute("currentIdCombination");

            currentTry.setUserId(idUser);
            currentTry.setEsito(currentResult);
            currentTry.setGameId(idGame);
            currentTry.setCombinationId(idComb);

           if( tryService.saveTry(currentTry)) {
              model = visualizzaRisultato(currentTry, idGame);
              return model;
           }
           else {
               model = new ModelAndView("paginaErrore2");
               return model;
           }
        }
        model = new ModelAndView("paginaErrore2");
        return model;
    }

    public boolean verificaInput(String combination) {
        return validatorService.controlloInput(combination);
    }

    public void createTableModel() {
        daoService.createTableModel();
    }

    public int[] verificaCombinazione(int[] currentCombination, TryModel currentTry) {
        return combinationService.checkCombination(currentCombination, currentTry);
    }

    public void saveTry( TryModel currentTry)
    {
        this.tryService.saveTry(currentTry);
    }

    public ModelAndView visualizzaRisultato (TryModel currentTry, int idGame) {
        ModelAndView currentTryResultView;
        currentTryResultView = new ModelAndView("game");
        currentTryResultView.addObject("risultatoCorrente", currentTry.getEsito());
        currentTryResultView.addObject("posizioneEsatta",currentTry.getEsito()[0]);
        currentTryResultView.addObject("posizioneErrata",currentTry.getEsito()[1]);
        int numTentativi = 0;
        if( (numTentativi = getNumberTryLeft(idGame)) == 0 ) {
            currentTryResultView = new ModelAndView("result");
        }
        else{
        currentTryResultView.addObject("numTentativo",numTentativi);
        }
        return currentTryResultView;

    }

    public int getNumberTryLeft(int gameId) {
        return gameService.getNumberTryLeft(gameId);
    }

    public CombinationService getCombinationService() {
        return combinationService;
    }

    public MasterController() {}
    public MasterController(ValidatorService validatorService, TryService tryService) {
        this.validatorService=validatorService;
        this.tryService=tryService;
    }

}

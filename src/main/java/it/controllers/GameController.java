package it.controllers;

import it.models.GameModel;
import it.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    UserController userController;

    public GameModel createGame(int id) {
        GameModel gameModel = new GameModel(id);
        return gameModel;
    }

    public boolean saveGame(int idUser) {

        return gameService.saveGame(idUser);
    }

    public  int getIdCurrentGame(int idCurrentUser) {
        return gameService.getIdCurrentGame(idCurrentUser);
    }

    public GameController(){
        this.gameService = new GameService();
    }
}

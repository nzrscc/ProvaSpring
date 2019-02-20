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

    GameModel gameModel;


    public GameModel createGame(int id) {
        gameModel = new GameModel(id);
        return gameModel;
    }

    public boolean saveGame(int idUser) {

        return gameService.saveGame(idUser);
    }
    public GameController(){
        this.gameModel = new GameModel();
        this.gameService = new GameService();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }


    public  int getIdCurrentGame(int idCurrentUser) {
        return gameService.getIdCurrentGame(idCurrentUser);
    }
}

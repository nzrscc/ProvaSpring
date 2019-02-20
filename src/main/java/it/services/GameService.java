package it.services;

import it.models.GameModel;
import it.models.UserModel;
import it.repository.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameDao gameDao;

    public boolean saveGame( int idUser) {
        return gameDao.saveGame(idUser);
    }

    public int getIdCurrentGame(int idCurrentUser) {
        return gameDao.getIdCurrentGame(idCurrentUser);
    }


}

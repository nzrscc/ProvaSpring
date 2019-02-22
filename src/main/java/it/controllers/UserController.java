package it.controllers;

import it.App;
import it.models.GameModel;
import it.models.UserModel;
import it.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CombinationController combinationController;

    @Autowired
    private GameController gameController;


    @Scope("session")
    @RequestMapping(value="/login", method = RequestMethod.POST )
    public ModelAndView login(@ModelAttribute("currentUser") UserModel user, HttpSession session) {
        App.getLogger().info("metodo login chiamato");
        ModelAndView model = new ModelAndView("paginaEerrore1");
        String passwordSecure = "";

        try {
            passwordSecure = cifraPassword(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (userService.verificaLogin(user.getNome(), passwordSecure)) {
            App.getLogger().debug("verifica login effettuata con successo");
            int idCurrentUser = getIdUser(user);
            session.setAttribute("currentIdUser", idCurrentUser);
            GameModel currentGame = gameController.createGame(idCurrentUser);
            if( gameController.saveGame(idCurrentUser)){
                int idCurrentGame = getIdCurrentGame(idCurrentUser);
                currentGame.setId(idCurrentGame);
                session.setAttribute("currentIdGame", idCurrentGame);
                 if(combinationController.createCombination(idCurrentGame) ) {
                     int idCurrentCombination = combinationController.getIdCurrentCombination(idCurrentGame);
                     session.setAttribute("currentIdCombination",idCurrentCombination);
                     model = new ModelAndView("game");
                 }
            }
            else {
                model = new ModelAndView("paginaErrore1");
            }
        }
        else {
            model = new ModelAndView("paginaErrore");
            model.addObject("UserSbagliato", user);
        }
        return model;
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        request.setAttribute("loggedOut", "notLogged");
        return "index";
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public ModelAndView signup(@ModelAttribute("currentUser") UserModel user ) {
        ModelAndView model;
        String passwordSecure = "";

        try {
            passwordSecure = cifraPassword(user.getPassword());
            user.setPassword(passwordSecure);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (userService.addUser(user)){
            model = new ModelAndView("index");
            model.addObject("registrato", user.getNome());
        }
        else {
            model = new ModelAndView("paginaErrore");
            model.addObject("user", user);
        }
        return model;

    }

    public UserController(){
    }

    private  String cifraPassword( String password ) throws NoSuchAlgorithmException {
        String passwordSecure = BCrypt.hashpw(password, "$2a$05$djeIcZogMlovcLVQ7i4rJ.");
        return passwordSecure;
    }

    public int getIdUser(UserModel user) {
        return userService.getIdUser(user);
    }
    public int getIdCurrentGame( int idCurrentUser) {
        return gameController.getIdCurrentGame(idCurrentUser);
    }


}

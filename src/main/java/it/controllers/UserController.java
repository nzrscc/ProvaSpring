package it.controllers;

import it.models.UserModel;
import it.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.security.NoSuchAlgorithmException;

@Controller
@Scope("session")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("currentUser") UserModel user) {
        ModelAndView model;
        String passwordSecure = "";

        try {
            passwordSecure = cifraPassword(user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (userService.verificaLogin(user.getNome(), passwordSecure)) {
            model = new ModelAndView("game");
        }
        else {
            model = new ModelAndView("paginaErrore");
            model.addObject("user", user);
        }
        return model;
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public ModelAndView signup(@ModelAttribute("currentUser") UserModel user ) {
        ModelAndView model;
        String passwordSecure = "";

        System.err.println(user.getNome());

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

    public UserController() {}

    private  String cifraPassword( String password ) throws NoSuchAlgorithmException {
        String passwordSecure = BCrypt.hashpw(password, "$2a$05$djeIcZogMlovcLVQ7i4rJ.");
        return passwordSecure;
    }

}

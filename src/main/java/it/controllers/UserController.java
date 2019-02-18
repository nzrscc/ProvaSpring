package it.controllers;

import it.models.UserModel;
import it.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView  login(@ModelAttribute("name") UserModel user) {

        ModelAndView model1;

        if (userService.verificaLogin(user.getNome(), user.getPassword())) {
            model1 = new ModelAndView("game");
        }
        else {
            System.out.println("deve andare in pagina di errore "+user.getNome() + " "+ user.getPassword());
            model1 = new ModelAndView("paginaErrore");
            model1.addObject("user", user);
        }
        return model1;
       // return  new ResponseEntity<UserModel>(user, HttpStatus.OK);
    }

    public UserController() {}

}

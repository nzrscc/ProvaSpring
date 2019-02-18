package it.controller;

import it.dto.UserDTO;
import it.models.UserModel;
import it.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    private UserService UserService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginForm", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<UserModel> login(@RequestBody UserModel utente) {

       if( userService.verificaLogin(utente.getNome(), utente.getPassword())) {
           System.out.println("utente verificato");
            HttpHeaders headers = new HttpHeaders();
            utente.setPassword("");
            //TODO impostare header UTENTE LOGGATO a true
            return new ResponseEntity<UserModel>(utente, headers, HttpStatus.OK);
        }
        return new ResponseEntity<UserModel>(HttpStatus.UNAUTHORIZED);
    }
/*
    @RequestMapping(value = "/signup", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<UserModel> signup(@RequestBody UserModel utente) {

        //utente.signup(utente);
        return new ResponseEntity<UserModel>(HttpStatus.OK);
    }*/

    public UserController() {
        UserService = new UserService();
    }

    public boolean addUser(String nome) {
        return UserService.addUser(nome);
    }

    public List<UserDTO> getUsers() {
        return UserService.getUsers();
    }
}

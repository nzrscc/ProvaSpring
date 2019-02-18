package it.controllers;

import it.dto.UserDTO;
import it.services.UserService;

import java.util.List;

public class UserController {
    private UserService UserService;

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

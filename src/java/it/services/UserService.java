package it.services;

import it.dto.UserDTO;
import it.models.UserModel;
import it.repository.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao;


    public UserService() {
        userDao  = UserDao.getInstance();
    }
    public boolean addUser(String nome) {
        return userDao.addUser(nome);

    }

    public List<UserDTO> getUsers() {

        List<UserModel> list = userDao.getUsers();
        List<UserDTO> listDTO = new ArrayList<>();
        for (int i = 0 ;  i < list.size(); i++ ) {
            UserDTO currentUserDTO = new UserDTO(list.get(i).getId(), list.get(i).getNome());
            String punteggio = userDao.calcolaPunteggio(list.get(i));
            /*punteggio += "%";*/
            currentUserDTO.setPunteggio(punteggio);
            listDTO.add(currentUserDTO);
        }
        return listDTO;
    }

    public boolean verificaLogin(String username, String password) {
        return userDao.verificaLogin(username, password);
    }
}

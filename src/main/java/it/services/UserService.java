package it.services;

import it.dto.UserDTO;
import it.models.UserModel;
import it.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
        userDao  = UserDao.getInstance();
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
    public boolean addUser (UserModel user ) {
        return userDao.addUser(user);
    }

    public boolean verificaLogin(String username, String password) {
        return userDao.verificaLogin(username, password);
    }

    public int getIdUser (UserModel user) {
        return userDao.getIdUser(user);
    }

}

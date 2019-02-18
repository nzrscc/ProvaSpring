package it.services;

import it.repository.Dao;

public class DAOService {
    private Dao dao;

    public DAOService (){
        dao = Dao.getInstance();
    }

    public void createTableModel()   {
        dao.createTableModel();
    }
}

package it.services;

import it.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOService {
    @Autowired
    private Dao dao;
    public DAOService() {}

    public void createTableModel()   {
        dao.createTableModel();
    }
}

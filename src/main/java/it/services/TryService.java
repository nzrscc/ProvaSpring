package it.services;

import it.models.TryModel;
import it.repository.TryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TryService {

    @Autowired
    private TryDao tryDao;


    public TryService() {}

    public boolean saveTry(TryModel tryModel)
    {
       return  tryDao.saveTry(tryModel);
    }
}

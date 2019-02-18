package it.services;

import it.models.TryModel;
import it.repository.TryDao;

import java.util.Arrays;

public class TryService {
    private TryDao tryDao;


    public TryService() {}

    public boolean saveTry(TryModel tryModel)
    {
       return  tryDao.saveTry(tryModel);
    }
}

package it.repository;

import it.models.TryModel;

public class TryDao {
    private static TryDao instance;
    private static DataSource dataSource;

    public static TryDao getInstance() {
        if (instance == null) {
            instance = new TryDao();
            dataSource = DataSource.getInstance();
        }
        return instance;
    }

    public boolean saveTry (TryModel currentTry) {
        return false;
    }
}

package it.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CombinationDao {
    private static CombinationDao combinationDaoInstance;
    private static DataSource dataSource;

    private CombinationDao() {
    }

    public static synchronized CombinationDao getInstance() {
        if (combinationDaoInstance == null) {
            combinationDaoInstance = new CombinationDao();
            dataSource = DataSource.getInstance();
        }
        return combinationDaoInstance;
    }

    public boolean addCombination(int[] pcCombination) {

        String soluzione = pcCombination.toString();

        try {
            String sql = ("INSERT INTO COMBINATION(SOLUZIONE) VALUES(?)");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, soluzione);
            int row = preparedStatement.executeUpdate();
            dataSource.closeConnection();
            if (row > 0)
                return true;
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package it.repository;

import it.controllers.CombinationController;
import it.models.CombinationModel;
import it.models.GameModel;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CombinationDao {
    private static CombinationDao combinationDaoInstance;
    private static DataSource dataSource;

    private CombinationDao() {
        dataSource = DataSource.getInstance();
    }

    public static synchronized CombinationDao getInstance() {
        if (combinationDaoInstance == null) {
            combinationDaoInstance = new CombinationDao();
        }
        return combinationDaoInstance;
    }

    public boolean saveCombination(int idCurrentGame, CombinationModel combination) {

         int[] array = combination.getPcCombination();
         String soluzione = "";
         for ( int i = 0; i < array.length; i++) {
             soluzione+= array[i];
         }

        try {
            String sql = ("INSERT INTO COMBINATION(GAME_ID, SOLUZIONE) VALUES(?,?)");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idCurrentGame);
            preparedStatement.setString(2, soluzione);
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

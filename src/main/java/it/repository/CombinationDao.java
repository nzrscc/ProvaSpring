package it.repository;

import it.controllers.CombinationController;
import it.models.CombinationModel;
import it.models.GameModel;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            if (row > 0) {
                System.out.println("creata combinazione sul database per il game :" + idCurrentGame);
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("fine metodo crea combinazione");
        return false;
    }

    public int getIdCurrentCombination( int currentGameId)  {
        int idCurrentCombination = -1;
        try {
            String sql = ("SELECT ID FROM COMBINATION WHERE COMBINATION.GAME_ID = ? ORDER BY ID DESC LIMIT 1");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, currentGameId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                idCurrentCombination = resultSet.getInt("ID");
            }
          dataSource.closeConnection();
            return idCurrentCombination;
        } catch (SQLException e) {
            e.printStackTrace();
         }
        return idCurrentCombination;
    }
}

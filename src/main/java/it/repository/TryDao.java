package it.repository;

import it.models.TryModel;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class TryDao {
    private static TryDao instance;
    private static DataSource dataSource;

    private TryDao(){
        dataSource = DataSource.getInstance();
    }
    public static TryDao getInstance() {
        if (instance == null) {
            instance = new TryDao();
        }
        return instance;
    }

    public boolean saveTry (TryModel currentTry) {
        try {
            String sql = ("INSERT INTO TRY(ID_COMB, ID_USER, ID_GAME, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI) VALUES(?,?,?,?,?,?)");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, currentTry.getCombinationId());
            preparedStatement.setInt(2, currentTry.getUserId());
            preparedStatement.setInt(3, currentTry.getGameId());
            preparedStatement.setInt(4, currentTry.getEsito()[0]);
            preparedStatement.setInt(5, currentTry.getEsito()[1]);
            preparedStatement.setString(6, currentTry.getCombinationUser());

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

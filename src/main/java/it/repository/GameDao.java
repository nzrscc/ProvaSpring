package it.repository;

import it.models.GameModel;
import it.models.UserModel;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GameDao {

    private static GameDao gameDaoInstance;
    private static DataSource dataSource;

    public static synchronized GameDao getInstance() {
        if (gameDaoInstance == null) {
            gameDaoInstance = new GameDao();
            dataSource = DataSource.getInstance();
        }
        return gameDaoInstance;
    }

    private GameDao() {
        dataSource = DataSource.getInstance();
    }

    public boolean saveGame(int id) {
        try {
            String sql = ("INSERT INTO GAME(ID_USER,RESULT) VALUES(?,?)");
            Connection c = dataSource.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, 0);
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

    private int getUserIdForGame( UserModel user) {
        int id = -1;
        try {
            String sql = ("SELECT ID FROM UTENTE WHERE UTENTE.NOME = ?");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getNome());
            ResultSet resultSet = preparedStatement.executeQuery();
            dataSource.closeConnection();
            if (resultSet.next()) {
                id = resultSet.getInt("ID");
                System.err.println("id =  "+id);
                return id;
            }
            else {
                System.err.println("id non trovato");
                return -1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    public int getIdCurrentGame (int id) {
        int idCurrentGame = -1;
        try {
            String sql = ("SELECT ID FROM GAME  WHERE ID_USER = ? ORDER BY ID DESC LIMIT 1");
            Connection c = dataSource.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                idCurrentGame =resultSet.getInt("ID");
            }
            dataSource.closeConnection();
            return idCurrentGame;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCurrentGame;

    }
}

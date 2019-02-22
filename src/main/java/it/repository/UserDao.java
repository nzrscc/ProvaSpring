package it.repository;


import it.models.UserModel;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private static UserDao instance;
    private static DataSource dataSource;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    private UserDao() {
        dataSource = DataSource.getInstance();
    }
    public boolean addUser(UserModel user) {
        if (!usernameUnivoco(user.getNome())) {
            return false;
        }
        try {
            String sql = ("INSERT INTO UTENTE(NOME,PASSWORD) VALUES(?,?)");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getPassword());
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

    public List<UserModel> getUsers() {
        List<UserModel> result = new ArrayList<>();

        try {
            String sql = ("SELECT * FROM UTENTE ");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel currentUser = new UserModel();
                currentUser.setId(resultSet.getInt("id"));
                currentUser.setNome(resultSet.getString("nome"));
                result.add(currentUser);
            }
            System.out.println("size" + result.size());
            return result;

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    public String calcolaPunteggio(UserModel user) {
        int c = (numeroVittorieUtente(user)*100) / numeroTentativiUtente(user);
        String result =  Integer.toString(c) ;
        return result;
    }

    public int numeroTentativiUtente(UserModel user) {
        int numeroTentativi = 1;
        try {
             String sql = ("SELECT COUNT(*) as CONTEGGIO FROM TRY AS T WHERE T.ID_USER = ?");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                numeroTentativi = resultSet.getInt("CONTEGGIO");
            }
            if( numeroTentativi == 0 ) {
                numeroTentativi = 1;
            }
            System.out.println("numero tentativi = "+numeroTentativi);
            dataSource.closeConnection();
            return numeroTentativi;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return numeroTentativi;
    }

    public int numeroVittorieUtente(UserModel user) {
        int numeroVittorie = 1;
        try {
            String sql = ("SELECT COUNT(*) as CONTEGGIO FROM TRY AS T WHERE T.ID_USER = ?" +
                    " AND T.POS_ESATTA = 3");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                numeroVittorie = resultSet.getInt("CONTEGGIO");
            }
            System.out.println("numero Vittorie = "+numeroVittorie);
            dataSource.closeConnection();
            return numeroVittorie;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return numeroVittorie;
    }

    public boolean verificaLogin(String username, String password) {
        try {
            String sql = ("SELECT * FROM UTENTE  WHERE NOME = ? AND PASSWORD = ?");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString( 2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
               if ( resultSet.getString(1).equals(username) )
                   dataSource.closeConnection();
                   return true;
            }
            dataSource.closeConnection();
            return false;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    private boolean usernameUnivoco(String username) {

        try {
            String sql = ("SELECT COUNT(*) as conteggio FROM UTENTE AS U WHERE U.NOME = ?");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username );
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int cont  = resultSet.getInt("conteggio");
                return  (cont == 0);
            }
            dataSource.closeConnection();
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public int getIdUser(UserModel user) {
        int id = -1;
        try {
            String sql = ("SELECT ID FROM UTENTE  WHERE NOME = ?");
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getNome());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                id = resultSet.getInt("ID");
                System.err.println("id user = "+ id);
            }
            dataSource.closeConnection();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return id;

    }


}



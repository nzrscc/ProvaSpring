package it.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSource {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String serverName;
    private String databaseName;
    private String username;
    private String password;
    private FileInputStream fin;
    private Properties p;
    private String url;
    private Connection connection;
    private Statement stmt;

    private static DataSource instance;

    private DataSource() {
    }

    public static DataSource getInstance() {
        if(instance==null)
        {
            instance = new DataSource();
        }
        return instance;

    }

    public Connection getConnection() {
        try {
            this.fin = new FileInputStream("C:\\Users\\utente\\IdeaProjects\\ProvaSpring\\src\\main\\java\\it\\repository\\db.properties");
            this.p = new Properties();
            this.p.load(fin);
            this.serverName = p.getProperty("sN");
            this.databaseName = p.getProperty("dN");
            this.username = p.getProperty("uN");
            this.password = p.getProperty("uP");
            this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName +"?serverTimezone=UTC";
            Class.forName(this.driverName);
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione effettuata!");

            return connection;
        } catch (
                SQLException se) {
            se.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();;
    }
}


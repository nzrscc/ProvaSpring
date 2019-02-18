package it.repository;

import java.sql.*;

public class Dao {

    private static Dao instance;
    private static DataSource dataSource;

    private Dao() {

    }

    public static Dao getInstance()
    {
        if(instance==null)
        {
            instance = new Dao();
            dataSource = DataSource.getInstance();
        }
        return instance;
    }

    public void createTableModel() {
        try {
            Connection currentConnection = dataSource.getConnection();
            Statement stmt = currentConnection.createStatement();
            stmt.executeUpdate( "CREATE TABLE IF NOT EXISTS UTENTE (ID INTEGER PRIMARY KEY AUTO_INCREMENT, NOME VARCHAR (255))");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PASSWORDCRYPT (ID INTEGER PRIMARY KEY AUTO_INCREMENT, PASSWORD VARCHAR (255))");

            stmt.executeUpdate( "CREATE TABLE IF NOT EXISTS GAME (ID INTEGER PRIMARY KEY AUTO_INCREMENT, ID_USER INTEGER, RESULT INTEGER, " +
                    " FOREIGN KEY (ID_USER) REFERENCES UTENTE(ID))");

            stmt.executeUpdate( "CREATE TABLE IF NOT EXISTS COMBINATION (ID INTEGER PRIMARY KEY AUTO_INCREMENT, GAME_ID INTEGER," +
                    " Soluzione VARCHAR(20), Data_Operazione VARCHAR(30), FOREIGN KEY (GAME_ID) REFERENCES GAME(ID))");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TRY (ID INTEGER, ID_COMB INTEGER, ID_USER INTEGER, ID_GAME INTEGER, POS_ESATTA INTEGER, NUM_ESATTO INTEGER, VALORI_INSERITI VARCHAR(20), Data_Operazione VARCHAR(30), PRIMARY KEY (ID, Data_operazione), FOREIGN KEY (ID_COMB) REFERENCES COMBINATION(ID), FOREIGN KEY (ID_USER) REFERENCES UTENTE(ID), FOREIGN KEY (ID_GAME) REFERENCES COMBINATION(GAME_ID))");

            dataSource.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   /*public boolean inserisciTRY (int tentativi, int posEsatta, int numEsatto, String numeri)

        public void popolaTabella(StringBuilder sql)
    {
        try
        {
            this.stmt.executeUpdate(sql.toString());
            //System.out.print("Registrazione effettuata!");
        }catch(SQLException se)
        {
            se.printStackTrace();
        }
    }

    public int prendiID()
    {
        int maxID=0;
        String selezionata=null;
        try {
            ResultSet resultset = this.stmt.executeQuery("SELECT ID FROM  COMBINATION");
            while(resultset.next()){
                maxID=resultset.getInt("ID");}
        }catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Nel dao maxID= "+maxID);
        return maxID;
    }

    public void popolaTabella(int tentativi, int posEsatta, int numEsatto, String numeri)
    {
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        StringBuilder sql=new StringBuilder();
        sql.append("INSERT INTO TRY (ID_COMB, ID, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI, Data_Operazione) VALUES ('");
        sql.append(instanceDao.prendiID());
        sql.append("', '");
        sql.append(tentativi);
        sql.append("', '");
        sql.append(posEsatta);
        sql.append("', '");
        sql.append(numEsatto);
        sql.append("', '");
        sql.append(numeri);
        sql.append("', '");
        sql.append(this.timeStamp);
        sql.append("')");
        *//*String sql = "INSERT INTO TRY (ID, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI, Data_Operazione) " +
             "VALUES ('"+ tentativi + "', '" + posEsatta +  "', '" + numEsatto + "', '" + (numeri )+ "', '" + this.timeStamp + "')";*//*
        instanceDao.popolaTabella(sql);
    }
*/
   /* public void popolaTabella(int [] soluzione)
    {
        Scanner in=new Scanner(System.in);
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) VALUES ('0','");
        sql.append(this.username);
        sql.append("','");
        sql.append(Arrays.toString(soluzione));
        sql.append("','");
        sql.append(this.timeStamp);
        sql.append("')");
        *//*String sql = "INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) " +
                "VALUES " +
                "('0', '"+ this.username + "', '" + Arrays.toString(soluzione) +  "', '" + this.timeStamp + "')";*//*
        instanceDao.popolaTabella(sql);
    }*/
}

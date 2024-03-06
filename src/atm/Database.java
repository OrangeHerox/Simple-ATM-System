package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiro Mendador
 */
public class Database {

    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306";
            String rootUname = "root";
            String rootPw = "i@mgr00t";
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, rootUname, rootPw);
            System.out.println("DATABASE CONNECTION SUCCESS!");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    //call this functions in main method once if database and table does not yet exists
    public void createDBAndAccountsTable() {
        try {
            Connection con = getConnection();
            ArrayList<String> atm = new ArrayList<>();
            atm.add("CREATE DATABASE IF NOT EXISTS dbATM;");
            atm.add("USE dbATM;");
            atm.add("SET NAMES utf8;");
            atm.add("SET character_set_client = utf8mb4;");
            atm.add("CREATE TABLE IF NOT EXISTS dbATM.tblAccounts(acc_id INT NOT NULL AUTO_INCREMENT, acc_pin VARCHAR(45) NOT NULL, acc_no VARCHAR(45) NOT NULL,acc_name VARCHAR(45) NOT NULL,acc_balance INT NOT NULL, PRIMARY KEY (acc_id));");
            for (int i = 0; i < atm.size(); i++) {
                PreparedStatement statement = con.prepareStatement(atm.get(i));
                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDefaultDataInTable() {
        try {
            Connection con = getConnection();
            ArrayList<String> account = new ArrayList<>();
            account.add("INSERT INTO dbATM.tblAccounts(acc_pin,acc_no,acc_name,acc_balance) VALUES('1111','1234 5678 9101 1213','JUAN DELA CRUZ','8000');");
            account.add("INSERT INTO dbATM.tblAccounts(acc_pin,acc_no,acc_name,acc_balance) VALUES('2275','1111 2222 3333 4444','MARLON SALVADOR','9000');");
            account.add("INSERT INTO dbATM.tblAccounts(acc_pin,acc_no,acc_name,acc_balance) VALUES('2246','1111 4444 5555 2222','MICHAEL CRUZ','15000');");
            account.add("INSERT INTO dbATM.tblAccounts(acc_pin,acc_no,acc_name,acc_balance) VALUES('3312','2323 4455 6789 1234','JUAN MIGUEL SANTOS','20000');");
            account.add("INSERT INTO dbATM.tblAccounts(acc_pin,acc_no,acc_name,acc_balance) VALUES('4657','5555 3333 1234 6789','JOHN MICHAEL DAVID','10000');");
            for (int i = 0; i < account.size(); i++) {
                PreparedStatement statement = con.prepareStatement(account.get(i));
                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

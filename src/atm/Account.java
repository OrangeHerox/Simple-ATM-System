package atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jiro Mendador
 */
public class Account {
    static String acc_pin, acc_no, acc_name;;
    static int acc_balance;
    
    public Account() {
        acc_pin = ""; 
        acc_no = "";
        acc_name = "";
        acc_balance = 0;
    }
    
    public Account(String pin) {
        this.acc_pin = pin;
    }
   
    public void setAccountInfo() {
        try {
            Connection connect = Database.getConnection();
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM dbATM.tblAccounts WHERE acc_pin = ?;");
            statement.setString(1,acc_pin);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                acc_no = result.getString("acc_no");
                acc_name = result.getString("acc_name");
                acc_balance = result.getInt("acc_balance");
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public boolean validateAccountPin() throws SQLException {
        Connection connect = Database.getConnection();
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM dbATM.tblAccounts WHERE acc_pin = ?;");
        statement.setString(1, acc_pin);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            return true;
        }
        statement.close();
        return false;
    }
   
   public static String getAccPin() {
       return acc_pin;
   }
   
   public static String getAccNumber() {
       return acc_no;
   }
   
   public static String getAccName() {
       return acc_name;
   }
   
   public static int getAccBalance() {
       return acc_balance;
   }
}

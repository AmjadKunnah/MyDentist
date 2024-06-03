package mydentisten.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mydentisten.dto.UsersDTO;
import mydentisten.ui.Receptionists_Dashboard;
import mydentisten.ui.Receptionists_Homepage;

/**
*
* @author amjad azim
*/

/*Class to retrieve connection for database and login verification*/
public class ConnectionFactory {
	
	
	static Connection con = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultset = null;
	
	
	
	/*Method to connect to sqlite database*/
	public static Connection getConnection()
	{
		try {
			
			Class.forName("org.sqlite.JDBC");
			con = (Connection) DriverManager.getConnection("jdbc:sqlite:MyDentistEn.db");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		       System.exit(0);
		}
		
		return con;
		
	}
	
	
	
	 /*Method to verification login*/
    public boolean checkLogin(String username, String password, String userType){
        String query = "SELECT * FROM Users WHERE Username= ? AND Password= ? AND User_Type= ?";

        try {
        	con = ConnectionFactory.getConnection();
        	preparedStatement = con.prepareStatement(query);
        	preparedStatement.setString(1, username);
        	preparedStatement.setString(2, password);
        	preparedStatement.setString(3, userType);
            resultset = preparedStatement.executeQuery();
            if(resultset.next())
            {
            	preparedStatement.close();
            	return true;
            }	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
	
	



}

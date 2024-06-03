package mydentisten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import mydentisten.database.ConnectionFactory;
import mydentisten.dto.PatientsDTO;
import mydentisten.dto.UsersDTO;

/**
*
* @author amjad azim
*/

/*                                      *
 *                                      *
 * Data Access Object for Receptionists *
 *                                      *
 *                                      */


public class ReceptionistsDAO {

	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public ReceptionistsDAO()
    { 
    	try
    	{
    		conn = new ConnectionFactory().getConnection();
    		statement = conn.createStatement();
    	}
    	catch(SQLException e)
    	{
            e.printStackTrace();

    	}
    	
    }
    
    
    
    
    /*                            *
     * Add new Receptionist methods *
     *                            */
    
    /*Check if Receptionist ID already exist in database method*/
    public void addReceptionistDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Receptionist ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Receptionist ID already exist, Please select another Receptionist ID");
			
			//Close database
			preparedstatement.close();
			}
			
			else
			{
				addFunction(usersDTO);
				
				//Close database
				preparedstatement.close();
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Receptionist ID already exist in database method*/
    
    
    /*Add new Receptionist to database method*/
    private void addFunction(UsersDTO usersDTO) {
		
     	try 
    	{
    		// Add data to database
    		preparedstatement = conn.prepareStatement("INSERT INTO `Users`(`UserID`,"
			        + " `Name`, `Last_Name`, `Date_Of_Birth`,"
			        + " `Phone_Number`, `Address`, `Gender`,"
			        + " `User_Type`, `Username`, `Password`,"
			        + " `Added_By_Supervisor`, `Added_Date`, `Added_Time`)"
			        + "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
    		preparedstatement.setString(1, usersDTO.getUserID());
    		preparedstatement.setString(2, usersDTO.getName());
    		preparedstatement.setString(3, usersDTO.getLast_Name());
    		preparedstatement.setString(4, usersDTO.getDate_Of_Birth());
    		preparedstatement.setInt(5, usersDTO.getPhone_Number());
    		preparedstatement.setString(6, usersDTO.getAddress());
    		preparedstatement.setString(7, usersDTO.getGender());
    		preparedstatement.setString(8, usersDTO.getUser_Type());
    		preparedstatement.setString(9, usersDTO.getUsername());
    		preparedstatement.setString(10, usersDTO.getPassword());
    		preparedstatement.setString(11, usersDTO.getAdded_By_Supervisor());
    		preparedstatement.setString(12, usersDTO.getAdded_Date());
    		preparedstatement.setString(13, usersDTO.getAdded_Time());

		
    		preparedstatement.execute();
			
			JOptionPane.showMessageDialog(null,"New Receptionist added successfuly");
    		// End of Add data to database

			
			//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    
		
	}
    /*End of Add new Receptionist to database method*/

    
    /*                                   *
     * End of Add new Receptionist methods *
     *                                   */
    
    
    
    
    /*                           *
     * Update Receptionist methods *
     *                           */
    
    /*Check if Receptionist exist in database method*/
    public void updateReceptionistDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Receptionist exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "updateFunction" method
				updateFunction(usersDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Receptionist ID not exist, Please select another Receptionist ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Receptionist exist in database method*/
  
    /*Update Receptionist method*/
    public void updateFunction(UsersDTO usersDTO)
    {
    	try
    	{
    		// Get Receptionist ID number from database to use it with WHERE 
			PreparedStatement preparedatatementIDNumber;
			preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
			preparedatatementIDNumber.setString(1, usersDTO.getUserID());
			ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
			int IDNumber = resultsetIDNumber.getInt(1);
			preparedatatementIDNumber.close();
			// End Get Receptionist ID number from database to use it with WHERE 
			
			
    		// Update data to database
    		preparedstatement = conn.prepareStatement("UPDATE Users SET " + 
					"       Name = ?," + 
					"       Last_Name = ?," + 
					"       Gender = ?," + 
					"       Date_Of_Birth = ?," + 
					"       Phone_Number = ?," + 
					"       Address = ?," +
					"       Username = ?," +
					"       Password = ?," +
					"       User_Type = ?," +
					"       Updated_By_Supervisor = ?," +
					"       Last_Update_Date = ?," +
					"       Last_Update_Time = ?  WHERE Id = "+IDNumber+" ");
			

			preparedstatement.setString(1, usersDTO.getName());
			preparedstatement.setString(2, usersDTO.getLast_Name());
			preparedstatement.setString(3, usersDTO.getGender());
			preparedstatement.setString(4, usersDTO.getDate_Of_Birth());
			preparedstatement.setInt(5, usersDTO.getPhone_Number());
			preparedstatement.setString(6, usersDTO.getAddress());
			preparedstatement.setString(7, usersDTO.getUsername());
			preparedstatement.setString(8, usersDTO.getPassword());
			preparedstatement.setString(9, usersDTO.getUser_Type());
			preparedstatement.setString(10, usersDTO.getUpdated_By_Supervisor());
			preparedstatement.setString(11, usersDTO.getLast_Update_Date());
			preparedstatement.setString(12, usersDTO.getLast_Update_Time());

			
			preparedstatement.executeUpdate();
    		
    		JOptionPane.showMessageDialog(null,"Receptionist updated successfuly");
    		// End of Update data to database

    		
    		//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    }
    /*End of Update Receptionist method*/
    

    /*                                  *
     * End of update Receptionist methods *
     *                                  */
    
    
    
    /*                           *
     * Delete Receptionist methods *
     *                           */
    
    /*Check if Receptionist exist in database method*/
    public void deleteReceptionistDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Receptionist exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "deleteFunction" method
				deleteFunction(usersDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Receptionist ID not exist, Please select another Receptionist ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Receptionist exist in database method*/
    
    
    /*Delete Receptionist method*/
    public void deleteFunction(UsersDTO usersDTO)
    {
		try {
			preparedstatement = conn.prepareStatement("DELETE FROM `Users` WHERE `UserID`=?");
			preparedstatement.setString(1, usersDTO.getUserID());
			// Confirm Delete
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this receptionist? \n "+"Receptionist ID : "+usersDTO.getUserID()
			,"Confirm delete receptionist",JOptionPane.YES_NO_OPTION);
			
			// if delete confirmed
			if(a == 0)
			{
				preparedstatement.execute();
				JOptionPane.showMessageDialog(null, "Receptionist deleted successfuly");
				
	    		//Close database
				preparedstatement.close();

			}
			
			else
			{
				//Close database
				preparedstatement.close();
			}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    /*End of Delete Receptionist method*/

    /*                                  *
     * End of delete Receptionist methods *
     *                                  */
    
}

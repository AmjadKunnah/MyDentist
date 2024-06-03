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

/*                                    *
 *                                    *
 * Data Access Object for Supervisors *
 *                                    *
 *                                    */


public class SupervisorsDAO {

	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public SupervisorsDAO()
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
     * Add new Supervisor methods *
     *                            */
    
    /*Check if supervisor ID already exist in database method*/
    public void addSupervisorDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if supervisor ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Supervisor ID already exist, Please select another Supervisor ID");
			
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
    
    /*End of check if supervisor ID already exist in database method*/
    
    
    /*Add new supervisor to database method*/
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
			
			JOptionPane.showMessageDialog(null,"New Supervisor added successfuly");
    		// End of Add data to database

			
			//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    
		
	}
    /*End of Add new supervisor to database method*/

    
    /*                                   *
     * End of Add new Supervisor methods *
     *                                   */
    
    
    
    
    /*                           *
     * Update Supervisor methods *
     *                           */
    
    /*Check if Supervisor exist in database method*/
    public void updateSupervisorDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if supervisor exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "updateFunction" method
				updateFunction(usersDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Supervisor ID not exist, Please select another Supervisor ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Supervisor exist in database method*/
  
    /*Update Supervisor method*/
    public void updateFunction(UsersDTO usersDTO)
    {
    	try
    	{
    		// Get Supervisor ID number from database to use it with WHERE 
			PreparedStatement preparedatatementIDNumber;
			preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
			preparedatatementIDNumber.setString(1, usersDTO.getUserID());
			ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
			int IDNumber = resultsetIDNumber.getInt(1);
			preparedatatementIDNumber.close();
			// End Get Supervisor ID number from database to use it with WHERE 
			
			
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
    		
    		JOptionPane.showMessageDialog(null,"Supervisor updated successfuly");
    		// End of Update data to database

    		
    		//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    }
    /*End of Update Supervisor method*/
    

    /*                                  *
     * End of update Supervisor methods *
     *                                  */
    
    
    
    /*                           *
     * Delete Supervisor methods *
     *                           */
    
    /*Check if Supervisor exist in database method*/
    public void deleteSupervisorDAO(UsersDTO usersDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Users` WHERE `UserID`=?");
    		preparedstatement.setString(1, usersDTO.getUserID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if supervisor exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "deleteFunction" method
				deleteFunction(usersDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Supervisor ID not exist, Please select another Supervisor ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Supervisor exist in database method*/
    
    
    /*Delete Supervisor method*/
    public void deleteFunction(UsersDTO usersDTO)
    {
		try {
			preparedstatement = conn.prepareStatement("DELETE FROM `Users` WHERE `UserID`=?");
			preparedstatement.setString(1, usersDTO.getUserID());
			// Confirm Delete
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this supervisor? \n "+"Supervisor ID : "+usersDTO.getUserID()
			,"Confirm delete supervisor",JOptionPane.YES_NO_OPTION);
			
			// if delete confirmed
			if(a == 0)
			{
				preparedstatement.execute();
				JOptionPane.showMessageDialog(null, "Supervisor deleted successfuly");
				
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
    /*End of Delete Supervisor method*/

    /*                                  *
     * End of delete Supervisor methods *
     *                                  */
    
}

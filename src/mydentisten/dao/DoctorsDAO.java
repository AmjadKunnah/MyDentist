package mydentisten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import mydentisten.database.ConnectionFactory;
import mydentisten.dto.DoctorsDTO;
import mydentisten.dto.PatientsDTO;
import mydentisten.dto.UsersDTO;

/**
*
* @author amjad azim
*/

/*                                      *
 *                                      *
 * Data Access Object for Doctors *
 *                                      *
 *                                      */


public class DoctorsDAO {

	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public DoctorsDAO()
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
     * Add new Doctor methods *
     *                            */
    
    /*Check if Doctor ID already exist in database method*/
    public void addDoctorDAO(DoctorsDTO doctorsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
    		preparedstatement.setString(1, doctorsDTO.getDoctorID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Doctor ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Doctor ID already exist, Please select another Doctor ID");
			
			//Close database
			preparedstatement.close();
			}
			
			else
			{
				addFunction(doctorsDTO);
				
				//Close database
				preparedstatement.close();
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Doctor ID already exist in database method*/
    
    
    /*Add new Doctor to database method*/
    private void addFunction(DoctorsDTO doctorsDTO) {
		
     	try 
    	{
    		// Add data to database
    		preparedstatement = conn.prepareStatement("INSERT INTO `Doctors`(`DoctorID`,"
			        + " `Name`, `Last_Name`, `Date_Of_Birth`,"
			        + " `Phone_Number`, `Address`, `Gender`,"
			        + " `Doctor_Specialist`, "
			        + " `Added_By_Supervisor`, `Added_Date`, `Added_Time`)"
			        + "  VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
    		preparedstatement.setString(1, doctorsDTO.getDoctorID());
    		preparedstatement.setString(2, doctorsDTO.getName());
    		preparedstatement.setString(3, doctorsDTO.getLast_Name());
    		preparedstatement.setString(4, doctorsDTO.getDate_Of_Birth());
    		preparedstatement.setInt(5, doctorsDTO.getPhone_Number());
    		preparedstatement.setString(6, doctorsDTO.getAddress());
    		preparedstatement.setString(7, doctorsDTO.getGender());
    		preparedstatement.setString(8, doctorsDTO.getDoctor_Specialist());
    		preparedstatement.setString(9, doctorsDTO.getAdded_By_Supervisor());
    		preparedstatement.setString(10, doctorsDTO.getAdded_Date());
    		preparedstatement.setString(11, doctorsDTO.getAdded_Time());

		
    		preparedstatement.execute();
			
			JOptionPane.showMessageDialog(null,"New Doctor added successfuly");
    		// End of Add data to database

			
			//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    
		
	}
    /*End of Add new Doctor to database method*/

    
    /*                                   *
     * End of Add new Doctor methods *
     *                                   */
    
    
    
    
    /*                           *
     * Update Doctor methods *
     *                           */
    
    /*Check if Doctor exist in database method*/
    public void updateDoctorDAO(DoctorsDTO doctorsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
    		preparedstatement.setString(1, doctorsDTO.getDoctorID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Doctor exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "updateFunction" method
				updateFunction(doctorsDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Doctor ID not exist, Please select another Doctor ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Doctor exist in database method*/
  
    /*Update Doctor method*/
    public void updateFunction(DoctorsDTO doctorsDTO)
    {
    	try
    	{
    		// Get Doctor ID number from database to use it with WHERE 
			PreparedStatement preparedatatementIDNumber;
			preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
			preparedatatementIDNumber.setString(1, doctorsDTO.getDoctorID());
			ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
			int IDNumber = resultsetIDNumber.getInt(1);
			preparedatatementIDNumber.close();
			// End Get Doctor ID number from database to use it with WHERE 
			
			
    		// Update data to database
    		preparedstatement = conn.prepareStatement("UPDATE Doctors SET " + 
					"       Name = ?," + 
					"       Last_Name = ?," + 
					"       Gender = ?," + 
					"       Date_Of_Birth = ?," + 
					"       Phone_Number = ?," + 
					"       Address = ?," +
					"       Doctor_Specialist = ?," +
					"       Updated_By_Supervisor = ?," +
					"       Last_Update_Date = ?," +
					"       Last_Update_Time = ?  WHERE Id = "+IDNumber+" ");
			

			preparedstatement.setString(1, doctorsDTO.getName());
			preparedstatement.setString(2, doctorsDTO.getLast_Name());
			preparedstatement.setString(3, doctorsDTO.getGender());
			preparedstatement.setString(4, doctorsDTO.getDate_Of_Birth());
			preparedstatement.setInt(5, doctorsDTO.getPhone_Number());
			preparedstatement.setString(6, doctorsDTO.getAddress());
			preparedstatement.setString(7, doctorsDTO.getDoctor_Specialist());
			preparedstatement.setString(8, doctorsDTO.getUpdated_By_Supervisor());
			preparedstatement.setString(9, doctorsDTO.getLast_Update_Date());
			preparedstatement.setString(10, doctorsDTO.getLast_Update_Time());

			
			preparedstatement.executeUpdate();
    		
    		JOptionPane.showMessageDialog(null,"Doctor updated successfuly");
    		// End of Update data to database

    		
    		//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    }
    /*End of Update Doctor method*/
    

    /*                                  *
     * End of update Doctor methods *
     *                                  */
    
    
    
    /*                           *
     * Delete Doctor methods *
     *                           */
    
    /*Check if Doctor exist in database method*/
    public void deleteDoctorDAO(DoctorsDTO doctorsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `DoctorID`=?");
    		preparedstatement.setString(1, doctorsDTO.getDoctorID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Doctor exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "deleteFunction" method
				deleteFunction(doctorsDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Doctor ID not exist, Please select another Doctor ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if Doctor exist in database method*/
    
    
    /*Delete Doctor method*/
    public void deleteFunction(DoctorsDTO doctorsDTO)
    {
		try {
			preparedstatement = conn.prepareStatement("DELETE FROM `Doctors` WHERE `DoctorID`=?");
			preparedstatement.setString(1, doctorsDTO.getDoctorID());
			// Confirm Delete
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this doctor? \n "+"Doctor ID : "+doctorsDTO.getDoctorID()
			,"Confirm delete docotr",JOptionPane.YES_NO_OPTION);
			
			// if delete confirmed
			if(a == 0)
			{
				preparedstatement.execute();
				JOptionPane.showMessageDialog(null, "Doctor deleted successfuly");
				
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
    /*End of Delete Doctor method*/

    /*                                  *
     * End of delete Doctor methods *
     *                                  */
    
}

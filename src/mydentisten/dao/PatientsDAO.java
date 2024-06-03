package mydentisten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import mydentisten.database.ConnectionFactory;
import mydentisten.dto.PatientsDTO;
import mydentisten.ui.Receptionists_PatientsPage;

/**
*
* @author amjad azim
*/

/*                                  *
 *                                  *
 * Data Access Object for Patients  *
 *                                  *
 *                                  */

public class PatientsDAO {
	
	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    
    public PatientsDAO()
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
    
    
    
    /*                         *
     * Add new patient methods *
     *                         */
   
    /*Check if patient ID already exist in database method*/
    public void addPatientDAO(PatientsDTO patientsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
    		preparedstatement.setString(1, patientsDTO.getPatientID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if patient ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Patient ID already exist, Please select another Patient ID");
			
			//Close database
			preparedstatement.close();
			}
			
			else
			{
				addFunction(patientsDTO);
				
				//Close database
				preparedstatement.close();
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if patient ID already exist in database method*/

    
    /*Add new patient to database method*/
    public void addFunction(PatientsDTO patientDTO)
    {
    	try 
    	{
    		// Add data to database
    		preparedstatement = conn.prepareStatement("INSERT INTO `Patients`(`PatientID`,"
			        + " `Name`, `Gender`, `Birthday`,"
			        + " `PhoneNO`, `Address`, `Added_By_Receptionist`)"
			        + " VALUES (?,?,?,?,?,?,?)");
			
    		preparedstatement.setString(1, patientDTO.getPatientID());
    		preparedstatement.setString(2, patientDTO.getName());
    		preparedstatement.setString(3, patientDTO.getGender());
    		preparedstatement.setString(4, patientDTO.getBirthday());
    		preparedstatement.setInt(5, patientDTO.getPhoneNO());
    		preparedstatement.setString(6, patientDTO.getAddress());
    		preparedstatement.setString(7, patientDTO.getAdded_By());
		
    		preparedstatement.execute();
			
			JOptionPane.showMessageDialog(null,"New patient added successfuly");
    		// End of Add data to database

			
			//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    }
    /*End of add new patient to database method*/
    
    /*                                *
     * End of add new patient methods *
     *                                */
    
    
    
    
    /*                        *
     * Update patient methods *
     *                        */
    
    /*Check if patient exist in database method*/
    public void checkPatientDAO(PatientsDTO patientsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
    		preparedstatement.setString(1, patientsDTO.getPatientID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if patient exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "updatePatientDAO" method
				updatePatientDAO(patientsDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Patient ID not exist, Please select another Patient ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if patient exist in database method*/
  
    /*Update patient method*/
    public void updatePatientDAO(PatientsDTO patientDTO)
    {
    	try
    	{
    		// Get Patient ID number from database to use it with WHERE 
			PreparedStatement preparedatatementIDNumber;
			preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
			preparedatatementIDNumber.setString(1, patientDTO.getPatientID());
			ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
			int IDNumber = resultsetIDNumber.getInt(1);
			preparedatatementIDNumber.close();
			// End Get Patient ID number from database to use it with WHERE 
			
			
    		// Update data to database
    		preparedstatement = conn.prepareStatement("UPDATE Patients SET " + 
					"       Name = ?," + 
					"       Gender = ?," + 
					"       Birthday = ?," + 
					"       PhoneNO = ?," + 
					"       Address = ?," +
					"       Updated_By_Receptionist = ?  WHERE Id = "+IDNumber+" ");
			

			preparedstatement.setString(1, patientDTO.getName());
			preparedstatement.setString(2, patientDTO.getGender());
			preparedstatement.setString(3, patientDTO.getBirthday());
			preparedstatement.setInt(4, patientDTO.getPhoneNO());
			preparedstatement.setString(5, patientDTO.getAddress());
			preparedstatement.setString(6, patientDTO.getAdded_By());

			
			preparedstatement.executeUpdate();
    		
    		JOptionPane.showMessageDialog(null,"Patient updated successfuly");
    		// End of Update data to database

    		
    		//Close database
			preparedstatement.close();

        } 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
        }
    }
    /*End of Update patient method*/

    /*                               *
     * End of update patient methods *
     *                               */
    
    
 
    
    /*                        *
     * Delete patient methods *
     *                        */
    
    /*Check if patient exist in database method*/
    public void deletePatientDAO(PatientsDTO patientsDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
    		preparedstatement.setString(1, patientsDTO.getPatientID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if patient exist in database
			if(resultset.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "deleteFunction" method
				deleteFunction(patientsDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Patient ID not exist, Please select another Patient ID");
				
				//Close database
				preparedstatement.close();
				
			};
					
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    
    /*End of check if patient exist in database method*/
    
    /*Delete Patient method*/
    public void deleteFunction(PatientsDTO patientDTO)
    {
		try {
			preparedstatement = conn.prepareStatement("DELETE FROM `Patients` WHERE `PatientID`=?");
			preparedstatement.setString(1, patientDTO.getPatientID());
			// Confirm Delete
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this patient? \n "+"Patient ID : "+patientDTO.getPatientID()
			,"Confirm delete patient",JOptionPane.YES_NO_OPTION);
			
			// if delete confirmed
			if(a == 0)
			{
				preparedstatement.execute();
				JOptionPane.showMessageDialog(null, "Patient deleted successfuly");
				
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
    /*End of Delete Patient method*/

    /*                               *
     * End of delete patient methods *
     *                               */
  

}

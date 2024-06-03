package mydentisten.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import mydentisten.database.ConnectionFactory;
import mydentisten.dto.AppointmentsDTO;
import mydentisten.dto.InvoicesDTO;
import mydentisten.dto.PatientsDTO;

/**
*
* @author amjad azim
*/

/*                                     *
 *                                     *
 * Data Access Object for Appointments *
 *                                     *
 *                                     */


public class AppointmentsDAO {
	
	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public AppointmentsDAO()
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
    
    
    
    /*                             *
     * Add new Appointment methods *
     *                             */
    
    /*Check if Appointment ID already exist in database method*/
    public void addAppointmentDAO(AppointmentsDTO appointmentDTO)
    {
    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
    		preparedstatement.setString(1, appointmentDTO.getAppointmentID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Appointment ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Appointment ID already exist, Please select another Appointment ID");
			
			//Close database
			preparedstatement.close();
			}
			
			else
			{
				//Close database
				preparedstatement.close();
				checkInvoiceID(appointmentDTO);
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    }
    /*End of Check if Appointment ID already exist in database method*/



    /*Check if Invoice ID already exist in database method*/
	private void checkInvoiceID(AppointmentsDTO appointmentDTO) 
	{

    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Invoices` WHERE `InvoiceID`=?");
    		preparedstatement.setString(1, appointmentDTO.getInvoiceID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Invoice ID already exist in database
			if(resultset.next())
			{JOptionPane.showMessageDialog(null, "Invoice ID already exist, Please select another Invoice ID");
			
			//Close database
			preparedstatement.close();
			}
			
			else
			{
				//Close database
				preparedstatement.close();
				checkPatientID(appointmentDTO);
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    
	}
    /*End of Check if Invoice ID already exist in database method*/



	/*Check if Patient ID exist in database method*/
	private void checkPatientID(AppointmentsDTO appointmentDTO) 
	{


    	try
    	{
    		preparedstatement = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
    		preparedstatement.setString(1, appointmentDTO.getPatientID());
			ResultSet resultset = preparedstatement.executeQuery();

			//if Patient ID  exist in database
			if(resultset.next())
			{
				// get patient name from Patients table using resultset
				PatientsDTO patientDTO = new PatientsDTO();
				String patientName = resultset.getString(3);
				patientDTO.setName(patientName);
				
				preparedstatement.close();
				// End get patient name from Patients table using resultset
				
				addAppointment(appointmentDTO, patientDTO);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Patient ID not exist, Please Add this patient first");
				
				//Close database
				preparedstatement.close();
			}
    	}
    	 catch (SQLException e) 
    	{
             e.printStackTrace();
        }
    
	
		
	}
	/*End of Check if Patient ID exist in database method*/



	/*Add Appointment data to database method*/
	private void addAppointment(AppointmentsDTO appointmentDTO, PatientsDTO patientDTO) 
	{
		try
    	{
			// get Doctor ID 
			PreparedStatement preparedstatemenDoctorID;
			preparedstatemenDoctorID = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `Name`=?");
			preparedstatemenDoctorID.setString(1, appointmentDTO.getDoctor_Name());
			ResultSet resultsetDoctorID = preparedstatemenDoctorID.executeQuery();
			String DoctorID = resultsetDoctorID.getString(2);
			preparedstatemenDoctorID.close();
			// End of get Doctor ID 
			
			// Enter Data to database
			preparedstatement = conn.prepareStatement("INSERT INTO `Appointments`(`AppointmentID`,"
			        + " `PatientID`, `Patient_Name`, `DoctorID`,"
			        + " `Doctor_Name`, `Date` , `Time` , `Service`, `Receptionists_Name`, `Status`)"
			        + " VALUES (?,?,?,?,?,?,?,?,?,?)");
			preparedstatement.setString(1, appointmentDTO.getAppointmentID());
			preparedstatement.setString(2, appointmentDTO.getPatientID());
			preparedstatement.setString(3, patientDTO.getName());
			preparedstatement.setString(4, DoctorID);
			preparedstatement.setString(5, appointmentDTO.getDoctor_Name());
			preparedstatement.setString(6, appointmentDTO.getDate());
			preparedstatement.setString(7, appointmentDTO.getTime());
			preparedstatement.setString(8, appointmentDTO.getService());
			preparedstatement.setString(9, appointmentDTO.getReceptionists_Name());
			preparedstatement.setString(10, "Current");
			
			preparedstatement.execute();
			
			JOptionPane.showMessageDialog(null,"Appointment Booked successfuly");
			//End of  Enter Data to database
			
			//Close database
			preparedstatement.close();
    	}
    	catch(SQLException e)
    	{
            e.printStackTrace();

    	}
	}
	/*End of Add Appointment data to database method*/

    /*                                    *
     * End of Add new Appointment methods *
     *                                    */
	
	
	
	
	
	/*                            *
     * Update appointment methods *
     *                            */
	
	/*Check appointment ID if exist in database method*/
	public void updateAppointmentDAO(AppointmentsDTO appointmentDTO)
	{
		try
		{
			preparedstatement = conn.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
			preparedstatement.setString(1, appointmentDTO.getAppointmentID());
			ResultSet resultSet = preparedstatement.executeQuery();
			if(resultSet.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "updateAppointment" method
				updateAppointment(appointmentDTO);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Appointment ID not exist, Please select another Appointment ID");
				
				//Close database
				preparedstatement.close();
				
			}
		}
		catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	/*End of Check appointment ID if exist in database method*/


	/*Update Appointment method*/
	private void updateAppointment(AppointmentsDTO appointmentDTO) 
	{
		try
		{
			
		// Get Appointment ID number from database to use it with WHERE 
		PreparedStatement preparedatatementIDNumber;
		preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
		preparedatatementIDNumber.setString(1, appointmentDTO.getAppointmentID());
		ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
		int IDNumber = resultsetIDNumber.getInt(1);
		preparedatatementIDNumber.close();
		// End Get Appointment  ID number from database to use it with WHERE 

		// get Doctor ID 
		PreparedStatement preparedstatemenDoctorID;
		preparedstatemenDoctorID = conn.prepareStatement("SELECT * FROM `Doctors` WHERE `Name`=?");
		preparedstatemenDoctorID.setString(1, appointmentDTO.getDoctor_Name());
		ResultSet resultsetDoctorID = preparedstatemenDoctorID.executeQuery();
		String DoctorID = resultsetDoctorID.getString(2);
		preparedstatemenDoctorID.close();
		// End of get Doctor ID 


        // Updating data to database "Appointments Table"
		preparedstatement = conn.prepareStatement("UPDATE Appointments SET" + 
				"  Update_By_Receptionist = ?, " +
				"  DoctorID = ?, " + 
				"  Doctor_Name = ?, " + 
				"  Date = ?, " + 
				"  Time = ?, " + 
				"  Service = ?  WHERE Id = "+IDNumber+"");
		preparedstatement.setString(1, appointmentDTO.getUpdate_By_Receptionist());
		preparedstatement.setString(2, DoctorID);
		preparedstatement.setString(3, appointmentDTO.getDoctor_Name());
		preparedstatement.setString(4, appointmentDTO.getDate());
		preparedstatement.setString(5, appointmentDTO.getTime());
		preparedstatement.setString(6, appointmentDTO.getService());
		
		preparedstatement.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Appointment updated successfuly");
        // End of Updating data to database "Appointments Table"
		
		//Close database
		preparedstatement.close();

	}
	catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	}
	/*End of Update Appointment method*/

	
	/*                                   *
     * End of Update appointment methods *
     *                                   */
	
	
	
	
	/*                            *
     * Cancel appointment methods *
     *                            */
	
	/*Check appointment ID if exist in database method*/
	public void cancelAppointmentDAO(AppointmentsDTO appointmentDTO)
	{
		try
		{

			preparedstatement = conn.prepareStatement("SELECT * FROM `Appointments` WHERE `AppointmentID`=?");
			preparedstatement.setString(1, appointmentDTO.getAppointmentID());
			ResultSet resultSet = preparedstatement.executeQuery();
			if(resultSet.next())
			{
				//Close database
				preparedstatement.close();
				
				// send data to "cancelAppointment" method
				cancelAppointment(appointmentDTO);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Appointment ID not exist, Please select another Appointment ID");
				
				//Close database
				preparedstatement.close();
				
			}
		
		}
		catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	/*End of Check appointment ID if exist in database method*/


	/*Cancel appointment method*/
	private void cancelAppointment(AppointmentsDTO appointmentDTO) 
	
	{

		try {
			preparedstatement = conn.prepareStatement("UPDATE Appointments SET" + 
					"  Cancelled_By_Receptionist = ?, " +
					"  Status = ? " + 
					"  WHERE AppointmentID = ? ");
			preparedstatement.setString(1, appointmentDTO.getCanceld_By_Receptionist());
			preparedstatement.setString(2, "Cancelled");
			preparedstatement.setString(3, appointmentDTO.getAppointmentID());

			// Confirm Delete
			int a = JOptionPane.showConfirmDialog(null,  "Are you sure you want to cancel this appointment? \n"
					+ " "+"Appointment ID : "+appointmentDTO.getAppointmentID()
			,"Confirm cancel appointment",JOptionPane.YES_NO_OPTION);
			
			if(a == 0)
			{
			
				preparedstatement.execute();
				JOptionPane.showMessageDialog(null, "Appointment cancelled successfuly");
				
				
				// Set data to "InvoicesDTO" object
				InvoicesDTO invoicesDTO = new InvoicesDTO();
				invoicesDTO.setAppointmentID(appointmentDTO.getAppointmentID());
				invoicesDTO.setCanceld_By_Receptionist(appointmentDTO.getCanceld_By_Receptionist());
				// End of Set data to "InvoicesDTO" object
				
				// Send data to "cancelInvoiceDAO"
				new InvoiceDAO().cancelInvoiceDAO(invoicesDTO);
				// End of Send data to "cancelInvoiceDAO"
				
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
	/*End of Cancel appointment method*/

	
	/*                                   *
     * End of Cancel appointment methods *
     *                                   */
	

}

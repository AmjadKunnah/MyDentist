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

/**
*
* @author amjad azim
*/

/*                                 *
 *                                 *
 * Data Access Object for Invoices *
 *                                 *
 *                                 */
public class InvoiceDAO {
	
	Connection conn = null;
    PreparedStatement preparedstatement= null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    public InvoiceDAO()
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
    
    /*                        *
     * Add new Invoice method *
     *                        */
    public void addInvoice(InvoicesDTO invoicesDTO)
    {
		
    	try
    	{
    	//Get patient name from Patients table using resultset
    	PreparedStatement preparedatatementPatientID;
		preparedatatementPatientID = conn.prepareStatement("SELECT * FROM `Patients` WHERE `PatientID`=?");
		preparedatatementPatientID.setString(1, invoicesDTO.getPatientID());
		ResultSet resultset = preparedatatementPatientID.executeQuery();
		String patientName = resultset.getString(3); 
		preparedatatementPatientID.close();
		//End get patient name from Patients table using resultset
		
		//Enter Invoice data to database
		preparedstatement = conn.prepareStatement("INSERT INTO `Invoices`(`InvoiceID`,"
		        + " `PatientID`, `Patient_Name`, `Doctor_Name`,"
		        + " `AppointmentID`, `Service` , `Service_Price` , `Date` , `Time`, `Add_By_Receptionist`, `Status`)"
		        + " VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setString(1, invoicesDTO.getInvoiceID());
		preparedstatement.setString(2, invoicesDTO.getPatientID());
		preparedstatement.setString(3, patientName);
		preparedstatement.setString(4, invoicesDTO.getDoctor_Name());
		preparedstatement.setString(5, invoicesDTO.getAppointmentID());
		preparedstatement.setString(6, invoicesDTO.getService());
		preparedstatement.setInt(7, invoicesDTO.getService_Price());
		preparedstatement.setString(8, invoicesDTO.getDate());
		preparedstatement.setString(9, invoicesDTO.getTime());
		preparedstatement.setString(10, invoicesDTO.getAdd_By_Receptionist());
		preparedstatement.setString(11, "Current");

		preparedstatement.execute();
		
		JOptionPane.showMessageDialog(null,"New Invoice Added successfuly");
		//End of Enter Invoice data to database
		
		//Close database
		preparedstatement.close();

    	}
    	catch(SQLException e)
    	{
            e.printStackTrace();

    	}
    }
    
    /*                               *
     * End of Add new Invoice method *
     *                               */
    
    
    
    
    /*                        *
     * Update Invoice methods *
     *                        */
    public void updateInvoice(InvoicesDTO invoicesDTO)
    {
    	try
    	{
    	
    		// Get Invoice ID number from database to use it with WHERE 
    		PreparedStatement preparedatatementIDNumber;
    		preparedatatementIDNumber = conn.prepareStatement("SELECT * FROM `Invoices` WHERE `AppointmentID`=?");
    		preparedatatementIDNumber.setString(1, invoicesDTO.getAppointmentID());
    		ResultSet resultsetIDNumber = preparedatatementIDNumber.executeQuery();
    		int IDNumber = resultsetIDNumber.getInt(1);
    		preparedatatementIDNumber.close();
    		// End Get Invoice ID number from database to use it with WHERE 
    		
    		
    		// Updating data to database "Invoices Table"
    		preparedstatement = conn.prepareStatement("UPDATE Invoices SET" + 
    				"  Updated_By_Receptionist = ?, " +
    				"  Doctor_Name = ?, " + 
    				"  Date = ?, " + 
    				"  Time = ?, " +
    				"  Service_Price = ?, " + 
    				"  Service = ?  WHERE Id = "+IDNumber+"");
    		preparedstatement.setString(1, invoicesDTO.getUpdated_By_Receptionist());
    		preparedstatement.setString(2, invoicesDTO.getDoctor_Name());
    		preparedstatement.setString(3, invoicesDTO.getDate());
    		preparedstatement.setString(4, invoicesDTO.getTime());
    		preparedstatement.setInt(5, invoicesDTO.getService_Price());
    		preparedstatement.setString(6, invoicesDTO.getService());
    		
    		preparedstatement.executeUpdate();
    		
    		JOptionPane.showMessageDialog(null, "Invoice updated successfuly");
            // End of Updating data to database "Invoices Table"
    		
    		//Close database
    		preparedstatement.close();
    	}
    	catch(SQLException e)
    	{
            e.printStackTrace();
    	}
    }
    /*                               *
     * End of Update Invoice methods *
     *                               */
    
    
    
    
    
    /*                       *
     * Cancel Invoice method *
     *                       */
    public void cancelInvoiceDAO(InvoicesDTO invoicesDTO)
    {
    	try
    	{
			preparedstatement = conn.prepareStatement("UPDATE Invoices SET" + 
					"  Cancelled_By_Receptionist = ?, " +
					"  Status = ? " + 
					"  WHERE AppointmentID = ? ");
			preparedstatement.setString(1, invoicesDTO.getCanceld_By_Receptionist());
			preparedstatement.setString(2, "Cancelled");
			preparedstatement.setString(3, invoicesDTO.getAppointmentID());

			preparedstatement.execute();
			JOptionPane.showMessageDialog(null, "Invoice cancelled successfuly");
				
			//Close database
			preparedstatement.close();

    	}
    	catch(SQLException e)
    	{
            e.printStackTrace();
    	}
    }
    /*                              *
     * End of Cancel Invoice method *
     *                              */

}

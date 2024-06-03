package mydentisten.dto;

/**
*
* @author amjad azim
*/

/*
 * Data Transfer Object (DTO) Class For Invoices
 */


public class InvoicesDTO {
	
	private String InvoiceID, PatientID, Patient_Name,
	Doctor_Name, AppointmentID, Service, Date, Time,
	Add_By_Receptionist, Updated_By_Receptionist, Canceld_By_Receptionist, Status;
	private int  Service_Price;
	
	public String getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		InvoiceID = invoiceID;
	}
	public String getPatientID() {
		return PatientID;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	public String getPatient_Name() {
		return Patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}
	public String getDoctor_Name() {
		return Doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}
	public String getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		AppointmentID = appointmentID;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getAdd_By_Receptionist() {
		return Add_By_Receptionist;
	}
	public void setAdd_By_Receptionist(String add_By_Receptionist) {
		Add_By_Receptionist = add_By_Receptionist;
	}
	public String getUpdated_By_Receptionist() {
		return Updated_By_Receptionist;
	}
	public void setUpdated_By_Receptionist(String updated_By_Receptionist) {
		Updated_By_Receptionist = updated_By_Receptionist;
	}
	public String getCanceld_By_Receptionist() {
		return Canceld_By_Receptionist;
	}
	public void setCanceld_By_Receptionist(String canceld_By_Receptionist) {
		Canceld_By_Receptionist = canceld_By_Receptionist;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getService_Price() {
		return Service_Price;
	}
	public void setService_Price(int service_Price) {
		Service_Price = service_Price;
	}


}

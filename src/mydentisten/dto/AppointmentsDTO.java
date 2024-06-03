package mydentisten.dto;

/**
*
* @author amjad azim
*/

/*
 * Data Transfer Object (DTO) Class For Appointments
 */


public class AppointmentsDTO {
	
	private String AppointmentID, PatientID, Patient_Name,
	DoctorID, Doctor_Name, Date, Time, Service, Service_Price
	, Receptionists_Name, Update_By_Receptionist, Canceld_By_Receptionist, Status, InvoiceID;

	public String getAppointmentID() {
		return AppointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		AppointmentID = appointmentID;
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

	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}

	public String getDoctor_Name() {
		return Doctor_Name;
	}

	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
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

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	public String getService_Price() {
		return Service_Price;
	}

	public void setService_Price(String service_Price) {
		Service_Price = service_Price;
	}

	public String getReceptionists_Name() {
		return Receptionists_Name;
	}

	public void setReceptionists_Name(String receptionists_Name) {
		Receptionists_Name = receptionists_Name;
	}

	public String getUpdate_By_Receptionist() {
		return Update_By_Receptionist;
	}

	public void setUpdate_By_Receptionist(String update_By_Receptionist) {
		Update_By_Receptionist = update_By_Receptionist;
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

	public String getInvoiceID() {
		return InvoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		InvoiceID = invoiceID;
	}

	

}

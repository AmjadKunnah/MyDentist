package mydentisten.dto;

/**
*
* @author amjad azim
*/

/*
 * Data Transfer Object (DTO) Class For Patients
 */


public class PatientsDTO {
	
	private String PatientID, Name, Gender, Birthday, Address, Added_By;
	
	public String getPatientID() {
		return PatientID;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAdded_By() {
		return Added_By;
	}
	public void setAdded_By(String added_By) {
		Added_By = added_By;
	}
	public int getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(int phoneNO) {
		PhoneNO = phoneNO;
	}
	private int PhoneNO;

}

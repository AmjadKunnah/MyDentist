package mydentisten.dto;

/**
*
* @author amjad azim
*/

/*
 * Data Transfer Object (DTO) Class For Users
 */

public class UsersDTO {
	
	private String UserID, Name, Last_Name, Username, Password,
	User_Type, Gender, Date_Of_Birth, Address,
	Added_By_Supervisor, Updated_By_Supervisor, 
	Added_Date, Added_Time, Last_Update_Date, Last_Update_Time;
	
	private int Phone_Number;
	
	

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUser_Type() {
		return User_Type;
	}

	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(int phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getAdded_By_Supervisor() {
		return Added_By_Supervisor;
	}

	public void setAdded_By_Supervisor(String added_By_Supervisor) {
		Added_By_Supervisor = added_By_Supervisor;
	}

	public String getUpdated_By_Supervisor() {
		return Updated_By_Supervisor;
	}

	public void setUpdated_By_Supervisor(String updated_By_Supervisor) {
		Updated_By_Supervisor = updated_By_Supervisor;
	}

	public String getAdded_Date() {
		return Added_Date;
	}

	public void setAdded_Date(String added_Date) {
		Added_Date = added_Date;
	}

	public String getAdded_Time() {
		return Added_Time;
	}

	public void setAdded_Time(String added_Time) {
		Added_Time = added_Time;
	}

	public String getLast_Update_Date() {
		return Last_Update_Date;
	}

	public void setLast_Update_Date(String last_Update_Date) {
		Last_Update_Date = last_Update_Date;
	}

	public String getLast_Update_Time() {
		return Last_Update_Time;
	}

	public void setLast_Update_Time(String last_Update_Time) {
		Last_Update_Time = last_Update_Time;
	}

	

}

package Windows;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientProfile {

	private String first_name;
	private String last_name;
	private String fathers_name;
	
	private String email;
	private String phone_number;
	private String password;
	
	public PatientProfile() {};
	
//////////////////////// INHERITED FROM REGISTRATION_DATA_CHECK

	
////////////////////////INHERITED FROM REGISTRATION_DATA_CHECK
	
	public PatientProfile(String first_name, String last_Name, String fathers_name, String email, String phone_number){
		this.first_name = first_name;
		this.last_name = last_Name;
		this.fathers_name = fathers_name;
		this.email = email;
		this.phone_number = phone_number;
	}
	
	public String get_full_name() {
		return this.first_name+" "+this.last_name+" "+this.fathers_name;
	}
	
	public void set_full_name(String first_name, String last_name, String fathers_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.fathers_name = fathers_name;
	}
	
	public boolean check_registration_data(String first_name, String last_name, String fathers_name, String email, String phone_number, String password) {
		return false;
	}
	
	public String login(String email, String password, Connection connection) {
		try 
		{
			PreparedStatement pstatement = connection.prepareStatement("SELECT password FROM patient WHERE email = ? or phone_number = ?");
			pstatement.setString(1,email); pstatement.setString(2,email);
			ResultSet rSet = pstatement.executeQuery();
			if(!rSet.next()) 
			{
				return "Incorrect login";
			}
			else 
			{
				PreparedStatement getPatientsNameAndContractNumber = connection.prepareStatement(
						"SELECT patient.patient_first_name, patient.patient_last_name, patient.patient_fathers_name, "
						+ "doctor.doctor_first_name, doctor.doctor_last_name, doctor.doctor_fathers_name FROM patient INNER JOIN doctor ON email = ? INNER JOIN ");
				if(password.compareTo(rSet.getString(1))==0){
					return "Correct";
				}
				else 
				{
					return "Incorrect password";
				}
			}
			
		} catch (SQLException e1) 
		{
			e1.getMessage();
			e1.printStackTrace();
		} 
		return "error";
	}
	
	public String get_patient_full_name(String email_or_phone, String password, Connection connection) throws SQLException {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT patient.patient_first_name, patient.patient_last_name, patient.patient_fathers_name "
				+ "FROM patient WHERE email = ? OR phone_number = ?"); 
			statement.setString(1, email_or_phone);statement.setString(2, email_or_phone);
			ResultSet rSet = statement.executeQuery();
			rSet.next();
			String patient_full_name = String.format("%s %s %s", rSet.getString(1), rSet.getString(2), rSet.getString(3));
			return patient_full_name;
		} catch (Exception e) {
			System.err.println("Error closing ResultSet: " + e.getMessage());
		}
		return "error";
	}
	public String get_doctor_full_name(int id, String email_or_phone, Connection connection) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT doctor.doctor_first_name, doctor.doctor_last_name, doctor.doctor_fathers_name "
					+ "FROM doctor d JOIN patient p ON d.iddoctor = p.family_doctor_id WHERE p.email = bs@gmail.com"); 
			statement.setInt(1, id);
			ResultSet rSet = statement.executeQuery();
			rSet.next();
			String doctor_full_name = String.format("%s %s %s", rSet.getString(1), rSet.getString(2), rSet.getString(3));
			return doctor_full_name;
		} catch (Exception e) {
			System.err.println("Error closing ResultSet: " + e.getMessage());
		}
		return "error";
	}
}

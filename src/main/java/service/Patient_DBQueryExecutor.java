package service;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.annotations.ParamDef;
import org.hibernate.query.Query;



public class Patient_DBQueryExecutor {
	
	private DB_Session_Manager session_Manager;
	
	public Patient_DBQueryExecutor() {};
	
//////////////////////// INHERITED FROM REGISTRATION_DATA_CHECK

	
////////////////////////INHERITED FROM REGISTRATION_DATA_CHECK
	
	public Patient_DBQueryExecutor(DB_Session_Manager session_Manager){
		this.session_Manager = session_Manager;
	}
	
	public String get_full_name() {
		try {
			Session session = session_Manager.getSession();
			session.beginTransaction();
		Query<String> query = session.createQuery("SELECT p.password FROM Patient WHERE p.email = :emailParam OR p.phoneNumber = :phoneParam", String.class);
		return this.first_name+" "+this.last_name+" "+this.fathers_name;
		}
		catch (HibernateException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	public void set_full_name(String first_name, String last_name, String fathers_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.fathers_name = fathers_name;
	}
	
	public boolean check_registration_data(String first_name, String last_name, String fathers_name, String email, String phone_number, String password) {
		return false;
	}
	
	public String login(String email, String password, Session session) {
		try 
		{
			session.beginTransaction();
			Query<String> checkLoginQuery = session.createQuery("SELECT password FROM Patient_Model WHERE email = :emailParam OR phone_number = :phoneParam", String.class);
			checkLoginQuery.setParameter( "emailParam", email); checkLoginQuery.setParameter( "phoneParam", email);
			String result = checkLoginQuery.uniqueResult();
			if(result == null) { return "Incorrect login";}
			else {
				if(result.compareTo( password )==0) {return "Correct";}
				else {return "Incorrect password";}
			}
		} catch (HibernateException e1) 
		{
			e1.getMessage(); e1.printStackTrace();
		} 
		return "error";	
//			PreparedStatement pstatement = connection.prepareStatement("SELECT password FROM patient WHERE email = ? or phone_number = ?");
//			pstatement.setString(1,email); pstatement.setString(2,email);
//			ResultSet rSet = pstatement.executeQuery();
//			if(!rSet.next()) 
//			{
//				return "Incorrect login";
//			}
//			else 
//			{
//				PreparedStatement getPatientsNameAndContractNumber = connection.prepareStatement(
//						"SELECT patient.patient_first_name, patient.patient_last_name, patient.patient_fathers_name, "
//						+ "doctor.doctor_first_name, doctor.doctor_last_name, doctor.doctor_fathers_name FROM patient INNER JOIN doctor ON email = ? INNER JOIN ");
//				if(password.compareTo(rSet.getString(1))==0){
//					return "Correct";
//				}
//				else 
//				{
//					return "Incorrect password";
//				}
//			}
			
		
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

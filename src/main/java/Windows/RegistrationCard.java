package Windows;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import org.hibernate.Session;
import org.hibernate.query.Query;

import service.DB_Session_Manager;


public class RegistrationCard extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private NavigationListener listener;
	
	private DB_Session_Manager session_manager;

	/**
	 * Create the panel.
	 */
	
	
	public RegistrationCard(NavigationListener listener, DB_Session_Manager session_manager) {
		
		this.listener=listener;
		this.session_manager = session_manager;
		
		JButton logout_btn = new JButton("Log out");/////////////////////////////////GO TO MAIN PAGE///////////////////////////////////
		logout_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.navigate_to("MainCard");
			}
		});
		
		logout_btn.setBounds(576, 28, 85, 21);
		add(logout_btn);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(43, 83, 85, 30);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(43, 148, 85, 30);
		add(lblLastName);
		
		JLabel lblFathersName = new JLabel("Fathers Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(43, 197, 108, 30);
		add(lblFathersName);
		
		JLabel lblEmailAdress = new JLabel("E-mail Adress");
		lblEmailAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAdress.setBounds(43, 254, 108, 30);
		add(lblEmailAdress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(43, 308, 108, 30);
		add(lblPhoneNumber);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword_1.setBounds(43, 361, 108, 30);
		add(lblPassword_1);
		
		JLabel lblExceptionDisplay = new JLabel("ExceptionDisplay");
		lblExceptionDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExceptionDisplay.setBounds(210, 417, 156, 24);
		add(lblExceptionDisplay);
		
		JLabel lblFNED = new JLabel("FNED");
		lblFNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFNED.setBounds(210, 114, 220, 24);
		add(lblFNED);
		
		JLabel lblLNED = new JLabel("LNED");
		lblLNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLNED.setBounds(210, 174, 253, 24);
		add(lblLNED);
		
		JLabel lblFatNED = new JLabel("FatNED");
		lblFatNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFatNED.setBounds(210, 223, 253, 24);
		add(lblFatNED);
		
		JLabel lblEAED = new JLabel("EAED");
		lblEAED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEAED.setBounds(210, 280, 253, 24);
		add(lblEAED);
		
		JLabel lblPNED = new JLabel("PNED");
		lblPNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPNED.setBounds(210, 333, 253, 24);
		add(lblPNED);
		
		JLabel lblPED = new JLabel("PED");
		lblPED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPED.setBounds(210, 391, 253, 24);
		add(lblPED);
		
		JTextArea FirstName_textArea = new JTextArea();
		FirstName_textArea.setBounds(210, 83, 154, 26);
		add(FirstName_textArea);
		
		JTextArea LastName_textArea = new JTextArea();
		LastName_textArea.setBounds(210, 148, 154, 26);
		add(LastName_textArea);
		
		JTextArea FathersName_textArea = new JTextArea();
		FathersName_textArea.setBounds(210, 197, 154, 26);
		add(FathersName_textArea);
		
		JTextArea EmailAdress_textArea = new JTextArea();
		EmailAdress_textArea.setBounds(210, 254, 154, 26);
		add(EmailAdress_textArea);
		
		JTextArea PhoneNumber_textArea = new JTextArea();
		PhoneNumber_textArea.setBounds(210, 308, 154, 26);
		add(PhoneNumber_textArea);
		
		JTextArea Password_textArea = new JTextArea();
		Password_textArea.setBounds(486, 331, 154, 26);
		add(Password_textArea);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(210, 365, 156, 27);
		add(passwordField);
		
		JPanel additional_panel_for_doctor = new JPanel();
		additional_panel_for_doctor.setBounds(440, 83, 239, 115);
		add(additional_panel_for_doctor);
		additional_panel_for_doctor.setLayout(null);
		additional_panel_for_doctor.setVisible(false);
		
		JLabel lbl_doctor_speciality = new JLabel("Speciality");
		lbl_doctor_speciality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_doctor_speciality.setBounds(0, 10, 79, 17);
		additional_panel_for_doctor.add(lbl_doctor_speciality);
		
		JLabel lbl_doctor_university = new JLabel("University");
		lbl_doctor_university.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_doctor_university.setBounds(0, 47, 79, 17);
		additional_panel_for_doctor.add(lbl_doctor_university);
		
		JCheckBox chckbx_RegisterAsDoctor = new JCheckBox("Register as doctor");
		chckbx_RegisterAsDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(additional_panel_for_doctor.isVisible()) {
					additional_panel_for_doctor.setVisible(false);
				}else {
					additional_panel_for_doctor.setVisible(true);
				}  
			}
		});
		
		JCheckBox chckbx_is_family_doctor = new JCheckBox("Family doctor");
		chckbx_is_family_doctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbx_is_family_doctor.setBounds(0, 88, 233, 21);
		additional_panel_for_doctor.add(chckbx_is_family_doctor);
		
		chckbx_RegisterAsDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbx_RegisterAsDoctor.setBounds(43, 28, 172, 21);
		add(chckbx_RegisterAsDoctor);

		String[] universities = {"Kyiv National University", "Lviv National University", "Kharkiv Ntional University"};
		JComboBox<String> comboBox_universities = new JComboBox<String>(universities);
		comboBox_universities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_universities.setBounds(86, 45, 143, 21);
		additional_panel_for_doctor.add(comboBox_universities);
		
		String[] specialities = {"Surgeon", "Dentist"};
		JComboBox<String> comboBox_Speciality = new JComboBox<String>(specialities);
		comboBox_Speciality.setBounds(86, 10, 143, 21);
		additional_panel_for_doctor.add(comboBox_Speciality);
		JButton Confirm_Registration_btn = new JButton("Confirm registration");//Confirm registration
		Confirm_Registration_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblFNED.setText("");lblLNED.setText("");lblFatNED.setText("");lblEAED.setText("");lblPNED.setText("");lblPED.setText("");
				
				/////Checking all REGISTRATION fields for empty ones////////
				
				if(FirstName_textArea.getText().length()==0 || LastName_textArea.getText().length()==0 || 
						FathersName_textArea.getText().length()==0 || EmailAdress_textArea.getText().length()==0 ||
						PhoneNumber_textArea.getText().length()==0) 
				{
					lblExceptionDisplay.setText("All options must be filled");
					return;
				}
				///////////////////////////////////////////////
				
				///////Checking for prohibited symbols in REGISTRATION fields//////
				else 
				{
					for(char c: FirstName_textArea.getText().toCharArray()) {
						if(!Character.isAlphabetic(c)) {
							lblFNED.setText("Use only letters");
							return;
						}
					}
					for(char c: LastName_textArea.getText().toCharArray()) {
						if(!Character.isAlphabetic(c)) {
							lblLNED.setText("Use only letters");
							return;
						}
					}
					for(char c: FathersName_textArea.getText().toCharArray()) {
						if(!Character.isAlphabetic(c)) {
							lblFatNED.setText("Use only letters");
							return;
						}
					}
					for(char c: PhoneNumber_textArea.getText().toCharArray()) {
						if(!Character.isDigit(c)) {
							lblPNED.setText("Use only numbers");
							return;
						}
					}
					if(!checkEmailPattern(EmailAdress_textArea.getText())) {
						lblEAED.setText("Inorrect symbols");
						return;
					}
				/////////////////////////////////////////////////////////////////
				
				//////////Checking for uniqueness in REGISTRATION fields///////////////////////////////////
				
					try {
						Session session = session_manager.getSession();
						session.beginTransaction();
						Query<String> query = session.createQuery("SELECT phone_number FROM patient WHERE phone_number=:phone_number", String.class);
						query.setParameter( "phone_number", PhoneNumber_textArea.getText());
						String result = query.uniqueResult();
						if(!result.equals( null )) {
							lblPNED.setText("Already exists");
							return;
						}
					} catch (Exception e2) {
						e2.getMessage();
						e2.printStackTrace();
					}
					try {
						Session session = session_manager.getSession();
						session.beginTransaction();
						Query<String> query = session.createQuery("SELECT email FROM patient WHERE email=:email", String.class);
						query.setParameter( "email",  EmailAdress_textArea.getText());
						String result = query.uniqueResult();
						if(!result.equals( null )) {
							lblEAED.setText("Already exists");
							return;
						}
						session.close();
						} catch (Exception e2) {
							e2.getMessage();
							e2.printStackTrace();
						}
					}
				
				///////////////INSERTING REGISTRATION DATA INTO DATABASE/////////////////
					String insert_patient_registration_data_query = "";
					if(chckbx_RegisterAsDoctor.isEnabled()) {
						System.out.println(chckbx_is_family_doctor.isEnabled());
						System.out.println(comboBox_universities.getSelectedItem());
						System.out.println(comboBox_Speciality.getSelectedItem());
						
						insert_patient_registration_data_query = String.format("INSERT INTO doctor (doctor_first_name, doctor_last_name, "
							+ "doctor_fathers_name, email, phone_number, password, doctor_university, doctor_specialty, is_family_doctor)"
							+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
							FirstName_textArea.getText(), LastName_textArea.getText(), FathersName_textArea.getText(), EmailAdress_textArea.getText(),
							PhoneNumber_textArea.getText(), new String(passwordField.getPassword()), comboBox_universities.getSelectedItem(), 
							comboBox_Speciality.getSelectedItem(), chckbx_is_family_doctor.isEnabled());
					}
					else {
						insert_patient_registration_data_query = String.format("INSERT INTO patient (patient_first_name, patient_last_name, "
							+ "patient_fathers_name, email, phone_number, password) "
							+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", 
							FirstName_textArea.getText(), LastName_textArea.getText(), FathersName_textArea.getText(), EmailAdress_textArea.getText(),
							PhoneNumber_textArea.getText(), new String(passwordField.getPassword()));
					}
					try {
						Session session = session_manager.getSession();
						session.beginTransaction();
						//Query<String> query = session.createQuery( insert_patient_registration_data_query )
						
//						Connection connection = DriverManager.getConnection(url, username, password);
//						Statement statement = connection.createStatement();
//						statement.executeUpdate(insert_patient_registration_data_query);
//						System.out.println(new String(passwordField.getPassword()));
//						connection.close();
					} catch (SQLException e2) {
						e2.getMessage();
						e2.printStackTrace();
					}
				}	
		});
		Confirm_Registration_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Confirm_Registration_btn.setBounds(514, 391, 165, 50);
		add(Confirm_Registration_btn);
	}
	
	
	public static boolean checkEmailPattern(String emailAddress) {
		String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
}

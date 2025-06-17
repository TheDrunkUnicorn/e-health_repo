package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.sql.*;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;

import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.swing.event.ChangeEvent;
//INSERT INTO patient (patient_first_name, patient_last_name, patient_fathers_name) VALUES ('testFirstName', 'testLastName', 'testFathersName');
//SELECT * FROM `e-health_schema`.patient;
//DELETE FROM patient WHERE patient_first_name=testFirstName;

public class Homepage implements NavigationListener{
	StringBuilder queryStringBuilder = new StringBuilder();

	String url = "jdbc:mysql://localhost:3306/e-health_schema";
	String username = "root";
	String password = "1111";
	//Connection connection = DriverManager.getConnection(url, username, password);//Creating connection
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_Appointment;
	private PatientProfile patientProfile = new PatientProfile();
	private JPanel panel = new JPanel();
	private CardLayout mainPageLayout = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		check_connection();
		
		//////IN THIS PLACE WERE OLD_CHECK_CONNECTION
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//////////////CREATING CARD LAYOUT///////////////////////////////////
		JPanel MainCard = new JPanel();
		//JPanel RegistrationCard = new JPanel();
		JPanel RegistrationCard = new RegistrationCard();
		//JPanel LoginCard = new JPanel();
		JPanel LoginCard = new LoginCard();
		JPanel PatientProfileCard = new JPanel();
		PatientProfileCard.setBackground(Color.WHITE);

		MainCard.setBackground(Color.cyan);
		RegistrationCard.setBackground(Color.magenta);
		panel.setBounds(0, 0, 689, 451);
		frame.getContentPane().add(panel);
		
		panel.setLayout(mainPageLayout);
		panel.add(MainCard, "MainCard");
		panel.add(RegistrationCard, "RegistrationCard");
		panel.add(LoginCard, "LoginCard");
		panel.add(PatientProfileCard, "PatientProfileCard");
		
		RegistrationCard.setLayout(null);
		LoginCard.setLayout(null);
////////////////CREATING CARD LAYOUT/////////////////////////////////////////////////////
		


//////////////////MAIN CARD ELEMENTS////////////////////////////////////
		JButton login_btn = new JButton("Log in ");////////////////////////////////GO TO LOGIN PAGE////////////////////////////
		login_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		login_btn.setBounds(259, 82, 126, 51);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)panel.getLayout();
				layout.show(panel, "LoginCard");
			}
		});
		MainCard.setLayout(null);
		MainCard.add(login_btn);
		//panel.add(PatientProfileCard, "PatientProfileCard");
////////////////////////MAIN CARD ELEMENTS//////////////////////////////////////////	

/////////////////////REGISTER CARD ELEMENTS///////////////////////
		JButton logout_btn = new JButton("Log out");/////////////////////////////////GO TO MAIN PAGE///////////////////////////////////
		logout_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		logout_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)panel.getLayout();
				layout.show(panel, "MainCard");
			}
		});
		
		logout_btn.setBounds(576, 28, 85, 21);
		RegistrationCard.add(logout_btn);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(43, 83, 85, 30);
		RegistrationCard.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(43, 148, 85, 30);
		RegistrationCard.add(lblLastName);
		
		JLabel lblFathersName = new JLabel("Fathers Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(43, 197, 108, 30);
		RegistrationCard.add(lblFathersName);
		
		JLabel lblEmailAdress = new JLabel("E-mail Adress");
		lblEmailAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAdress.setBounds(43, 254, 108, 30);
		RegistrationCard.add(lblEmailAdress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(43, 308, 108, 30);
		RegistrationCard.add(lblPhoneNumber);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword_1.setBounds(43, 361, 108, 30);
		RegistrationCard.add(lblPassword_1);
		
		JLabel lblExceptionDisplay = new JLabel("ExceptionDisplay");
		lblExceptionDisplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExceptionDisplay.setBounds(210, 417, 156, 24);
		RegistrationCard.add(lblExceptionDisplay);
		
		JLabel lblFNED = new JLabel("FNED");
		lblFNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFNED.setBounds(210, 114, 220, 24);
		RegistrationCard.add(lblFNED);
		
		JLabel lblLNED = new JLabel("LNED");
		lblLNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLNED.setBounds(210, 174, 253, 24);
		RegistrationCard.add(lblLNED);
		
		JLabel lblFatNED = new JLabel("FatNED");
		lblFatNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFatNED.setBounds(210, 223, 253, 24);
		RegistrationCard.add(lblFatNED);
		
		JLabel lblEAED = new JLabel("EAED");
		lblEAED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEAED.setBounds(210, 280, 253, 24);
		RegistrationCard.add(lblEAED);
		
		JLabel lblPNED = new JLabel("PNED");
		lblPNED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPNED.setBounds(210, 333, 253, 24);
		RegistrationCard.add(lblPNED);
		
		JLabel lblPED = new JLabel("PED");
		lblPED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPED.setBounds(210, 391, 253, 24);
		RegistrationCard.add(lblPED);
		
		JTextArea FirstName_textArea = new JTextArea();
		FirstName_textArea.setBounds(210, 83, 154, 26);
		RegistrationCard.add(FirstName_textArea);
		
		JTextArea LastName_textArea = new JTextArea();
		LastName_textArea.setBounds(210, 148, 154, 26);
		RegistrationCard.add(LastName_textArea);
		
		JTextArea FathersName_textArea = new JTextArea();
		FathersName_textArea.setBounds(210, 197, 154, 26);
		RegistrationCard.add(FathersName_textArea);
		
		JTextArea EmailAdress_textArea = new JTextArea();
		EmailAdress_textArea.setBounds(210, 254, 154, 26);
		RegistrationCard.add(EmailAdress_textArea);
		
		JTextArea PhoneNumber_textArea = new JTextArea();
		PhoneNumber_textArea.setBounds(210, 308, 154, 26);
		RegistrationCard.add(PhoneNumber_textArea);
		
		JTextArea Password_textArea = new JTextArea();
		Password_textArea.setBounds(486, 331, 154, 26);
		RegistrationCard.add(Password_textArea);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(210, 365, 156, 27);
		RegistrationCard.add(passwordField);
		
		JPanel additional_panel_for_doctor = new JPanel();
		additional_panel_for_doctor.setBounds(440, 83, 239, 115);
		RegistrationCard.add(additional_panel_for_doctor);
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
		RegistrationCard.add(chckbx_RegisterAsDoctor);

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
				lblFNED.setText("");
				lblLNED.setText("");
				lblFatNED.setText("");
				lblEAED.setText("");
				lblPNED.setText("");
				lblPED.setText("");
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
						Connection connection = DriverManager.getConnection(url, username, password);
						PreparedStatement pstatement = connection.prepareStatement("SELECT phone_number from patient WHERE phone_number=?");
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						Connection connection = DriverManager.getConnection(url, username, password);
						PreparedStatement pstatement = connection.prepareStatement("SELECT phone_number from patient WHERE phone_number=?");
						pstatement.setString(1, PhoneNumber_textArea.getText());
						ResultSet rSet = pstatement.executeQuery();
						if(rSet.next()==true) {
							lblPNED.setText("Already exists");
							return;
						}
						connection.close();
						} catch (Exception e2) {
							e2.getMessage();
							e2.printStackTrace();
						}
					
					try {
						Connection connection = DriverManager.getConnection(url, username, password);
						PreparedStatement pstatement = connection.prepareStatement("SELECT email from patient WHERE email=?");
						pstatement.setString(1, EmailAdress_textArea.getText());
						ResultSet rSet = pstatement.executeQuery();
						if(rSet.next()==true) {
							lblEAED.setText("Already exists");
							return;
						}
						connection.close();
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
						Connection connection = DriverManager.getConnection(url, username, password);
						Statement statement = connection.createStatement(); 
						statement.executeUpdate(insert_patient_registration_data_query);
						System.out.println(new String(passwordField.getPassword()));
						connection.close();
					} catch (SQLException e2) {
						e2.getMessage();
						e2.printStackTrace();
					}
				}	
		});
		Confirm_Registration_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Confirm_Registration_btn.setBounds(514, 391, 165, 50);
		RegistrationCard.add(Confirm_Registration_btn);
				
		
		
		
		
		
/////////////////////////PATIENT PROFILE CARD ELEMENTS/////////////////////////////
		PatientProfileCard.setLayout(new CardLayout(0, 0));
		
		//////////////////PROFILE_INFO PAGE ELEMENTS///////////////////////////////
		
		JPanel Profile_info = new JPanel();
		Profile_info.setBackground(Color.GRAY);
		PatientProfileCard.add(Profile_info, "Profile_info");
		Profile_info.setLayout(null);
		
		JLabel lblPP_full_name = new JLabel("Full name:");
		lblPP_full_name.setBounds(33, 45, 97, 17);
		lblPP_full_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Profile_info.add(lblPP_full_name);
		
		JLabel lblPP_patient_full_name = new JLabel("name");
		lblPP_patient_full_name.setBounds(209, 45, 272, 17);
		lblPP_patient_full_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Profile_info.add(lblPP_patient_full_name);
		
		JLabel lblPP_family_doctor_name = new JLabel("name");
		lblPP_family_doctor_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPP_family_doctor_name.setBounds(209, 84, 272, 17);
		Profile_info.add(lblPP_family_doctor_name);
		
		JLabel lblPP_family_doctor_full_name = new JLabel("Family doctor:");
		lblPP_family_doctor_full_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPP_family_doctor_full_name.setBounds(34, 84, 133, 17);
		Profile_info.add(lblPP_family_doctor_full_name);
		
		JLabel lblPP_doctor_name_error = new JLabel("if there is no name, you must set a contract number on a settings page");
		lblPP_doctor_name_error.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPP_doctor_name_error.setBounds(209, 111, 470, 33);
		Profile_info.add(lblPP_doctor_name_error);
		
		JLabel lblAppointment = new JLabel("Describe your complaints to make an apporintment");
		lblAppointment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAppointment.setBounds(33, 187, 375, 33);
		Profile_info.add(lblAppointment);
		
		textField_Appointment = new JTextField();
		textField_Appointment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Appointment.setBounds(34, 230, 609, 99);
		Profile_info.add(textField_Appointment);
		textField_Appointment.setColumns(10);
		
		JButton btnAppointment = new JButton("To appoint");
		btnAppointment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAppointment.setBounds(450, 361, 193, 33);
		Profile_info.add(btnAppointment);
		
		JButton btnLogOut_1 = new JButton("Log out");
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)panel.getLayout();
				layout.show(panel, "MainCard");
			}
		});
		
		btnLogOut_1.setBounds(33, 416, 97, 25);
		btnLogOut_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Profile_info.add(btnLogOut_1);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)PatientProfileCard.getLayout();
				layout.show(PatientProfileCard, "Settings");
			}
		});
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSettings.setBounds(151, 416, 97, 25);
		Profile_info.add(btnSettings);
		
		//////////////////PROFILE_INFO PAGE ELEMENTS///////////////////////////////
		
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////
		JPanel Settings = new JPanel();
		PatientProfileCard.add(Settings, "Settings");
		Settings.setLayout(null);
		
		JLabel lblSetDoctorContract = new JLabel("Set the number of your family doctor contract");
		lblSetDoctorContract.setBounds(134, 8, 290, 17);
		lblSetDoctorContract.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Settings.add(lblSetDoctorContract);
		
		textField = new JTextField();
		textField.setBounds(429, 5, 126, 23);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Settings.add(textField);
		textField.setColumns(10);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)PatientProfileCard.getLayout();
				layout.show(PatientProfileCard, "Profile_info");
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGoBack.setBounds(566, 408, 113, 33);
		Settings.add(btnGoBack);
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////

//////////////////PATIENT PROFILE CARD ELEMENTS//////////////////////////////////


//////////////////////LOGIN CARD ELEMENTS/////////////////////////////
//////////////////WERE///LOGIN CARD ELEMENTS///////////////////////////////////////////////
///
//////////////////WERE///LOGIN CARD ELEMENTS///////////////////////////////////////////////

	}

	public static boolean checkEmailPattern(String emailAddress) {
		String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
	
	public static void check_connection() {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("CONNECTION ESTABLISHED");
		}
		catch (Exception e) {
			System.err.println("CONNECTION FAILED" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session!=null) {session.close();};
			if (sessionFactory!=null ) {sessionFactory.close();};
			
		}
	}

	@Override
	public void navigate_to(String cardName) {
		// TODO Auto-generated method stub
	
	}
}

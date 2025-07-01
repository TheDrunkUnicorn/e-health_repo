package Windows;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PatientProfileCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private NavigationListener listener;
	private CardLayout layout = new CardLayout();

	/**
	 * Create the panel.
	 */
	public PatientProfileCard(NavigationListener listener) {
		
		this.listener = listener;
		
		setLayout(layout);
		
		//////////////////PROFILE_INFO PAGE ELEMENTS///////////////////////////////
		
		JPanel Profile_info = new JPanel();
		Profile_info.setBackground(Color.GRAY);
		add(Profile_info, "Profile_info");
		Profile_info.setLayout(null);
		
		JPanel Settings = new JPanel();
		add(Settings, "Settings");
		Settings.setLayout(null);
		
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
		
		JTextField textField_Appointment = new JTextField();
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
				listener.navigate_to( "MainCard" );
			}
		});
		
		btnLogOut_1.setBounds(33, 416, 97, 25);
		btnLogOut_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Profile_info.add(btnLogOut_1);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//listener.navigate_to( "Settings" );
				System.out.println("Settings button works");
				CardLayout layout1 = (CardLayout)PatientProfileCard.this.getLayout();
				layout1.show(PatientProfileCard.this, "Settings");
				listener.navigate_to("PatientProfileCard");
			}
		});
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSettings.setBounds(151, 416, 97, 25);
		Profile_info.add(btnSettings);
		
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////
		
		JLabel lblSetDoctorContract = new JLabel("Set the number of your family doctor contract");
		lblSetDoctorContract.setBounds(134, 8, 290, 17);
		lblSetDoctorContract.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Settings.add(lblSetDoctorContract);
		
		JTextField textField = new JTextField();
		textField.setBounds(429, 5, 126, 23);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Settings.add(textField);
		textField.setColumns(10);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)getLayout();
				layout.show(PatientProfileCard.this, "Profile_info");
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGoBack.setBounds(566, 408, 113, 33);
		Settings.add(btnGoBack);
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////
	}
	

}

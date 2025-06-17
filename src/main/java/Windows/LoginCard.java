package Windows;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class LoginCard extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private NavigationListener listener;

	/**
	 * Create the panel.
	 */
	public LoginCard(NavigationListener listener) {
		
		this.listener = listener;
		
		//////////////////////LOGIN CARD ELEMENTS/////////////////////////////
		
		setBackground(Color.pink);
		
		JTextArea Login_textArea_Email = new JTextArea();
		Login_textArea_Email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login_textArea_Email.setBounds(171, 64, 340, 47);
		add(Login_textArea_Email);
		
		JLabel lblEmail = new JLabel("Email or phone number");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(249, 10, 189, 47);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(300, 129, 76, 47);
		add(lblPassword);
		
		JLabel lblIncorrectData = new JLabel("");
		lblIncorrectData.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrectData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIncorrectData.setBounds(171, 354, 340, 33);
		add(lblIncorrectData);
		
		JTextArea Login_textArea_password = new JTextArea();
		Login_textArea_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login_textArea_password.setBounds(171, 186, 340, 47);
		add(Login_textArea_password);
		
		JButton btnRestorePassword = new JButton("Forgot password?");
		btnRestorePassword.setBounds(383, 243, 128, 21);
		add(btnRestorePassword);
		
		JButton btnLoginButton = new JButton("Log in");/////////////////LOGIN//////////////////////////
		btnLoginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String log_email = Login_textArea_Email.getText();
			String log_password = Login_textArea_password.getText();
			
			try {
				Connection connection = DriverManager.getConnection(url, username, password);
				String login_status = patientProfile.login(log_email, log_password, connection);
				lblIncorrectData.setText(login_status);
				if(login_status.equals("Correct")) {
					CardLayout layout = (CardLayout)panel.getLayout();
					layout.show(panel, "PatientProfileCard");
					lblPP_patient_full_name.setText(patientProfile.get_patient_full_name(log_email, log_password, connection));
					//lblPP_family_doctor_name.setText();
					connection.close();
				}
			} catch (SQLException e2) {
				e2.getMessage();
				e2.printStackTrace();
			}
		}
		});
		btnLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLoginButton.setBounds(171, 296, 340, 33);
		add(btnLoginButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout)panel.getLayout();
			layout.show(panel, "RegistrationCard");
		}
		});
		btnRegister.setBounds(171, 243, 85, 21);
		add(btnRegister);
		
		JCheckBox chckbxKeepLogged = new JCheckBox("Keep me logged in");
		chckbxKeepLogged.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxKeepLogged.setBounds(517, 304, 128, 21);
		chckbxKeepLogged.setBackground(Color.pink);
		add(chckbxKeepLogged);
		
		////////////////////////LOGIN CARD ELEMENTS///////////////////////////////////////////////

	}

}

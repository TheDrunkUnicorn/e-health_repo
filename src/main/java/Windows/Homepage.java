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

import service.DB_Session_Manager;

import javax.swing.event.ChangeEvent;
//INSERT INTO patient (patient_first_name, patient_last_name, patient_fathers_name) VALUES ('testFirstName', 'testLastName', 'testFathersName');
//SELECT * FROM `e-health_schema`.patient;
//DELETE FROM patient WHERE patient_first_name=testFirstName;

public class Homepage extends JFrame implements NavigationListener, DB_Session_Manager{
	StringBuilder queryStringBuilder = new StringBuilder();

	String url = "jdbc:mysql://localhost:3306/e-health_schema";
	String username = "root";
	String password = "1111";
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_Appointment;
	private JPanel panel = new JPanel();
	private CardLayout mainPageLayout = new CardLayout();
	JPanel MainCard = new JPanel();
	JPanel LoginCard = new LoginCard(this, this);
	JPanel RegistrationCard = new RegistrationCard(this,this);
	JPanel PatientProfileCard = new PatientProfileCard(this);
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
		
		//JPanel RegistrationCard = new JPanel();
		
		//JPanel LoginCard = new JPanel();
		
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
		
		//RegistrationCard.setLayout(null);
		//LoginCard.setLayout(null);
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
		
/////////////////////REGISTER CARD ELEMENTS///////////////////////	
		
/////////////////////////PATIENT PROFILE CARD ELEMENTS/////////////////////////////
		PatientProfileCard.setLayout(new CardLayout(0, 0));
		
		//////////////////PROFILE_INFO PAGE ELEMENTS///////////////////////////////
		
		//////////////////PROFILE_INFO PAGE ELEMENTS///////////////////////////////
		
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////
		
		//////////////////SETTINGS PAGE ELEMENTS///////////////////////////////////

//////////////////PATIENT PROFILE CARD ELEMENTS//////////////////////////////////


//////////////////////LOGIN CARD ELEMENTS/////////////////////////////
//////////////////WERE///LOGIN CARD ELEMENTS///////////////////////////////////////////////

//////////////////WERE///LOGIN CARD ELEMENTS///////////////////////////////////////////////

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

	@Override//NAVIGATION LISTENER
	public void navigate_to(String cardName) {
		// TODO Auto-generated method stub
		mainPageLayout.show(panel, cardName);
	}

	@Override//SESSION MANAGER
	public Session getSession() {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	@Override//SESSION MANAGER
	public void closeSession(Session session) {
		session.close();
	}
	
}

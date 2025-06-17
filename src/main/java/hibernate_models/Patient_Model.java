package hibernate_models;

import jakarta.persistence.*;

@Entity
@Table(name="patient")

public class Patient_Model {
	  @Id // Marks this field as the primary key
	  @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Hibernate to use auto-increment for ID
	  private Integer idpatient;
	  
	  @Column(name = "patient_first_name", nullable = false, length = 45)
	  private String patient_first_name;
	  
	  @Column(name = "patient_last_name", nullable = false, length = 45)
	  private String patient_last_name;
	  
	  @Column(name = "patient_fathers_name", nullable = false, length = 45)
	  private String patient_fathers_name;
	  
	  @Column(name = "email", nullable = false, unique = true, length = 45)
	  private String email;
	  
	  @Column(name = "phone_number", nullable = false, unique = true, length = 13)
	  private String phone_number;
	  
	  @Column(name = "password", nullable = false , unique = true, length = 16)
	  private String password;
	  
	  @ManyToOne // Вказує на зв'язок "багато до одного"
	  @JoinColumn(name = "family_doctor_id", referencedColumnName = "iddoctor") // Вказує на стовпець зовнішнього ключа
	  private Doctor_Model doctor;
	  
	  public Patient_Model() {
	  }
	  
	  public Patient_Model(String patient_first_name,String patient_last_name,String patient_fathers_name,String email,String phone_number,String password) {
		  this.patient_first_name = patient_first_name;
		  this.patient_last_name = patient_last_name;
		  this.patient_fathers_name = patient_fathers_name;
		  this.email = email;
		  this.phone_number = phone_number;
		  this.password = password;
	  }
	  
	  
	  public Integer getIdpatient() {
	        return idpatient;
	    }

	    public void setIdpatient(Integer idpatient) {
	        this.idpatient = idpatient;
	    }

	    public String getPatientFirstName() {
	        return patient_first_name;
	    }

	    public void setPatientFirstName(String patientFirstName) {
	        this.patient_first_name = patientFirstName;
	    }

	    public String getPatientLastName() {
	        return patient_last_name;
	    }

	    public void setPatientLastName(String patientLastName) {
	        this.patient_last_name = patientLastName;
	    }

	    public String getPatientFathersName() {
	        return patient_fathers_name;
	    }

	    public void setPatientFathersName(String patientFathersName) {
	        this.patient_fathers_name = patientFathersName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhoneNumber() {
	        return phone_number;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phone_number = phoneNumber;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Doctor_Model getFamilyDoctor() {
	        return doctor;
	    }

	    public void setFamilyDoctor(Doctor_Model familyDoctor) {
	        this.doctor = familyDoctor;
	    }
	  
	  
	  @Override
	  public String toString() {
	      return "Patient{" +
	             "idpatient=" + idpatient +
	             ", patientFirstName='" + patient_first_name + '\'' +
	             ", patientLastName='" + patient_last_name + '\'' +
	             ", patientFathersName='" + patient_fathers_name + '\'' +
	             ", email='" + email + '\'' +
	             ", phoneNumber='" + phone_number + '\'' +
	             ", password='" + password + '\'' +
	             ", familyDoctor=" + (doctor != null ? doctor.getIddoctor() : "null") + // Припустимо, у Doctor є getIddoctor()
	             '}';
	  }
	  
}

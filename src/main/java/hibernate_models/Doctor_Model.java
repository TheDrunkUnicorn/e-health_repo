package hibernate_models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name="doctor")


public class Doctor_Model {
	 @Id // Marks this field as the primary key
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer iddoctor;
	 
	 @Column(name = "doctor_first_name", nullable = false, length = 45)
	  private String doctor_first_name;
	  
	 @Column(name = "doctor_last_name", nullable = false, length = 45)
	 private String doctor_last_name;
	  
	 @Column(name = "doctor_fathers_name", nullable = false, length = 45)
	 private String doctor_fathers_name;
	 
	 @Column(name = "doctor_specialty", nullable = false, length = 45)
	 private String doctor_specialty;
	 
	 @Column(name = "doctor_university", nullable = false, length = 45)
	 private String doctor_university;
	 
	 @Column(name = "email", nullable = false, unique = true, length = 45)
	 private String email;
	 
	 @Column(name = "phone_number", nullable = false, unique = true, length = 13)
	 private String phone_number;
	  
	 @Column(name = "password", nullable = false, length = 16)
	 private String password;
	 
	 @Column(name = "is_family_doctor", nullable = false)
	 private Boolean is_family_doctor;
	 
	 @OneToMany(mappedBy = "doctor", // 'doctor' - це назва поля в класі Patient, яке посилається на Doctor
             cascade = CascadeType.ALL, // Приклади: PERSIST, MERGE, REMOVE, ALL
             fetch = FetchType.LAZY) // LAZY (за замовчуванням) або EAGER
	 private Set<Patient_Model> patients = new HashSet<>();
	 
	 public Doctor_Model() {
	 }
	  
	 public Doctor_Model(String doctor_first_name,String doctor_last_name,String doctor_fathers_name,String doctor_specialty, String doctor_university,
			 String email,String phone_number,String password) {
		 this.doctor_first_name = doctor_first_name;
		 this.doctor_last_name = doctor_last_name;
		 this.doctor_fathers_name = doctor_fathers_name;
		 this.doctor_specialty = doctor_specialty;
		 this.doctor_university = doctor_university;
		 this.email = email;
		 this.phone_number = phone_number;
		 this.password = password;
	 }
	 
	 public Integer getIddoctor() {
	        return iddoctor;
	    }

	    public void setIDdoctor(Integer iddoctor) {
	        this.iddoctor = iddoctor;
	    }

	    public String getDoctorFirstName() {
	        return doctor_first_name;
	    }

	    public void setDoctorFirstName(String doctorFirstName) {
	        this.doctor_first_name = doctorFirstName;
	    }

	    public String getDoctorLastName() {
	        return doctor_last_name;
	    }

	    public void setDoctorLastName(String doctorLastName) {
	        this.doctor_last_name = doctorLastName;
	    }

	    public String getDoctorFathersName() {
	        return doctor_fathers_name;
	    }

	    public void setDoctorFathersName(String doctorFathersName) {
	        this.doctor_fathers_name = doctorFathersName;
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
	    
	    public Boolean getIsFamilyDoctor() {
	    	return is_family_doctor;
	    }
	    
	    public void setIsFamilyDoctor(Boolean isFamilyDoctor) {
			this.is_family_doctor = isFamilyDoctor;
		}

//	    public Patient_Model[] geListOfPatient_Models() {
//	        return family_doctor;
//	    }
	  
}

package service;

import hibernate_models.Patient_Model;

//DATABASE INTERACTIONS WITH PATIENT
public interface Patient_Service {
	
	
	public void createPatient(Patient_Model patient_Model);
	
	public void updatePatient(Patient_Model patient_Model);
	
	public void deletePatient(Patient_Model patient_Model);

}

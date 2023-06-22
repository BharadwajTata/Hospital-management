package com.example.demohospital.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demohospital.Controller.PatientController;
import com.example.demohospital.Patient.Patient;
import com.example.demohospital.Repository.IPatientRepository;
import com.example.demohospital.exception.PatientAlreadyExistException;

@Service
public class PatientService {
	static Logger log = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	IPatientRepository patientRepo;
	
	public String addPatient(Patient patient) throws PatientAlreadyExistException {
		log.trace("Entry add student method");
		    Optional<Patient> patientOp= patientRepo.findById(patient.getsNO());
		    if(patientOp.isPresent()) {
		    	throw new PatientAlreadyExistException("Patient alredy exist at this serial number"+patient.getsNO());
		    }else {
		    patientRepo.save(patient);
		    }
		    log.trace("Entry add student method");
		return "Patient added";
		
	}

}

package com.example.demohospital.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demohospital.Patient.Patient;
import com.example.demohospital.Repository.IPatientRepository;
import com.example.demohospital.Service.PatientService;
import com.example.demohospital.exception.PatientAlreadyExistException;
import com.example.demohospital.exception.PatientNotFoundException;

@RestController
@RequestMapping("/patient")
public class PatientController {
	static Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	PatientService patientService;
	
	
	@Autowired
	IPatientRepository patientRepo;
	
	
	@PostMapping("/add")
	public String addPatient(@RequestBody Patient patient) throws PatientAlreadyExistException {
		log.trace("Entry into addPatient Method");
		String message =patientService.addPatient(patient);
		log.trace("Entry into addPatient Method");
		return message;
		
	}
	@GetMapping("/get")
	public List<Patient> getPatient() {
		
		return patientRepo.findAll();
		
		}
	@PutMapping("/update/{sNO}")
	public String updatePatient(@PathVariable("sNO")int sNO) {
		      Optional<Patient> patientOp =patientRepo.findById(sNO);
		      if(patientOp.isPresent()) {
		    	  Patient patient = patientOp.get();
		    	  patient.setAddress("Mumbai");
		    	  patientRepo.save(patient);
		    	  return "patient updated";
		      }
		     return "patient not found";
	}
	@DeleteMapping("/delete/{sNO}")
	public String deletePatient(@PathVariable("sNO")int sNO) throws PatientNotFoundException {
		      Optional<Patient> patientOp =patientRepo.findById(sNO);
		      if(patientOp.isPresent()) {
		    	 patientRepo.deleteById(sNO);
		    	  return "patient deleted";
		      }else {
		    	throw new PatientNotFoundException("patient is not found for id "+sNO);   
		      }
		    
	}

}

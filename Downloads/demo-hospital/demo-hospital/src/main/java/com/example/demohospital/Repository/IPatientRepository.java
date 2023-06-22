package com.example.demohospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demohospital.Patient.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

}

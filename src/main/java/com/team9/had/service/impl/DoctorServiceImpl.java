package com.team9.had.service.impl;

import com.team9.had.entity.Citizen;
import com.team9.had.entity.Doctor;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.repository.DoctorRepository;
import com.team9.had.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public boolean addDoctor(Doctor doctor) {
        try{
            if(citizenRepository.findById(doctor.getCitizen().getId())!=null && doctorRepository.findByCitizen_Id(doctor.getCitizen().getId())==null) {
                Citizen citizen = citizenRepository.findById(doctor.getCitizen().getId()).get();
                System.out.println("citizen = " + citizen);
                String creds = "DOC"+citizen.getId();
                doctor.setLoginId(creds);
                doctor.setPassword(creds);
                doctorRepository.save(doctor);
                return true;
            }
            else return false;
        }
        catch(Exception e) {
            System.out.println("exception = " + e);
            return false;
        }
    }

//    @Override
//    public boolean addDoctors(List<Doctor> doctors) {
//        try{
//            doctorRepository.saveAll(doctors);
//            return true;
//        }
//        catch(Exception e){
//            System.out.println("exception = " + e);
//            return false;
//        }
//    }
}

package com.team9.had.service.receptionist;

import com.team9.had.entity.HealthRecord;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.repository.DoctorRepository;
import com.team9.had.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class ServiceForReceptionistImpl implements ServiceForReceptionist{

    @Autowired
    private HealthRecordRepository healthRecordRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Serializable createHealthRecord(HealthRecord healthRecord) {
        try{
//            Doctor doctor = doctorRepository.findById(healthRecord.getDoctor().getLoginId()).get();
//            healthRecord.setDoctor(doctor);
//            Citizen citizen = citizenRepository.findById(healthRecord.getCitizen().getId()).get();
//            healthRecord.setCitizen(citizen);
            healthRecord.setCreationDate(Date.valueOf(LocalDateTime.now().toLocalDate()));
            healthRecordRepository.save(healthRecord);
            return true;
        }
        catch(Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }
}

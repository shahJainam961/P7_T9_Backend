package com.team9.had.service.impl;

import com.team9.had.entity.Citizen;
import com.team9.had.entity.FieldHealthWorker;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.repository.FieldHealthWorkerRepository;
import com.team9.had.service.FieldHealthWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldHealthWorkerServiceImpl implements FieldHealthWorkerService {

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private FieldHealthWorkerRepository fieldHealthWorkerRepository;
    @Override
    public boolean addFhw(FieldHealthWorker fieldHealthWorker) {
        try{
            if(citizenRepository.findById(fieldHealthWorker.getCitizen().getId())!=null && fieldHealthWorkerRepository.findByCitizen_Id(fieldHealthWorker.getCitizen().getId())==null) {
                Citizen citizen = citizenRepository.findById(fieldHealthWorker.getCitizen().getId()).get();
                System.out.println("citizen = " + citizen);
                String creds = "FHW"+citizen.getId();
                fieldHealthWorker.setLoginId(creds);
                fieldHealthWorker.setPassword(creds);
                fieldHealthWorkerRepository.save(fieldHealthWorker);
                return true;
            }
            else return false;
        }
        catch(Exception e) {
            System.out.println("exception = " + e);
            return false;
        }
    }
}

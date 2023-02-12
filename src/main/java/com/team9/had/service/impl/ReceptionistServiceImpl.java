package com.team9.had.service.impl;

import com.team9.had.entity.Citizen;
import com.team9.had.entity.Receptionist;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.repository.ReceptionistRepository;
import com.team9.had.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistServiceImpl implements ReceptionistService {

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Override
    public boolean addReceptionist(Receptionist receptionist) {
        try{
            if(citizenRepository.findById(receptionist.getCitizen().getId())!=null && receptionistRepository.findByCitizen_Id(receptionist.getCitizen().getId())==null) {
                Citizen citizen = citizenRepository.findById(receptionist.getCitizen().getId()).get();
                System.out.println("citizen = " + citizen);
                String creds = "REC"+citizen.getId();
                receptionist.setLoginId(creds);
                receptionist.setPassword(creds);
                receptionistRepository.save(receptionist);
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

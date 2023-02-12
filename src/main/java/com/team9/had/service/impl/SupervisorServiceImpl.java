package com.team9.had.service.impl;

import com.team9.had.entity.Citizen;
import com.team9.had.entity.Supervisor;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.repository.SupervisorRepository;
import com.team9.had.service.CitizenService;
import com.team9.had.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;
    @Override
    public boolean addSupervisor(Supervisor supervisor) {
        try{
            if(citizenRepository.findById(supervisor.getCitizen().getId())!=null && supervisorRepository.findByCitizen_Id(supervisor.getCitizen().getId())==null) {
                Citizen citizen = citizenRepository.findById(supervisor.getCitizen().getId()).get();
                String creds = "SUP"+citizen.getId();
                supervisor.setLoginId(creds);
                supervisor.setPassword(creds);
                supervisorRepository.save(supervisor);
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

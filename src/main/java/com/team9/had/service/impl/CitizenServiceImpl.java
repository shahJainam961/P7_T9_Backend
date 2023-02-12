package com.team9.had.service.impl;

import com.team9.had.controller.CitizenController;
import com.team9.had.entity.Citizen;
import com.team9.had.repository.CitizenRepository;
import com.team9.had.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public boolean addCitizen(Citizen citizen) {
        try{
            citizenRepository.save(citizen);
            return true;
        }
        catch(Exception e){
            System.out.println("exception = " + e);
            return false;
        }
    }

    @Override
    public boolean addCitizens(List<Citizen> citizens) {
        try{
            citizenRepository.saveAll(citizens);
            return true;
        }
        catch(Exception e){
            System.out.println("exception = " + e);
            return false;
        }
    }
}

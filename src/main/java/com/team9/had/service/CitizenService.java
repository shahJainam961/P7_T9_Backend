package com.team9.had.service;

import com.team9.had.entity.Citizen;

import java.util.List;


public interface CitizenService {
    boolean addCitizen(Citizen citizen);

    boolean addCitizens(List<Citizen> citizen);
}

package com.team9.had.controller;

import com.team9.had.entity.Citizen;
import com.team9.had.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping("/add")
    public ResponseEntity<String> addCitizen(@RequestBody Citizen citizen){
        if(citizenService.addCitizen(citizen)){
            return new ResponseEntity<>("Citizen added Successfully!!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
    }

    @PostMapping("/add/all")
    public ResponseEntity<String> addCitizens(@RequestBody List<Citizen> citizens){
        if(citizenService.addCitizens(citizens)){
            return new ResponseEntity<>("Citizens added Successfully!!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
    }

}

package com.team9.had.controller;

import com.team9.had.entity.Receptionist;
import com.team9.had.entity.Supervisor;
import com.team9.had.service.ReceptionistService;
import com.team9.had.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;
    @PostMapping("/add")
    public ResponseEntity<String> addSupervisor(@RequestBody Supervisor supervisor){
        if(supervisorService.addSupervisor(supervisor)){
            return new ResponseEntity<>("Supervisor added Successfully!!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
    }
}

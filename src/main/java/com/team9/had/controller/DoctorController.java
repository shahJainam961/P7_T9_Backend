package com.team9.had.controller;

import com.team9.had.entity.Doctor;
import com.team9.had.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor){
        if(doctorService.addDoctor(doctor)){
            return new ResponseEntity<>("Doctor added Successfully!!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
    }

//    @PostMapping("/add/all")
//    public ResponseEntity<String> addDoctors(@RequestBody List<Doctor> doctors){
//        System.out.println("doctors = " + doctors);
//        if(doctorService.addDoctors(doctors)){
//            return new ResponseEntity<>("Doctors added Successfully!!", HttpStatus.OK);
//        }
//        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
//    }
//
//    @GetMapping("/hello")
//    public ResponseEntity<String> hello(){
//        return new ResponseEntity<>("helloo!!", HttpStatus.OK);
//    }
}

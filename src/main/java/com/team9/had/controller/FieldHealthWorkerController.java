package com.team9.had.controller;

import com.team9.had.entity.FieldHealthWorker;
import com.team9.had.service.FieldHealthWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fhw")
public class FieldHealthWorkerController {

    @Autowired
    private FieldHealthWorkerService fieldHealthWorkerService;

    @PostMapping("/add")
    public ResponseEntity<String> addFhw(@RequestBody FieldHealthWorker fieldHealthWorker){
        if(fieldHealthWorkerService.addFhw(fieldHealthWorker)){
            return new ResponseEntity<>("FHW added Successfully!!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Something went wrong!!", HttpStatusCode.valueOf(412));
    }

}

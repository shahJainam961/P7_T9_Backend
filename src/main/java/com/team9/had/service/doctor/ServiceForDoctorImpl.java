package com.team9.had.service.doctor;

import com.team9.had.Constant;
import com.team9.had.entity.HealthRecord;
import com.team9.had.repository.HealthRecordRepository;
import com.team9.had.service.login.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@Service
public class ServiceForDoctorImpl implements ServiceForDoctor{

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Override
    public Serializable getNewHealthRecords(LoginModel loginModel) {
        ArrayList<Object> obj = new ArrayList<>();

        ArrayList<HealthRecord> healthRecordList =
                healthRecordRepository
                .findByDoctor_LoginIdAndStatusAndCreationDateOrderByCreationTime(
                        loginModel.getLoginId(), Constant.HEALTH_RECORD_NOT_ASSESSED,
                        new Date(System.currentTimeMillis())
                );
        if(healthRecordList==null) return null;
        obj.add(healthRecordList);
        return obj;
    }

}

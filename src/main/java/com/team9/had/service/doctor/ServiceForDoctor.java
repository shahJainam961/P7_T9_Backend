package com.team9.had.service.doctor;

import com.team9.had.service.login.LoginModel;

import java.io.Serializable;

public interface ServiceForDoctor {
    Serializable getNewHealthRecords(LoginModel loginModel);
}

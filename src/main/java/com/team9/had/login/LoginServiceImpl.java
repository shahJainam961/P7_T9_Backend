package com.team9.had.login;

import com.team9.had.entity.Doctor;
import com.team9.had.entity.FieldHealthWorker;
import com.team9.had.entity.Receptionist;
import com.team9.had.entity.Supervisor;
import com.team9.had.repository.DoctorRepository;
import com.team9.had.repository.FieldHealthWorkerRepository;
import com.team9.had.repository.ReceptionistRepository;
import com.team9.had.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private ReceptionistRepository receptionistRepository;
    @Autowired
    private FieldHealthWorkerRepository fieldHealthWorkerRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public boolean loggingIn(LoginModel loginModel) {
        String loginId = loginModel.getLoginId();
        String password = loginModel.getPassword();
        if(validLoginId(loginId)){
            if(loginId.startsWith("DOC")){
               List<Doctor> doctors = doctorRepository.findById(loginId).stream().toList();
               if(doctors.size()==0) return false;
               else{
                   if(doctors.get(0).getPassword().equals(password)) return true;
                   else return false;
               }
            }
            else if(loginId.startsWith("REC")){
                List<Receptionist> receptionists = receptionistRepository.findById(loginId).stream().toList();
                if(receptionists.size()==0) return false;
                else{
                    if(receptionists.get(0).getPassword().equals(password)) return true;
                    else return false;
                }
            }
            else if(loginId.startsWith("SUP")){
                List<Supervisor> supervisors = supervisorRepository.findById(loginId).stream().toList();
                if(supervisors.size()==0) return false;
                else{
                    if(supervisors.get(0).getPassword().equals(password)) return true;
                    else return false;
                }
            }
            else if(loginId.startsWith("FHW")){
                List<FieldHealthWorker> fieldHealthWorkers = fieldHealthWorkerRepository.findById(loginId).stream().toList();
                if(fieldHealthWorkers.size()==0) return false;
                else{
                    if(fieldHealthWorkers.get(0).getPassword().equals(password)) return true;
                    else return false;
                }
            }
            else return false;
        }
        else return false;
    }

    private boolean validLoginId(String loginId) {
        if(loginId.length()<=3) return false;
        if(!loginId.startsWith("DOC") && !loginId.startsWith("REC")
                && !loginId.startsWith("SUP") && !loginId.startsWith("FHW")) return false;
        return true;
    }
}

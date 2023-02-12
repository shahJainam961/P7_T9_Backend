package com.team9.had.repository;

import com.team9.had.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    public Doctor findByCitizen_Id(Integer id);
}

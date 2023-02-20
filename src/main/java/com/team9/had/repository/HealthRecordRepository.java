package com.team9.had.repository;

import com.team9.had.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
    ArrayList<HealthRecord> findByDoctor_LoginIdAndStatusAndCreationDateOrderByCreationTime(
            String loginId, Integer status, Date creationDate
    );
}

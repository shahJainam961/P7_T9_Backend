package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowUp {

    @Id
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String instruction;

    private Double bodyTemperature;

    private Double pulseRate;

    private Double respirationRate;

    private Double bloodPressure;

    @ManyToOne
    @JoinColumn(name = "health_record_id", nullable = false)
    private HealthRecord healthRecord;

    @ManyToOne
    @JoinColumn(name = "supervisor_login_id", nullable = false)
    private Supervisor supervisor;

    @ManyToOne
    @JoinColumn(name = "field_health_worker_login_id")
    private FieldHealthWorker fieldHealthWorker;

}

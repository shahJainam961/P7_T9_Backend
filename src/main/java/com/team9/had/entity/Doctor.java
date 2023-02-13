package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor{


    @Id
    @Column(name = "loginId", unique = true)
    private String loginId;

    @OneToOne
    @JoinColumn(name = "citizen_id", unique = true, nullable = false)
    private Citizen citizen;

    @Column(name = "licenseId", unique = true, nullable = false)
    private String licenseId;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<HealthRecord> healthRecordList;

}

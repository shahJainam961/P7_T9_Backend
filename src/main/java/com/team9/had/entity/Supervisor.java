package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supervisor{

    @Id
    @Column(name = "loginId", unique = true)
    private String loginId;

    @OneToOne
    @JoinColumn(name = "citizen_id", unique = true, nullable = false)
    private Citizen citizen;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "assignedPincode", nullable = false)
    private String assignedPincode;

}

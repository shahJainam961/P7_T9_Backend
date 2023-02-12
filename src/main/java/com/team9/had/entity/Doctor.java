package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor{


    @Id
    @Column(name = "loginId", unique = true)
    private String loginId;
    @OneToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", unique = true)
    private Citizen citizen;
    @Column(name = "licenseId", unique = true)
    private String licenseId;
    @Column(name = "password")
    private String password;
}

package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receptionist{


    @Id
    @Column(name = "loginId", unique = true)
    private String loginId;

    @OneToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", unique = true)
    private Citizen citizen;

    @Column(name = "password")
    private String password;
}

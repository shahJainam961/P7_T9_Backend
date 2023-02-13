package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street1", nullable = false)
    private String street1;

    @Column(name = "street2")
    private String street2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    @Column(name = "contactNo", nullable = false, unique = true)
    private String contactNo;

    @OneToMany(mappedBy = "hospital")
    private List<Receptionist> receptionistList;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctorList;

}

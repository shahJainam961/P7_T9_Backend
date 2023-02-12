package com.team9.had.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fname", nullable = false)
    private String fname; // First Name

    @Column(name = "lname", nullable = false)
    String lname; // Last Name

    @Column(name = "gender", nullable = false)
    private char gender; // m-Male, f-Female, o-Other

    @Column(name = "dob", nullable = false)
    private Date dob;    // Date of Birth

    @Column(name = "age", nullable = false)
    private Integer age; // Age

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

    @Column(name = "mobileNo", nullable = false)
    private String mobileNo;

    @Column(name = "govId", unique = true, nullable = false)
    private String govId;

}

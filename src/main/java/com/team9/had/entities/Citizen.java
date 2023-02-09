package com.team9.had.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {

    @Id
    Integer id;
    String fname; // First Name
    String lname; // Last Name
    char gender; // m-Male, f-Female, o-Other
    Date dob;    // Date of Birth
    Integer age; // Age
    String street1;
    String street2;
    String city;
    String state;
    String pincode;
    String mobileNo;
    String govId;

}

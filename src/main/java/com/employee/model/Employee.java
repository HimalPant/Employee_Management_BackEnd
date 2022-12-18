package com.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_Name")
    @Size(min = 2, max = 15, message
            = "First name must be between 5 and 10 characters")
    private String firstName;

    @Column(name = "Last_Name")
    @Size(min = 2, max = 15, message
            = "Last name must be between 5 and 10 characters")
    private String lastName;

    @Column(name = "Email_Id")
    @Email(message = "Email should be valid")
    private String emailId;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    @Column(name = "employee_age")
    private Integer empAge;

    @AssertTrue
    private boolean working;

}

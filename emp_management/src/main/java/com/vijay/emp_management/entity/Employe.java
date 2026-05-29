package com.vijay.emp_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @NotBlank(message = "Name Cannot Be Empty")
    String name;

    @Email(message = "Invalid format")
    @NotBlank(message = "Email Cannot Be Empty")
    String email;

    @NotBlank(message = "Designation Cannot Be Empty")
    String designation;

    @Positive(message = "Salary Cannot Be Empty")
    String salary;


    public Employe() {
    }

    public Employe(String name, Long id, String email, String designation, String salary) {
        this.name = name;
        Id = id;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

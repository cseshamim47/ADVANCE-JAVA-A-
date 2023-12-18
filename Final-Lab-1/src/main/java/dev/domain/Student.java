package dev.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Student {



    @NotNull
    @NumberFormat
    private String sid;

    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Email(message = "Incorrect email format")
    @Size(max = 100)
    private String email;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @NotNull
    private Gender gender;

    @Size(max = 10)
    private String quota = "N/A";

    @NotNull
    @Size(max = 100)
    private String country = "Bangladeshi";

    public Student() {
    }

    public Student(String id, String name, String email, LocalDate dateOfBirth, Gender gender, String quota, String country) {
        this.sid = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        System.out.println(quota);
        if(quota != null) this.quota = quota;
        this.country = country;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        if(quota != null) this.quota = quota;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", quota='" + quota + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

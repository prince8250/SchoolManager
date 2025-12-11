package org.schoolmanager.schoolmanager.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    @Id
    private String studentId;

    @Column(name = "First_Name",
            nullable = false
    )
    private String firstName;

    @Column(name = "Middle_Name",
            nullable = true
    )
    private String middleName;

    @Column(name = "Last_Name",
            nullable = false
    )
    private String lastName;

    @Column(name = "Email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(name = "Date_of_Birth",
            nullable = false
    )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name = "Gender",
            nullable = false
    )
    private String gender;

    @Column(name = "Address",
            nullable = true
    )
    private String address;

    @Column(name = "Phone_Number",
            nullable = false,
            unique = true
    )
    private String phoneNumber;

    @Column(name = "Entry_Year",
            nullable = false
    )
    private Integer entryYear = LocalDate.now().getYear();

    @Column(name = "Current_Year",
            nullable = false
    )
    private Integer currentYear;

    @Column(name = "Age")
    @Transient
    private Integer age;

    public Student(String studentId, String firstName, String middleName, String lastName, String email, LocalDate dateOfBirth, String gender, String address, String phoneNumber, Integer entryYear, Integer currentYear, Integer age, String programme) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.entryYear = entryYear;
        this.currentYear = currentYear;
        this.age = age;
        this.programme = programme;
    }

    public Student() {
    }

    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Column(name = "Programme",
            nullable = false
    )
    private String programme;

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEntryYear(Integer entryYear) {
        this.entryYear = entryYear;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Integer getEntryYear() {
        return this.entryYear;
    }

    public Integer getCurrentYear() {
        return this.currentYear;
    }

    public String getProgramme() {
        return this.programme;
    }
}


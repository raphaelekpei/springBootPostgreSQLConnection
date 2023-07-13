package com.raphael.springbootpostgresqlconnection.model;


import com.raphael.springbootpostgresqlconnection.constant.Gender;
import com.raphael.springbootpostgresqlconnection.constant.UserRole;
import com.raphael.springbootpostgresqlconnection.constant.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private String userId;
    private String firstname;
    private String lastname;
    private String username;

    private String emailAddress;
    private String password;
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;
    private LocalDate dateOfBirth;

    private Integer age;

    // Get day of birth in String from date of birth
    @Transient
    private MultipartFile image;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    private String created_by;
    private String updated_by;
    private String deleted_by;

    public User(String firstname, String lastname, String username, String emailAddress, String password, String phoneNumber, Address address, Gender gender, String nationality, LocalDate dateOfBirth, MultipartFile image, UserRole userRole, UserStatus userStatus, String created_by, String updated_by, String deleted_by) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears(); // Age gotten from date of birth
        this.image = image;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.deleted_at = LocalDateTime.now();
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.deleted_by = deleted_by;
    }


}

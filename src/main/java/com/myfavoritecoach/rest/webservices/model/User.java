package com.myfavoritecoach.rest.webservices.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identificationNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    private String gender;

    private Integer age;

    private Integer weight;

    private Integer height;

    private String profilePicture;

    private boolean active;

}

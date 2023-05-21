package com.myfavoritecoach.rest.webservices.dto;

import com.myfavoritecoach.rest.webservices.model.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ClientDto {

    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
    private Integer age;
    private float weight;
    private float height;
    private String profilePicture;

}

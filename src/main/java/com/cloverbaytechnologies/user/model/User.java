package com.cloverbaytechnologies.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    //    @Email(message = "Please enter a valid email address")
    private String email;

    private String phoneNumber;

    private boolean userState;

    private String companyName;

    public User(String firstname, String lastname, String email, String phoneNumber, boolean userState, String companyName) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userState = userState;
        this.companyName = companyName;
    }
}

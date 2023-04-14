package com.cloverbaytechnologies.user.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String fullName;

    private String emailAddress;

    private String phone;

    private boolean userState;

    private String companyName;
}

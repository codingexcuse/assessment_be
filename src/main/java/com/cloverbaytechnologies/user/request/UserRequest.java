package com.cloverbaytechnologies.user.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class UserRequest {
    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @Email
    @NotNull
    @Size(max = 50)
    private String email;

    @Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
    @NotNull
    private String phoneNumber;

    @NotNull
    private boolean userState;

    @NotNull
    @Size(min = 1, max = 50)
    private String companyName;
}

package com.doctransfer.userservice.model.request;

import com.doctransfer.userservice.model.User;

import javax.validation.constraints.NotNull;

public class CreateUserRequest {
    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    public String middleName;

    public CreateUserRequest(
            String firstName,
            String lastName,
            String middleName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User toCoreModel() {
        return new User(
                this.firstName,
                this.lastName,
                this.middleName
        );
    }
}

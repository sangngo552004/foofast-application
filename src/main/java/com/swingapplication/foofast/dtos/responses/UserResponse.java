package com.swingapplication.foofast.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private int is_active;
    private int role_id;

    @Override
    public String toString() {
        return "\n  [USER RESPONSE]" + "\n" +
                "       id: " + this.id + "\n" +
                "       firstName: " + this.firstName + "\n" +
                "       lastName: " + this.lastName + "\n" +
                "       username: " + this.username + "\n"+
                "       email: " + this.email + "\n"+
                "       phone: " + this.phone + "\n";
    }
}

package com.swingapplication.foofast.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private int is_active;
    private int role_id;


    @Override
    public String toString() {
        return "\n  [USER ]" + "\n" +
                "       id: " + this.id + "\n" +
                "       firstName: " + this.firstName + "\n" +
                "       lastName: " + this.lastName + "\n" +
                "       email : " + this.email + "\n" +
                "       username: " + this.username + "\n" +
                "       password: " + this.password + "\n" +
                "       phone: " + this.phone + "\n" +
                "       is_active: " + this.is_active + "\n" +
                "       role_id: " + this.role_id + "\n" ;
    }
}

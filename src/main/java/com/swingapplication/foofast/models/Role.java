package com.swingapplication.foofast.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private long id;
    private String name;
    private int is_active;

    @Override
    public String toString() {
        return "\n  [ROLE]" + "\n" +
                "           id: " + this.id +"\n" +
                "           name: " + this.name +"\n"+
                "           is_active: "+ this.is_active;
    }
}

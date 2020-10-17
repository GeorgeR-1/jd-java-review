package com.cybertek.oop.encapsulation;

import com.cybertek.enums.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private Role role;
    private Gender gender;

}

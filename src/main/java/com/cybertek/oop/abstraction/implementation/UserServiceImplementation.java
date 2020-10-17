package com.cybertek.oop.abstraction.implementation;

import com.cybertek.oop.encapsulation.User;

public interface UserServiceImplementation {

    String userByRowId(int id);
    User userByFirstName(String firstName);



}

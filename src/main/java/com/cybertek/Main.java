package com.cybertek;


import com.cybertek.core.Loops;
import com.cybertek.core.Methods;
import com.cybertek.core.SelectionStatements;
import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.abstraction.implementation.UserServiceImplementation;
import com.cybertek.oop.abstraction.service.UserService;
import com.cybertek.oop.encapsulation.Role;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.BaseEntity;
import com.cybertek.oop.inheritance.Project;
import com.cybertek.oop.polymorphism.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //***************CORE***************//

        Methods methods = new Methods();

        methods.methodA();
        methods.methodA("Apple");
        System.out.println(methods.methodB());
        System.out.println(methods.methodB(5));
        Methods.methodC();

        //***************LOOP***************//
        Loops.demoForEach();
        Loops.demoForIterator();

        SelectionStatements.demoIfStatement();
        SelectionStatements.demoSwitchCaseStatement();

        //***************OOP-Encapsulation***************//
        User user = new User("Jack","Smith", new Role(2,"CEO"), Gender.MALE);

        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getRole().getDescription());

        //***************OOP-Inheritance***************//
        //Project Object

        //No arg constructor
        Project project = new Project();

        //All arg constructor plus complete super()
        Project project1 = new Project(12, LocalDateTime.now(), 235,LocalDateTime.now().plusMonths(6),
                235,"JD","Project",
                new User("John","Smith", new Role(235,"CEO"),Gender.MALE),
                LocalDate.now(), LocalDate.now().plusMonths(6), Status.IN_PROGRESS,"In work");

        //All arg constructor
        Project project2 = new Project("JD","JD",
                new User("John","Smith", new Role(235,"CEO"),Gender.MALE),
                LocalDate.now(),LocalDate.now().plusMonths(6), Status.IN_PROGRESS,"In Work");
        /**
        //Ozzy style
        */
        Project project3 = new Project(1, LocalDateTime.now(), 1,
                LocalDateTime.now().minusHours(5), 1, "PRJ001",
                "Human Resource CRM",
                new User("Mike","Smith",new Role(1,"Manager"),Gender.MALE),
                LocalDate.now(), LocalDate.now().plusMonths(6),Status.IN_PROGRESS,
                "HCRM detail Information");

        //***************OOP-Interface***************//
        UserService userService = new UserService();
        System.out.println(userService.userByFirstName("Mike").getLastName());

        //***************OOP-Polymorphism***************//

        Employee employee = new Employee();
        BaseEntity employee2 = new Employee();
        UserServiceImplementation userServiceImplementation = new UserService();

        employee.getEmployeeHours();


        ( (Employee) employee2 ).getEmployeeHours();

        //***************ENUM***************//

        System.out.println(Gender.FEMALE);
        System.out.println(Status.IN_PROGRESS.getValue().substring(3));


    }

}

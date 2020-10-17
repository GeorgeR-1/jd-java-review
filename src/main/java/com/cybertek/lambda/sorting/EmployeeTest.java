package com.cybertek.lambda.sorting;

import com.cybertek.oop.encapsulation.Role;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(101,"Mike","Smith",
                "VA", new Role(1,"Developer"));
        Employee e2 = new Employee(11,"Ozzy","Smith",
                "IL", new Role(1,"SDET"));
        Employee e3 = new Employee(67,"Ammy","Smith",
                "DC", new Role(1,"DBA"));
        Employee e4 = new Employee(33,"Adam","Smith",
                "FL", new Role(1,"Project Manager"));
        Employee e5 = new Employee(8,"Tammy","Smith",
                "CA", new Role(1,"SM"));

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        System.out.println(employeeList);

        employeeList.sort( (emp1, emp2) -> emp1.getRole().getId().compareTo(emp2.getRole().getId()) );
        System.out.println(employeeList);



    }


}

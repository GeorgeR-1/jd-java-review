package com.cybertek.streams.exercises;

import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.encapsulation.Role;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.Project;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    //Task1
    public static List<Project> getListOfProject(){

        return DataGenerator.getProjects();
    }


    //Task2
    public static List<Project> getListOfProject(Status status){
        List<Project> projectList = DataGenerator.getProjects().stream()
                .filter(project -> project.getProjectStatus().equals(status))
                .collect(Collectors.toList());;

        return projectList;
    }


    //Task3
    public static List<Project> getListOfProject(User manager){
        List<Project> projectList = DataGenerator.getProjects().stream()
                .filter(project -> project.getAssignedManager().equals(manager))
                .collect(Collectors.toList());

        return projectList;
    }


    //Task4
    public static List<Project> getProjectByProjectCode(String projectCode){
        List<Project> projectList = DataGenerator.getProjects().stream()
                .filter(project -> project.getProjectCode().equals(projectCode))
                .collect(Collectors.toList());

        return projectList;
    }


    //Task5
    public static List<User> getListOfUsers(){
        List<User> userList = DataGenerator.getUsers();

        return userList;
    }


    //Task6
    public static User getUserByFirstName(String firstName){
        User user = DataGenerator.getUsers().stream().filter(users -> users.getFirstName().equals(firstName))
                .findFirst().get();

        return user;
    }


    //Task7 ->
    public static String getUserByUserId(Long id){
        User user = DataGenerator.getUsers().stream().filter(user1 -> user1.getRole().getId().equals(id))
                .findFirst().get();

        return String.valueOf(user.getRole().getId());
    }


    //Task8 -> delete the user(object) base on first name
    public static List<User> deleteUser(String firstName){
        List<User> userList = DataGenerator.getUsers().stream()
                .filter(user -> !user.getFirstName().equals(firstName))
                .collect(Collectors.toList());

        return userList;
    }


    //Task9
    public static List<Project> updateProjectStatus(Status oldStatus, Status newStatus){

        List<Project> projectList = DataGenerator.getProjects().stream()
                .map(project -> {
                    if (project.getProjectStatus().equals(oldStatus)){
                        project.setProjectStatus(newStatus);
                    }
                    return project;
                }).collect(Collectors.toList());

        return projectList;
    }


    //Task10
    public static List<Project> findProjectByManager(User manager){
        List<Project> projectList = DataGenerator.getProjects().stream()
                .filter(project -> project.getAssignedManager().equals(manager))
                .collect(Collectors.toList());

        return projectList;
    }


    //Task11
    public static Integer totalProjectDurationForManager(User manager){

        List<Project> projectList = DataGenerator.getProjects().stream()
                .filter(project -> project.getAssignedManager().equals(manager))
                .collect(Collectors.toList());

        Integer days=null;

        /*
        Iteration through all the projects that are managed by the provided manager.
        Had to use for each loop, because forEach method with lambda expresion did not allow me
        to use the Period class
        */
        for (Project project : projectList) {
            /*
            Just a test I did for Duration class:
            LocalDate from = LocalDate.of(project.getStartDate().getYear(), project.getStartDate().getMonthValue(),
                    project.getStartDate().getDayOfMonth());

            LocalDate to = LocalDate.of(project.getEndDate().getYear(), project.getEndDate().getMonthValue(),
                    project.getEndDate().getDayOfMonth());
            */

            days += Period.between(project.getStartDate(), project.getEndDate()).getDays();

        }

        return days;
    }


    //Task12
    public static long findTotalMaleInCompany(){

        List<User> userList = DataGenerator.getUsers();
        userList.addAll(DataGenerator.getManagers());

        long maleCounter = userList.stream().filter(user -> user.getGender().equals(Gender.MALE)).count();

        return maleCounter;
    }



}

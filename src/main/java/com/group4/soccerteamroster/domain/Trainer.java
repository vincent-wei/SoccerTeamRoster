/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.soccerteamroster.domain;

import java.util.List;

/**
 *
 * @author S.Y Wei
 */
public class Trainer {
    
    String firstName;
    String lastName;
    int age;
    Salary salary;
    List<Team> teams;

    public Trainer(String firstName, String lastName, int age, Salary salary, List<Team> teams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.teams = teams;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Salary getSalary() {
        return salary;
    }

    public List<Team> getTeams() {
        return teams;
    }
    
    
}

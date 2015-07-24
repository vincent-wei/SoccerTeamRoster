/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.soccerteamroster.domain;


/**
 *
 * @author S.Y Wei
 */
public class Player {
    String firstName;
    String lastName;
    int age;
    Salary salary;
    String CountryOfBirth;
    String position;
    Statistic stats;

    public Player(String firstName, String lastName, int age, String CountryOfBirth, String position, Salary salary, Statistic stats) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.CountryOfBirth = CountryOfBirth;
        this.position = position;
        this.salary = salary;
        this.stats = stats;
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

    public String getCountryOfBirth() {
        return CountryOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public Statistic getStats() {
        return stats;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.soccerteamroster.service;

import com.group4.soccerteamroster.domain.Player;
import com.group4.soccerteamroster.domain.Salary;
import com.group4.soccerteamroster.domain.Statistic;
import com.group4.soccerteamroster.domain.Team;
import com.group4.soccerteamroster.domain.Trainer;
import java.time.Year;
import org.springframework.stereotype.Component;

/**
 *
 * @author group 4
 */
@Component
public class ValidatorService {

    public boolean isValid(Player player) {

        String firstName = player.getFirstName();
        String lastName = player.getLastName();
        int age = player.getAge();
        String country = player.getCountryOfBirth();
        String position = player.getPosition();
        Salary salary = player.getSalary();
        Statistic stat = player.getStats();

        boolean isValid = true;
        if (firstName == null || firstName.matches(".*\\d.*")
                || lastName == null || lastName.matches(".*\\d.*")
                || age < 20 || age > 23
                || country == null || country.matches(".*\\d.*")
                || !(position.equals("Goalkeeper") || position.equals("Defender") || position.equals("Midfielder") || position.equals("Forward"))
                || salary == null
                || stat.getNumOfGoals() < 0 || stat.getNumOfBookings() < 0) {
            isValid = false;
        }

        return isValid;
    }

    public boolean isValid(Trainer trainer) {
        boolean isValid = true;
        if (trainer.getFirstName() == null
                || trainer.getLastName() == null
                || trainer.getAge() < 40
                || trainer.getSalary() == null
                || trainer.getTeams().isEmpty()) {
            isValid = false;
        }

        return isValid;

    }

    public boolean isValid(Team team) {
        boolean isValid = true;

        if (team.getName() == null
                || team.getYear().isBefore(Year.parse("1950"))
                || team.getPlayers().size() != 22) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isValid(Statistic stat) {
        boolean isValid = true;

        if (stat.getNumOfGoals() < 0 || stat.getNumOfBookings() < 0) {
            isValid = false;
        }

        return isValid;
    }
}

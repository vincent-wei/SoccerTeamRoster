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
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author S.Y Wei
 */

@Component
public class CreatorService {
    
    public Player createPlayer(String firstName, String lastName, int age, String CountryOfBirth, String position, Salary salary, Statistic stats) {
        return new Player(firstName, lastName, age, CountryOfBirth, position, salary, stats);
        
    }
    
    public Trainer createTrainer(String firstName, String lastName, int age, Salary salary, List<Team> teams) {
        return new Trainer(firstName, lastName, age, salary, teams);
    }
    
    public Team createTeam(String name, Year year, List<Player> players) {
        
        return new Team(name, year, players);
    }
    
    public Statistic createStatistic(int numOfGoals, int numOfBookings) {
        return new Statistic(numOfGoals, numOfBookings);
    }
    
}

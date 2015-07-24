/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.soccerteamroster.domain;

import java.time.Year;
import java.util.List;

/**
 *
 * @author S.Y Wei
 */
public class Team {
    
    String name;
    Year year;
    List<Player> players;
    Trainer trainer;

    public Team(String name, Year year, List<Player> players) {
        this.name = name;
        this.year = year;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Year getYear() {
        return year;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }   
    
    
}

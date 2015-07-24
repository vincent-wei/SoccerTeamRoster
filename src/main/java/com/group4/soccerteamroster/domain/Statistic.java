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
public class Statistic {
    int numOfGoals;
    int numOfBookings;

    public Statistic(int numOfGoals, int numOfBookings) {
        this.numOfGoals = numOfGoals;
        this.numOfBookings = numOfBookings;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public int getNumOfBookings() {
        return numOfBookings;
    }
    
    
}

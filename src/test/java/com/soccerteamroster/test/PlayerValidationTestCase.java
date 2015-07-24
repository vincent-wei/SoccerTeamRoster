/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soccerteamroster.test;

import com.group4.soccerteamroster.config.SoccerTeamRosterConfig;
import com.group4.soccerteamroster.domain.Player;
import com.group4.soccerteamroster.domain.Salary;
import com.group4.soccerteamroster.domain.Statistic;
import com.group4.soccerteamroster.service.CreatorService;
import com.group4.soccerteamroster.service.ValidatorService;
import java.util.Locale;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 * @author S.Y Wei
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoccerTeamRosterConfig.class)
public class PlayerValidationTestCase {
    Salary salary;
    Statistic stats;
    
    @Autowired
    private CreatorService creator;
    
    @Autowired
    private ValidatorService validator;
    
    @Before
    public void init(){
       this.stats = creator.createStatistic(0, 0);  
       this.salary =  new Salary(Locale.UK, 15000);  
    }
    
    @Test
    public void assertThatPlayerFirstNameIsRequired(){
        Player player = creator.createPlayer(null, "last", 23, "Canada", "Midfielder", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerLastNameIsRequired(){
        Player player = creator.createPlayer("first", null, 23, "Canada", "Midfielder", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerAgeIsOlderThan23(){
        Player player = creator.createPlayer("first", "last", 28, "Canada", "Midfielder", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerAgeIsYoungerThan20(){
        Player player = creator.createPlayer("first", "last", 19, "Canada", "Midfielder", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerCOBisRequired(){
        Player player = creator.createPlayer("first", "last", 23, null, "Midfielder", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerPositionIsValid(){
        Player player = creator.createPlayer("first", "last", 23, "Canada", " ", salary, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerSalaryIsRequired(){
        Player player = creator.createPlayer("first", "last", 23, "Canada", "Midfielder", null, stats);
        assertFalse(validator.isValid(player));    
    }
    @Test
    public void assertThatPlayerStatsIsValid(){
        Player player = creator.createPlayer("first", "last", 23, "Canada", "Midfielder", salary, new Statistic(-1, -1));
        assertFalse(validator.isValid(player));    
    }
    
    @Test
    public void assertThatPlayerIsValid(){
        String[] positions = {"Forward", "Midfielder", "Defender", "Goalkeeper"};
        for (int i = 0; i< positions.length; i++){
        Player player = creator.createPlayer("first", "last", 23, "Canada", positions[i], salary, stats);
        assertTrue(validator.isValid(player));    
        }
    }
    
}

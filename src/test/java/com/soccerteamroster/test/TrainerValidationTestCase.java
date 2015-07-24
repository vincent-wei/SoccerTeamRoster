/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soccerteamroster.test;

import com.group4.soccerteamroster.config.SoccerTeamRosterConfig;
import com.group4.soccerteamroster.domain.Player;
import com.group4.soccerteamroster.domain.Salary;
import com.group4.soccerteamroster.domain.Team;
import com.group4.soccerteamroster.domain.Trainer;
import com.group4.soccerteamroster.service.CreatorService;
import com.group4.soccerteamroster.service.ValidatorService;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
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
public class TrainerValidationTestCase {
    
    @Autowired
    private CreatorService creator;
    
    @Autowired
    private ValidatorService validator;
    
    List<Team> teams = new ArrayList<Team>();
    Salary salary;
    
    @Before
    public void init(){
        this.teams.add(creator.createTeam("", Year.parse("1950"), new ArrayList<Player>()));
        this.salary =  new Salary(Locale.UK, 15000); 
    }
    
    @Test
    public void assertThatTrainerFirstNameIsRequired(){
        Trainer trainer = creator.createTrainer(null, "last", 40, salary, teams);
        assertFalse(validator.isValid(trainer));    
    }
    @Test
    public void assertThatTrainerLastNameIsRequired(){
        Trainer trainer = creator.createTrainer("first", null, 40, salary, teams);
        assertFalse(validator.isValid(trainer));    
    }
    @Test
    public void assertThatTrainerAgeIsValid(){
        Trainer trainer = creator.createTrainer("first", "last", 30, salary, teams);
        assertFalse(validator.isValid(trainer));    
    }
    @Test
    public void assertThatTrainerSalaryIsRequired(){
        Trainer trainer = creator.createTrainer("first", "last", 40, null, teams);
        assertFalse(validator.isValid(trainer));    
    }
    
    @Test
    public void assertThatTrainerTeamIsValid(){
        Trainer trainer = creator.createTrainer(null, "last", 40, salary, new ArrayList<Team>());
        assertFalse(validator.isValid(trainer));    
    }
    
    @Test
    public void assertThatTrainerIsValid(){
        Trainer trainer = creator.createTrainer("first", "last", 40, salary, teams);
        assertTrue(validator.isValid(trainer));    
    }
    
    
}

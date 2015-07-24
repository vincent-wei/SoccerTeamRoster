/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soccerteamroster.test;

import com.group4.soccerteamroster.config.SoccerTeamRosterConfig;
import com.group4.soccerteamroster.domain.Player;
import com.group4.soccerteamroster.domain.Team;
import com.group4.soccerteamroster.service.CreatorService;
import com.group4.soccerteamroster.service.ValidatorService;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
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
public class TeamValidationTestCase {
    
    @Autowired
    private CreatorService creator;
    
    @Autowired
    private ValidatorService validator;
    
    List<Player> players = new ArrayList<Player>();
        
    @Before
    public void init(){

        for(int i = 0; i<22; i++){
        players.add(null);
        }   
    }
    
    @Test
    public void assertThatTeamNameIsRequired(){
        Team team = creator.createTeam(null, Year.parse("1950"), players);
        assertFalse(validator.isValid(team)); 
    
    }
    @Test
    public void assertThatTeamYearIsValid(){
        Team team = creator.createTeam("", Year.parse("1949"), players);
        assertFalse(validator.isValid(team)); 
    
    }
    @Test
    public void assertThatTeamMustHave22Players(){
        Team team = creator.createTeam(null, Year.parse("1950"), new ArrayList<Player>());
        assertFalse(validator.isValid(team)); 
    
    }
    
    @Test
    public void assertThatTeamIsValid(){
        Team team = creator.createTeam("", Year.parse("1950"), players);
        Assert.assertTrue(validator.isValid(team));
        
    }
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soccerteamroster.test;

import com.group4.soccerteamroster.config.SoccerTeamRosterConfig;
import com.group4.soccerteamroster.domain.Statistic;
import com.group4.soccerteamroster.service.CreatorService;
import com.group4.soccerteamroster.service.ValidatorService;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
public class StatValidationTestCase {

    @Autowired
    private CreatorService creator;

    @Autowired
    private ValidatorService validator;

    @Test
    public void assertThatNumOfGoalsIsValid() {
        Statistic stat = creator.createStatistic(-1, 0);
        assertFalse(validator.isValid(stat));
    }

    @Test
    public void assertThatNumOfBookingsIsValid() {
        Statistic stat = creator.createStatistic(0, -1);
        assertFalse(validator.isValid(stat));
    }

    @Test
    public void assertThatStatIsValid() {
        Statistic stat = creator.createStatistic(0, 0);
        assertTrue(validator.isValid(stat));
    }

}

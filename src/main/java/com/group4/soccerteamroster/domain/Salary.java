/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.soccerteamroster.domain;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author S.Y Wei
 */
public class Salary {
    private Locale locale;
    private int amount;
    private Currency c;

    public Salary(Locale locale, int amount) {
        this.locale = locale;
        this.amount = amount;
        this.c = Currency.getInstance(locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public int getAmount() {
        return amount;
    }    
    
    
}

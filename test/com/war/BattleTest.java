package com.war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    @DisplayName("Warrior vs Knight assume false")
    void fight1() {
        Warrior john = new Warrior();
        Warrior freddie = new Knight();

        boolean result = Battle.fight(john, freddie);

        assertFalse(result);
    }

    @Test
    @DisplayName("Warrior vs Warrior assume true")
    void fight2() {
        Warrior clement = new Warrior();
        Warrior henry = new Warrior();

        boolean result = Battle.fight(clement, henry);

        assertTrue(result);
    }

    @Test
    @DisplayName("Knight vs Warrior assume true")
    void fight3() {
        Warrior jonathan = new Knight();
        Warrior kira = new Warrior();

        boolean result = Battle.fight(jonathan, kira);

        assertTrue(result);
    }

    @Test
    @DisplayName("Knight vs Knight assume true")
    void fight4() {
        Warrior hans = new Knight();
        Warrior franz = new Knight();

        boolean result = Battle.fight(hans, franz);

        assertTrue(result);
    }
}
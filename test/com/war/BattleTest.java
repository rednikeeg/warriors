package com.war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    // Testing Warriors
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

    @Test
    @DisplayName("Warrior vs Defender assume false")
    void fight5() {
        Warrior w1 = new Warrior();
        Warrior w2 = new Defender();

        boolean result = Battle.fight(w1, w2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Defender vs Knight assume false")
    void fight6() {
        Warrior w1 = new Defender();
        Warrior w2 = new Knight();

        boolean result = Battle.fight(w1, w2);

        assertFalse(result);
    }

    // Testing Armies

    @Test
    @DisplayName("1 Warrior vs 2 Warriors assume false")
    void fightArmy1() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 1);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    @Test
    @DisplayName("2 Warriors vs 2 Warriors assume true")
    void fightArmy2() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 2);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertTrue(result);
    }

    @Test
    @DisplayName("2 Knight vs 2 Warriors assume true")
    void fightArmy3() throws ReflectiveOperationException {
        Army a1 = new Army(Knight.class, 2);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertTrue(result);
    }

    @Test
    @DisplayName("2 Warriors vs 2 Knights assume false")
    void fightArmy4() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 2);
        Army a2 = new Army(Knight.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    @Test
    @DisplayName("10 Warriors vs 2 Knights assume true")
    void fightArmy5() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 10);
        Army a2 = new Army(Knight.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertTrue(result);
    }

    @Test
    @DisplayName("100 Warriors vs 100 Defenders assume false")
    void fightArmy6() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 100);
        Army a2 = new Army(Defender.class, 100);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }
}
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

    // Testing Armies

    @Test
    @DisplayName("1 Warrior vs 2 Warriors assume false")
    void fight5() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 1);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    @Test
    @DisplayName("2 Warriors vs 2 Warriors assume true")
    void fight6() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 2);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertTrue(result);
    }

    @Test
    @DisplayName("2 Knight vs 2 Warriors assume true")
    void fight7() throws ReflectiveOperationException {
        Army a1 = new Army(Knight.class, 2);
        Army a2 = new Army(Warrior.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertTrue(result);
    }

    @Test
    @DisplayName("2 Warriors vs 2 Knights assume false")
    void fight8() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 2);
        Army a2 = new Army(Knight.class, 2);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }
}
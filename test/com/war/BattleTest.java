package com.war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    // Testing Warriors
    @Test
    @DisplayName("Warrior vs Knight assume false")
    void fight1() {
        AbstractWarrior john = new Warrior();
        AbstractWarrior freddie = new Knight();

        boolean result = Battle.fight(john, freddie);

        assertFalse(result);
    }

    @Test
    @DisplayName("Warrior vs Warrior assume true")
    void fight2() {
        AbstractWarrior clement = new Warrior();
        AbstractWarrior henry = new Warrior();

        boolean result = Battle.fight(clement, henry);

        assertTrue(result);
    }

    @Test
    @DisplayName("Knight vs Warrior assume true")
    void fight3() {
        AbstractWarrior jonathan = new Knight();
        AbstractWarrior kira = new Warrior();

        boolean result = Battle.fight(jonathan, kira);

        assertTrue(result);
    }

    @Test
    @DisplayName("Knight vs Knight assume true")
    void fight4() {
        AbstractWarrior hans = new Knight();
        AbstractWarrior franz = new Knight();

        boolean result = Battle.fight(hans, franz);

        assertTrue(result);
    }

    @Test
    @DisplayName("Warrior vs Defender assume false")
    void fight5() {
        AbstractWarrior w1 = new Warrior();
        AbstractWarrior w2 = new Defender();

        boolean result = Battle.fight(w1, w2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Defender vs Knight assume false")
    void fight6() {
        AbstractWarrior w1 = new Defender();
        AbstractWarrior w2 = new Knight();

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

    @Test
    @DisplayName("Warrior vs Warrior and Healer assume false")
    void fightArmy7() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 1);
        Army a2 = new Army(Warrior.class, 1)
                .addWarriors(Medic.class, 1);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    // Test straight fight

    @Test
    @DisplayName("4 Warriors vs 2 Knights and 2 Warriors straight assume false")
    void fightStraight1() throws ReflectiveOperationException {
        Army a1 = new Army(Warrior.class, 4);
        Army a2 = new Army(Knight.class, 2)
                .addWarriors(Warrior.class, 2);

        boolean result = Battle.straightFight(a1, a2);

        assertFalse(result);
    }

    // Test weapon

    @Test
    @DisplayName("Knight vs Warrior with Magic Wand assume false")
    void fightWeapon1() {
        AbstractWarrior aw1 = new Knight();
        AbstractWarrior aw2 = new Warrior(Weapon.MagicWand);

        boolean result = Battle.fight(aw1, aw2);

        assertFalse(result);
    }
    @Test
    @DisplayName("Warrior vs Warrior with Sword assume false")
    void fightWeapon2() {
        AbstractWarrior aw1 = new Warrior();
        AbstractWarrior aw2 = new Warrior();

        aw2.setWeapon(Weapon.Sword);

        boolean result = Battle.fight(aw1, aw2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Warrior vs Warrior with Sword in army assume false")
    void fightWeapon3() {
        AbstractWarrior aw1 = new Warrior();
        AbstractWarrior aw2 = new Warrior();

        aw2.setWeapon(Weapon.Sword);

        Army a1 = new Army().addWarriors(aw1);
        Army a2 = new Army().addWarriors(aw2);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Warrior vs Warrior with Sword in army assume false")
    void fightWeapon4() throws ReflectiveOperationException {

        Army a1 = new Army(Warrior.class, 1);
        Army a2 = new Army(Warrior.class, 1);

        a2.get(0).setWeapon(Weapon.Sword);

        boolean result = Battle.fight(a1, a2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Testing moveWarriors() method 3")
    void moveWarriors1() throws ReflectiveOperationException {
        Army a1 = new Army(Warlord.class, 2)
                .addWarriors(Lancer.class, 3)
                .addWarriors(Medic.class, 3);
        Army a2 = new Army(Warlord.class, 1)
                .addWarriors(Medic.class, 3)
                .addWarriors(Lancer.class, 3);

        assertArrayEquals(a1.content.toArray(), a2.content.toArray());
    }
    @Test
    @DisplayName("Testing moveWarriors() method 2")
    void moveWarriors2() throws ReflectiveOperationException {
        Army a1 = new Army(Warlord.class, 2)
                .addWarriors(Lancer.class, 3)
                .addWarriors(Medic.class, 3)
                .addWarriors(Vampire.class, 3);
        Army a2 = new Army(Warlord.class, 2)
                .addWarriors(Vampire.class, 3)
                .addWarriors(Medic.class, 3)
                .addWarriors(Lancer.class, 3);

        assertArrayEquals(a1.content.toArray(), a2.content.toArray());
    }
}
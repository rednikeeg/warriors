package com.war;

public class Warrior extends AbstractWarrior {

    protected void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    protected int getMaxHealth() {
        return 50;
    }

    @Override
    protected int getDamage() {
        return 5;
    }
}

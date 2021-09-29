package com.war;

public class Warrior extends AbstractWarrior {
    @Override
    protected int getMaxHealth() {
        return 50;
    }

    @Override
    protected int getDamage() {
        return 5;
    }
}

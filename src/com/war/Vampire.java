package com.war;

public class Vampire extends AbstractWarrior {
    private int vampirism = 50;
    @Override
    public void attack(AbstractWarrior abstractWarrior) {
        health += abstractWarrior.takeDamage(damage) * vampirism / 100;
    }
    @Override
    protected int getMaxHealth() {
        return 40;
    }

    @Override
    protected int getDamage() {
        return 4;
    }
}

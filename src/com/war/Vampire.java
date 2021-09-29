package com.war;

public class Vampire extends AbstractWarrior {
    @Override
    public void attack(AbstractWarrior abstractWarrior) {
        health += abstractWarrior.takeDamage(damage) * getVampirism() / 100;
    }
    @Override
    protected int getMaxHealth() {
        return 40;
    }

    @Override
    protected int getDamage() {
        return 4;
    }

    private int getVampirism() {
        return 50;
    }
}

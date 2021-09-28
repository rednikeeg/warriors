package com.war;

public class Defender extends AbstractWarrior {
    private final int defense = 2;

    @Override
    protected void takeDamage(int damage){
        health -= damage - defense;
    }

    @Override
    protected int getMaxHealth() {
        return 60;
    }

    @Override
    protected int getDamage() {
        return 3;
    }
}

package com.war;

public class Defender extends Warrior {
    private int defense;

    public Defender() {
        health = 60;
        damage = 3;
        defense = 2;
    }

    @Override
    protected void takeDamage(int damage){
        health -= damage - defense;
    }
}

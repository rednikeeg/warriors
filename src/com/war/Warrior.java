package com.war;

public class Warrior {
    protected int health;
    protected int damage;

    public Warrior() {
        health = 50;
        damage = 5;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Warrior warrior) {
        warrior.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}

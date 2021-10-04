package com.war;

public class Warrior extends AbstractWarrior {
    public Warrior() {

    }

    public Warrior(Weapon weapon) {
        super(weapon);
    }

    @Override
    protected int getBaseHealth() {
        return 50;
    }

    @Override
    protected int getBaseDamage() {
        return 5;
    }

    public Warrior clone() {
        Warrior warrior = new Warrior(weapon);

        warrior.health = this.health;
        warrior.damage = this.damage;

        return warrior;
    }
}

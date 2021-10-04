package com.war;

public class Knight extends AbstractWarrior {
    public Knight() {

    }

    public Knight(Weapon weapon) {
        super(weapon);
    }

    @Override
    protected int getBaseHealth() {
        return 50;
    }

    @Override
    protected int getBaseDamage() {
        return 7;
    }

    @Override
    public Knight clone() {
        Knight knight = new Knight(weapon);

        knight.health = this.health;
        knight.damage = this.damage;

        return knight;
    }
}

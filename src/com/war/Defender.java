package com.war;

public class Defender extends AbstractWarrior implements Defensive {
    public Defender () {

    }

    public Defender(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int takeDamage(int damage) {
        health -= damage - getDefense();
        if(isAlive())
            return damage - getDefense();
        else
            return health + damage - getDefense();
    }

    @Override
    public int getDefense() {
        return getBaseDefense() + weapon.getDefense();
    }

    @Override
    public int getBaseDefense() {
        return 2;
    }

    @Override
    protected int getBaseHealth() {
        return 60;
    }

    @Override
    protected int getBaseDamage() {
        return 3;
    }

    @Override
    public Defender clone() {
        Defender defender = new Defender(weapon);

        defender.health = this.health;
        defender.damage = this.damage;

        return defender;
    }
}

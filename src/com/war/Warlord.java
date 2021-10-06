package com.war;

public class Warlord extends AbstractWarrior implements Defensive {
    public Warlord() {

    }

    public Warlord(Weapon weapon) {
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
        return 100;
    }

    @Override
    protected int getBaseDamage() {
        return 4;
    }

    @Override
    public Warlord clone() {
        Warlord warlord = new Warlord(weapon);

        warlord.health = this.health;
        warlord.damage = this.damage;

        return warlord;
    }
}

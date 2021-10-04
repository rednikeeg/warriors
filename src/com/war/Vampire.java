package com.war;

public class Vampire extends AbstractWarrior {
    public Vampire() {

    }

    public Vampire(Weapon weapon) {
        super(weapon);
    }
    @Override
    public void attack(AbstractWarrior abstractWarrior) {
        int toRestore = abstractWarrior.takeDamage(damage) * getVampirism() / 100;

        if(health + toRestore < getMaxHealth())
            health += toRestore;
        else
            health = getMaxHealth();
    }
    @Override
    protected int getBaseHealth() {
        return 40;
    }

    @Override
    protected int getBaseDamage() {
        return 4;
    }

    private int getBaseVampirism() {
        return 50;
    }

    private int getVampirism() {
        return getBaseVampirism() + weapon.getVampirism();
    }

    @Override
    public Vampire clone() {
        Vampire vampire = new Vampire(weapon);

        vampire.health = this.health;
        vampire.damage = this.damage;

        return vampire;
    }
}

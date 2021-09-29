package com.war;

public abstract class AbstractWarrior {
    protected int damage;
    protected int health;

    public AbstractWarrior() {
        setHealth();
        setDamage();
    }

    public void attack(AbstractWarrior abstractWarrior) {
        abstractWarrior.takeDamage(damage);
    }

    protected final void setHealth() {
        health = getMaxHealth();
    }

    protected final void setDamage() {
        damage = getDamage();
    }

    protected int takeDamage(int damage) {
        health -= damage;
        if(isAlive())
            return damage;
        else
            return health + damage;
    }

    protected boolean isAlive() {
        return health > 0;
    }

    protected abstract int getMaxHealth();

    protected abstract int getDamage();
}

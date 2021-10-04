package com.war;

public abstract class AbstractWarrior {
    protected int damage;
    protected int health;
    protected Weapon weapon;

    public AbstractWarrior() {
        this(Weapon.Custom);
    }

    public AbstractWarrior(Weapon weapon) {
        this.weapon = weapon;
        setHealth();
        setDamage();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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

    public void getHealing(int healAmount) {
        if(health + healAmount < getMaxHealth()) {
            health += healAmount;
        } else {
            health = getMaxHealth();
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    protected abstract int getBaseHealth();

    protected int getMaxHealth() {
        return getBaseHealth() + weapon.getHealth();
    }

    protected abstract int getBaseDamage();

    protected int getDamage() {
        return getBaseDamage() + weapon.getDamage();
    }

    @Override
    public abstract AbstractWarrior clone();
}

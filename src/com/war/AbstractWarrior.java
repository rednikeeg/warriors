package com.war;

/**
 * The class provides template to create custom warriors with essential properties: damage, health and weapon, and
 * methods to work with them.
 *
 * @author Maksym Bohachov
 * @see Army
 * @see Weapon
 */
public abstract class AbstractWarrior implements Comparable<AbstractWarrior> {
    protected int damage;
    protected int health;
    protected Weapon weapon;

    /**
     * Creates instance of AbstractWarrior with Custom type of Weapon with all parameters on it set to 0.
     */
    public AbstractWarrior() {
        this(Weapon.Custom);
    }

    /**
     * Creates instance of AbstractWarrior with certain weapon.
     * @param weapon certain weapon
     */
    public AbstractWarrior(Weapon weapon) {
        setWeapon(weapon);
    }

    /**
     * Initializes AbstractWarrior with certain weapon, default health and damage.
     *
     * @param weapon certain weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        setHealth();
        setDamage();
    }

    /**
     * Sets starting health, used only on initialization.
     */
    protected final void setHealth() {
        health = getMaxHealth();
    }

    /**
     * Sets starting damage, used only on initialization.
     */
    protected final void setDamage() {
        damage = getDamage();
    }

    /**
     * Attacks certain AbstractWarrior.
     *
     * @param abstractWarrior AbstractWarrior that should be attacked by this one
     */
    public void attack(AbstractWarrior abstractWarrior) {
        abstractWarrior.takeDamage(damage);
    }

    /**
     * Decrements AbstractWarrior's health.
     *
     * @param damage damage should be taken
     * @return taken damage
     */
    protected int takeDamage(int damage) {
        health -= damage;
        if (isAlive())
            return damage;
        else
            return health + damage;
    }

    /**
     * Heals this AbstractWarrior.
     *
     * @param healAmount health should be restored
     */
    protected void getHealing(int healAmount) {
        if (health + healAmount < getMaxHealth()) {
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
    public int compareTo(AbstractWarrior aw) {
        if (this instanceof Warlord) {
            return 1;
        } else if (this instanceof Lancer) {
            if (aw instanceof Healer)
                return 1;
            else if (aw instanceof Lancer)
                return 0;
            else
                return -1;
        } else if (this instanceof Healer) {
            if (aw instanceof Healer)
                return 0;
            else
                return -1;
        } else {
            if (aw instanceof Healer)
                return 1;
            else if (aw instanceof Lancer)
                return 1;
            else if (aw instanceof Warlord)
                return -1;
            else
                return 0;
        }
    }

    @Override
    public abstract AbstractWarrior clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractWarrior)) {
            return false;
        }

        return this.getClass() == o.getClass();
    }
}

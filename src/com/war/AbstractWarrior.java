package com.war;

public abstract class AbstractWarrior implements Comparable<AbstractWarrior> {
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
    public int compareTo(AbstractWarrior aw) {
        if(this instanceof Warlord) {
            return 1;
        }
        else if(this instanceof Lancer) {
            if(aw instanceof Healer)
                return 1;
            else if(aw instanceof Lancer)
                return 0;
            else
                return -1;
        }
        else if(this instanceof Healer) {
            if(aw instanceof Healer)
                return 0;
            else
                return -1;
        }
        else {
            if(aw instanceof Healer)
                return 1;
            else if(aw instanceof Lancer)
                return 1;
            else if(aw instanceof Warlord)
                return -1;
            else
                return 0;
        }
    }

    @Override
    public abstract AbstractWarrior clone();

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof AbstractWarrior)) {
            return false;
        }

        return this.getClass() == o.getClass();
    }
}

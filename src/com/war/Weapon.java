package com.war;

/**
 * The enum implements Weapon logic, provides methods to work with additional parameters, that weapons give.
 *
 * @author Maksym Bohachov
 * @see AbstractWarrior
 */
public enum Weapon {
    Sword(5, 2, 0, 0, 0),
    Shield(20, -1, 2, 0, 0),
    GreatAxe(-15, 5, -2, 10, 0),
    Katana(-20, 6, -5, 50, 0),
    MagicWand(30, 3, 0, 0, 3),
    Custom;

    private int health;
    private int damage;
    private int defense;
    private int vampirism;
    private int healingAmount;

    Weapon() {
        setProperties(0, 0 , 0, 0 , 0);
    }

    Weapon(int health, int damage, int defense, int vampirism, int healingAmount) {
        setProperties(health, damage, defense, vampirism, healingAmount);
    }

    public void setProperties(int health, int damage, int defense, int vampirism, int healingAmount) {
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healingAmount = healingAmount;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}

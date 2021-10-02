package com.war;

public class Medic extends AbstractWarrior implements Healer {
    @Override
    protected int getMaxHealth() {
        return 60;
    }

    @Override
    protected int getDamage() {
        return 0;
    }

    @Override
    public int getHealingAmount() {
        return 2;
    }
}

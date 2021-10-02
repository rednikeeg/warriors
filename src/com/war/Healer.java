package com.war;

public interface Healer {
    int getHealingAmount();
    default void heal(AbstractWarrior abstractWarrior) {
        abstractWarrior.getHealing(getHealingAmount());
    }
}

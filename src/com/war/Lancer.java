package com.war;

public class Lancer extends AbstractWarrior implements MultiFighter {
    @Override
    protected int getMaxHealth() {
        return 50;
    }

    @Override
    protected int getDamage() {
        return 6;
    }

    @Override
    public void attack(Squad squad) {
        var it = squad.iterator();

        attack(it.next());

        if(it.hasNext()) {
            it.next().takeDamage(getDamage()/2);
        }
    }
}

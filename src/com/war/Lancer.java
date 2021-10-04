package com.war;

public class Lancer extends AbstractWarrior implements MultiFighter {
    public Lancer() {

    }

    public Lancer(Weapon weapon) {
        super(weapon);
    }

    @Override
    protected int getBaseHealth() {
        return 50;
    }

    @Override
    protected int getBaseDamage() {
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

    @Override
    public Lancer clone() {
        Lancer lancer = new Lancer(weapon);

        lancer.health = this.health;
        lancer.damage = this.damage;

        return lancer;
    }
}

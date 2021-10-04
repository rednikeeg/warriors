package com.war;

public class Medic extends AbstractWarrior implements Healer {
    public Medic() {

    }

    public Medic(Weapon weapon) {
        super(weapon);
    }

    @Override
    protected int getBaseHealth() {
        return 60;
    }

    @Override
    protected int getBaseDamage() {
        return 0;
    }

    @Override
    protected int getDamage() {
        return 0;
    }

    @Override
    public int getBaseHealingAmount() {
        return 2;
    }

    @Override
    public int getHealingAmount() {
        return getBaseHealingAmount() + weapon.getHealingAmount();
    }

    @Override
    public Medic clone() {
        Medic medic = new Medic(weapon);

        medic.health = this.health;
        medic.damage = this.damage;

        return medic;
    }
}

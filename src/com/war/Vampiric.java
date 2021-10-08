package com.war;

/**
 * The interface indicates that certain AbstractWarrior should override {@link #attack(AbstractWarrior abstractWarrior)} and implement
 * logic of vampirism: warrior restores dealt damage * {@link #getVampirism()} / 100.
 *
 * @author Maksym Bohachov
 * @see Vampire
 */
public interface Vampiric {
    void attack(AbstractWarrior abstractWarrior);

    int getVampirism();

    int getBaseVampirism();
}

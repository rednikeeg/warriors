package com.war;

/**
 * The interface indicates that certain AbstractWarrior should override {@link #takeDamage(int damage)} and implement
 * logic of defense: warrior takes damage reduced by {@link #getDefense()}.
 *
 * @author Maksym Bohachov
 * @see Defender
 * @see Warlord
 */
public interface Defensive {
    int takeDamage(int damage);

    int getDefense();

    int getBaseDefense();
}

package com.war;

/**
 * The interface indicates that certain AbstractWarrior should implement {@link #attack(Squad squad)} method, that
 * provides logic of multi fight: warrior attacks mul.
 *
 * @author Maksym Bohachov
 * @see Defender
 * @see Warlord
 */
public interface MultiFighter {
    void attack(Squad squad);
    static MultiFighter multiFighter(AbstractWarrior aw) {
        return (MultiFighter) aw;
    }
}

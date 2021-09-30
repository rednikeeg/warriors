package com.war;

public interface MultiFighter {
    void attack(Squad squad);
    static MultiFighter multiFighter(AbstractWarrior aw) {
        return (MultiFighter) aw;
    }
}

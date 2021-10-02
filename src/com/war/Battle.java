package com.war;

import java.util.Optional;

public class Battle {
    private Battle() {
    }

    public static boolean fight(AbstractWarrior w1, AbstractWarrior w2) {
        do {
            w1.attack(w2);
            if (w2.isAlive())
                w2.attack(w1);
        }
        while (w1.isAlive() && w2.isAlive());

        return w1.isAlive();
    }

    public static boolean fight(Army a1, Army a2) {
        final int MAX_SIZE = 3;
        Squad squad1 = new Squad(a1, MAX_SIZE);
        Squad squad2 = new Squad(a2, MAX_SIZE);

        return fight(squad1, squad2);
    }

    public static boolean fight(Squad s1, Squad s2) {
        while(s1.turn() && s2.turn()) {
            healing(s1);
            healing(s2);

            if (s1.isMultiFighter()) {
                MultiFighter.multiFighter(s1.peek()).attack(s2);
            } else {
                s1.peek().attack(s2.peek());
            }
            if (s2.isAlive() && s2.isMultiFighter()) {
                MultiFighter.multiFighter(s2.peek()).attack(s1);
            } else if (s2.peek().isAlive()) {
                s2.peek().attack(s1.peek());
            }
        }

        return s1.isAlive();
    }

    public static void healing(Squad s) {
        Optional<AbstractWarrior> previous = Optional.empty();
        for(var w : s) {
            if(previous.isPresent() && w instanceof Healer healer)
                healer.heal(previous.get());

            previous = Optional.of(w);
        }
    }
}

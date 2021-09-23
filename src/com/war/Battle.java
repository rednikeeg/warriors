package com.war;

import java.util.Optional;

public class Battle {
    private Battle() {
    }

    public static boolean fight(Warrior w1, Warrior w2) {
        do {
            w1.attack(w2);
            if (w2.isAlive())
                w2.attack(w1);
        }
        while (w1.isAlive() && w2.isAlive());

        return w1.isAlive();
    }

    public static boolean fight(Army a1, Army a2) {
        Optional<Warrior> w1 = a1.next();
        Optional<Warrior> w2 = a2.next();
        while (w1.isPresent() && w2.isPresent()) {
            fight(w1.get(), w2.get());

            if (!w1.get().isAlive())
                w1 = a1.next();
            else if (!w2.get().isAlive())
                w2 = a2.next();
        }

        return w1.isPresent();
    }
}

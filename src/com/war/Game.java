package com.war;

public class Game {
    private Game() {
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
}

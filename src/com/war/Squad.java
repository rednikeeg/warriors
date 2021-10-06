package com.war;

import java.util.Iterator;

public class Squad implements Iterable<AbstractWarrior> {
    private final int MAX_SIZE;
    private Army army;

    private Squad() {
        MAX_SIZE = 0;
    }

    public Squad(Army a) {
        this(a, a.getSize());
    }

    public Squad(Army army, int MAX_SIZE) {
        this.army = army;
        this.MAX_SIZE = MAX_SIZE;
    }

    public boolean turn() {
        clearDead();


        return isAlive();
    }

    public void clearDead() {
        army.clearDead();
    }

    public AbstractWarrior peek() {
        return army.content.peek();
    }

    void remove() {
        army.content.remove();
    }

    public boolean isMultiFighter() {
        return army.content.peek() instanceof MultiFighter;
    }

    public boolean isAlive() {
        return !army.content.isEmpty() && army.content.peek().isAlive();
    }

    public boolean areAllHealers() {
        return army.content.stream().allMatch(v -> v instanceof Healer);
    }

    @Override
    public Iterator<AbstractWarrior> iterator() {
        return army.content.subList(0, Math.min(army.getSize(), MAX_SIZE)).iterator();
    }
}

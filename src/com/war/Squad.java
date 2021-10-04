package com.war;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Squad implements Iterable<AbstractWarrior> {
    private Deque<AbstractWarrior> warriors;
    private final int MAX_SIZE;
    private Army army;

    private Squad() {
        MAX_SIZE = 0;
    }

    public Squad(Army a) {
        this(a, a.getSize());
    }

    public Squad(Army army, int MAX_SIZE) {
        warriors = new LinkedList<>();
        this.army = army;
        this.MAX_SIZE = MAX_SIZE;
    }

    public boolean turn() {
        clearDead();
        if(warriors.size() < MAX_SIZE && warriors.size() < army.getSize())
            push(army);

        return isAlive();
    }

    public void clearDead() {
        warriors = warriors.stream().filter(AbstractWarrior::isAlive).collect(Collectors.toCollection(LinkedList::new));
    }

    public void push(Army a) {
        while(army.hasNext() && warriors.size() < MAX_SIZE)
            warriors.add(army.next());
    }

    public AbstractWarrior peek() {
        return warriors.peek();
    }

    public AbstractWarrior remove() {
        return warriors.remove();
    }

    public boolean isMultiFighter() {
        return warriors.peek() instanceof MultiFighter;
    }

    public boolean isAlive() {
        return !warriors.isEmpty() && warriors.peek().isAlive();
    }

    public boolean areAllHealers() {
        return warriors.stream().allMatch(v -> v instanceof Healer);
    }

    @Override
    public Iterator<AbstractWarrior> iterator() {
        return warriors.iterator();
    }
}

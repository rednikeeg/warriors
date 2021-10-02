package com.war;

import java.util.*;

public class Army implements Iterable<AbstractWarrior> {
    private Deque<AbstractWarrior> army;

    public Army() {
        army = new LinkedList<>();
    }

    public Army(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        this();
        addWarriors(cls, quantity);
    }

    public void addWarriors(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        var constr = cls.getConstructor();

        for (int i = 0; i < quantity; i++) {
            AbstractWarrior abstractWarrior = constr.newInstance();

            army.add(abstractWarrior);
        }
    }

    public AbstractWarrior next() {
        return army.poll();
    }

    public boolean hasNext() {
        return !army.isEmpty();
    }

    public int getSize() {
        return army.size();
    }

    @Override
    public Iterator<AbstractWarrior> iterator() {
        return army.iterator();
    }
}

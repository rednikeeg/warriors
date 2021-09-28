package com.war;

import java.util.*;

public class Army {
    private Deque<AbstractWarrior> army;

    public Army() {

    }

    public Army(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        army = new LinkedList<>();

        addAbstractWarriors(cls, quantity);
    }

    public void addAbstractWarriors(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        var constr = cls.getConstructor();

        for (int i = 0; i < quantity; i++) {
            AbstractWarrior abstractWarrior = constr.newInstance();

            army.add(abstractWarrior);
        }
    }

    public Optional<AbstractWarrior> next() {
        Optional<AbstractWarrior> result;

        if (!army.isEmpty())
            result = Optional.of(army.poll());
        else
            result = Optional.empty();

        return result;
    }
}

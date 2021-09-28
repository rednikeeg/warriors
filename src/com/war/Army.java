package com.war;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Army {
    private Deque<Warrior> army;

    public Army() {

    }

    public Army(Class<? extends Warrior> cls, int quantity) throws ReflectiveOperationException {
        army = new ArrayDeque<>();

        addWarriors(cls, quantity);
    }

    public void addWarriors(Class<? extends Warrior> cls, int quantity) throws ReflectiveOperationException {
        var constr = cls.getConstructor();

        for (int i = 0; i < quantity; i++) {
            Warrior warrior = constr.newInstance();

            army.add(warrior);
        }
    }

    public Optional<Warrior> next() {
        Optional<Warrior> result;

        if (!army.isEmpty())
            result = Optional.of(army.poll());
        else
            result = Optional.empty();

        return result;
    }
}

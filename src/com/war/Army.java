package com.war;

import java.util.*;
import java.util.stream.Collectors;

public class Army implements Iterable<AbstractWarrior> {
    LinkedList<AbstractWarrior> content;

    public Army() {
        content = new LinkedList<>();
    }

    public Army(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        this();
        addWarriors(cls, quantity);
    }

    private Army(LinkedList<AbstractWarrior> content) {
        this.content = content;
    }

    public Army addWarriors(Class<? extends AbstractWarrior> cls, int quantity) throws ReflectiveOperationException {
        if(cls == Warlord.class) {
            if (warlordAbsent())
                content.add(new Warlord());
        }
        else {
            var constr = cls.getConstructor();

            for (int i = 0; i < quantity; i++) {
                AbstractWarrior abstractWarrior = constr.newInstance();

                content.add(abstractWarrior);
            }
        }

        if(!warlordAbsent())
            moveWarriors();

        return this;
    }

    public Army addWarriors(AbstractWarrior aw) {
        if(!(aw instanceof Warlord) || warlordAbsent())
            content.add(aw.clone());

        if(!warlordAbsent())
            moveWarriors();

        return this;
    }

    public Army addWarriors(AbstractWarrior aw, int quantity) {
        for(int i = 0; i < quantity; i++)
            addWarriors(aw);

        return this;
    }

    private void moveWarriors() {
        Collections.sort(content);

        var first = getFirstFighter();

        if(first != null)
            content.addFirst(first);
    }

    public AbstractWarrior getFirstFighter() {
        var it = iterator();

        while(it.hasNext()) {
            var current = it.next();

            if(!(current instanceof Healer) && !(current instanceof Warlord)) {
                it.remove();
                return current;
            }
        }

        return null;
    }

    private boolean warlordAbsent() {
        return content.stream()
                .noneMatch(v -> v instanceof Warlord);
    }

    public AbstractWarrior get(int index) {
        return content.get(index);
    }

    public void clearDead() {
        content = content.stream()
                .filter(AbstractWarrior::isAlive)
                .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *
     * @deprecated
     */
    AbstractWarrior next() {
        return content.poll();
    }

    /**
     * @deprecated
     */
    boolean hasNext() {
        return !content.isEmpty();
    }

    public int getSize() {
        return content.size();
    }

    @Override
    public Iterator<AbstractWarrior> iterator() {
        return content.iterator();
    }
}

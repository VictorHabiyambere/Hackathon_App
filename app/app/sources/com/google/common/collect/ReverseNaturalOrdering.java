package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    public int compare(Comparable<?> left, Comparable<?> right) {
        Preconditions.checkNotNull(left);
        if (left == right) {
            return 0;
        }
        return right.compareTo(left);
    }

    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public <E extends Comparable<?>> E min(E a, E b) {
        return (Comparable) NaturalOrdering.INSTANCE.max(a, b);
    }

    public <E extends Comparable<?>> E min(E a, E b, E c, E... rest) {
        return (Comparable) NaturalOrdering.INSTANCE.max(a, b, c, rest);
    }

    public <E extends Comparable<?>> E min(Iterator<E> iterator) {
        return (Comparable) NaturalOrdering.INSTANCE.max(iterator);
    }

    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.max(iterable);
    }

    public <E extends Comparable<?>> E max(E a, E b) {
        return (Comparable) NaturalOrdering.INSTANCE.min(a, b);
    }

    public <E extends Comparable<?>> E max(E a, E b, E c, E... rest) {
        return (Comparable) NaturalOrdering.INSTANCE.min(a, b, c, rest);
    }

    public <E extends Comparable<?>> E max(Iterator<E> iterator) {
        return (Comparable) NaturalOrdering.INSTANCE.min(iterator);
    }

    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.min(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }
}

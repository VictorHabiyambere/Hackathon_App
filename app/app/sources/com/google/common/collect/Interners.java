package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Interners {
    private Interners() {
    }

    public static class InternerBuilder {
        private final MapMaker mapMaker;
        private boolean strong;

        private InternerBuilder() {
            this.mapMaker = new MapMaker();
            this.strong = true;
        }

        public InternerBuilder strong() {
            this.strong = true;
            return this;
        }

        public InternerBuilder weak() {
            this.strong = false;
            return this;
        }

        public InternerBuilder concurrencyLevel(int concurrencyLevel) {
            this.mapMaker.concurrencyLevel(concurrencyLevel);
            return this;
        }

        public <E> Interner<E> build() {
            if (!this.strong) {
                this.mapMaker.weakKeys();
            }
            return new InternerImpl(this.mapMaker);
        }
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }

    static final class InternerImpl<E> implements Interner<E> {
        final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> map;

        private InternerImpl(MapMaker mapMaker) {
            this.map = MapMakerInternalMap.createWithDummyValues(mapMaker.keyEquivalence(Equivalence.equals()));
        }

        public E intern(E sample) {
            E canonical;
            do {
                MapMakerInternalMap.InternalEntry entry = this.map.getEntry(sample);
                if (entry != null && (canonical = entry.getKey()) != null) {
                    return canonical;
                }
            } while (this.map.putIfAbsent(sample, MapMaker.Dummy.VALUE) != null);
            return sample;
        }
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(interner));
    }

    private static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> interner2) {
            this.interner = interner2;
        }

        public E apply(E input) {
            return this.interner.intern(input);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }

        public boolean equals(@CheckForNull Object other) {
            if (other instanceof InternerFunction) {
                return this.interner.equals(((InternerFunction) other).interner);
            }
            return false;
        }
    }
}

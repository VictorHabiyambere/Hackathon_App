package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> backingIterator;

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T transform(@ParametricNullness F f);

    TransformedIterator(Iterator<? extends F> backingIterator2) {
        this.backingIterator = (Iterator) Preconditions.checkNotNull(backingIterator2);
    }

    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @ParametricNullness
    public final T next() {
        return transform(this.backingIterator.next());
    }

    public final void remove() {
        this.backingIterator.remove();
    }
}

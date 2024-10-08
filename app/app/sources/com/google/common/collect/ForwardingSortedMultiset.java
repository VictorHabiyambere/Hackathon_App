package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
    /* access modifiers changed from: protected */
    public abstract SortedMultiset<E> delegate();

    protected ForwardingSortedMultiset() {
    }

    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }

    protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet(ForwardingSortedMultiset this$0) {
            super(this$0);
        }
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        /* access modifiers changed from: package-private */
        public SortedMultiset<E> forwardMultiset() {
            return ForwardingSortedMultiset.this;
        }
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardFirstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entrySet().iterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = entryIterator.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardLastEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = descendingMultiset().entrySet().iterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = entryIterator.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entrySet().iterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = entryIterator.next();
        Multiset.Entry<E> entry2 = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        entryIterator.remove();
        return entry2;
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = descendingMultiset().entrySet().iterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> entry = entryIterator.next();
        Multiset.Entry<E> entry2 = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        entryIterator.remove();
        return entry2;
    }

    public SortedMultiset<E> headMultiset(@ParametricNullness E upperBound, BoundType boundType) {
        return delegate().headMultiset(upperBound, boundType);
    }

    public SortedMultiset<E> subMultiset(@ParametricNullness E lowerBound, BoundType lowerBoundType, @ParametricNullness E upperBound, BoundType upperBoundType) {
        return delegate().subMultiset(lowerBound, lowerBoundType, upperBound, upperBoundType);
    }

    /* access modifiers changed from: protected */
    public SortedMultiset<E> standardSubMultiset(@ParametricNullness E lowerBound, BoundType lowerBoundType, @ParametricNullness E upperBound, BoundType upperBoundType) {
        return tailMultiset(lowerBound, lowerBoundType).headMultiset(upperBound, upperBoundType);
    }

    public SortedMultiset<E> tailMultiset(@ParametricNullness E lowerBound, BoundType boundType) {
        return delegate().tailMultiset(lowerBound, boundType);
    }
}

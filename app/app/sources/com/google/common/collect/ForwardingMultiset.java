package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
    /* access modifiers changed from: protected */
    public abstract Multiset<E> delegate();

    protected ForwardingMultiset() {
    }

    public int count(@CheckForNull Object element) {
        return delegate().count(element);
    }

    public int add(@ParametricNullness E element, int occurrences) {
        return delegate().add(element, occurrences);
    }

    public int remove(@CheckForNull Object element, int occurrences) {
        return delegate().remove(element, occurrences);
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(@CheckForNull Object object) {
        return object == this || delegate().equals(object);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public int setCount(@ParametricNullness E element, int count) {
        return delegate().setCount(element, count);
    }

    public boolean setCount(@ParametricNullness E element, int oldCount, int newCount) {
        return delegate().setCount(element, oldCount, newCount);
    }

    /* access modifiers changed from: protected */
    public boolean standardContains(@CheckForNull Object object) {
        return count(object) > 0;
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    /* access modifiers changed from: protected */
    public int standardCount(@CheckForNull Object object) {
        for (Multiset.Entry<?> entry : entrySet()) {
            if (Objects.equal(entry.getElement(), object)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean standardAdd(@ParametricNullness E element) {
        add(element, 1);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean standardAddAll(Collection<? extends E> elementsToAdd) {
        return Multisets.addAllImpl(this, elementsToAdd);
    }

    /* access modifiers changed from: protected */
    public boolean standardRemove(@CheckForNull Object element) {
        return remove(element, 1) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean standardRemoveAll(Collection<?> elementsToRemove) {
        return Multisets.removeAllImpl(this, elementsToRemove);
    }

    /* access modifiers changed from: protected */
    public boolean standardRetainAll(Collection<?> elementsToRetain) {
        return Multisets.retainAllImpl(this, elementsToRetain);
    }

    /* access modifiers changed from: protected */
    public int standardSetCount(@ParametricNullness E element, int count) {
        return Multisets.setCountImpl(this, element, count);
    }

    /* access modifiers changed from: protected */
    public boolean standardSetCount(@ParametricNullness E element, int oldCount, int newCount) {
        return Multisets.setCountImpl(this, element, oldCount, newCount);
    }

    protected class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    /* access modifiers changed from: protected */
    public int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object object) {
        return Multisets.equalsImpl(this, object);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return entrySet().hashCode();
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return entrySet().toString();
    }
}

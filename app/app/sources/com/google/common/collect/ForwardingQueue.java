package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    /* access modifiers changed from: protected */
    public abstract Queue<E> delegate();

    protected ForwardingQueue() {
    }

    public boolean offer(@ParametricNullness E o) {
        return delegate().offer(o);
    }

    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @ParametricNullness
    public E remove() {
        return delegate().remove();
    }

    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @ParametricNullness
    public E element() {
        return delegate().element();
    }

    /* access modifiers changed from: protected */
    public boolean standardOffer(@ParametricNullness E e) {
        try {
            return add(e);
        } catch (IllegalStateException e2) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

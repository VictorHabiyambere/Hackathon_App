package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@ElementTypesAreNonnullByDefault
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int maxSize2) {
        Preconditions.checkArgument(maxSize2 >= 0, "maxSize (%s) must >= 0", maxSize2);
        this.delegate = new ArrayDeque(maxSize2);
        this.maxSize = maxSize2;
    }

    public static <E> EvictingQueue<E> create(int maxSize2) {
        return new EvictingQueue<>(maxSize2);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    /* access modifiers changed from: protected */
    public Queue<E> delegate() {
        return this.delegate;
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean add(E e) {
        Preconditions.checkNotNull(e);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return Iterables.addAll(this, Iterables.skip(collection, size - this.maxSize));
    }

    public Object[] toArray() {
        return super.toArray();
    }
}

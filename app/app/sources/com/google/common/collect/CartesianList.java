package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    /* access modifiers changed from: private */
    public final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    static <E> List<List<E>> create(List<? extends List<? extends E>> lists) {
        ImmutableList.Builder<List<E>> axesBuilder = new ImmutableList.Builder<>(lists.size());
        for (List<? extends E> list : lists) {
            List<E> copy = ImmutableList.copyOf(list);
            if (copy.isEmpty()) {
                return ImmutableList.of();
            }
            axesBuilder.add((Object) copy);
        }
        return new CartesianList(axesBuilder.build());
    }

    CartesianList(ImmutableList<List<E>> axes2) {
        this.axes = axes2;
        int[] axesSizeProduct2 = new int[(axes2.size() + 1)];
        axesSizeProduct2[axes2.size()] = 1;
        try {
            for (int i = axes2.size() - 1; i >= 0; i--) {
                axesSizeProduct2[i] = IntMath.checkedMultiply(axesSizeProduct2[i + 1], ((List) axes2.get(i)).size());
            }
            this.axesSizeProduct = axesSizeProduct2;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    /* access modifiers changed from: private */
    public int getAxisIndexForProductIndex(int index, int axis) {
        return (index / this.axesSizeProduct[axis + 1]) % ((List) this.axes.get(axis)).size();
    }

    public int indexOf(@CheckForNull Object o) {
        if (!(o instanceof List)) {
            return -1;
        }
        List<?> list = (List) o;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<?> itr = list.listIterator();
        int computedIndex = 0;
        while (itr.hasNext()) {
            int axisIndex = itr.nextIndex();
            int elemIndex = ((List) this.axes.get(axisIndex)).indexOf(itr.next());
            if (elemIndex == -1) {
                return -1;
            }
            computedIndex += this.axesSizeProduct[axisIndex + 1] * elemIndex;
        }
        return computedIndex;
    }

    public int lastIndexOf(@CheckForNull Object o) {
        if (!(o instanceof List)) {
            return -1;
        }
        List<?> list = (List) o;
        if (list.size() != this.axes.size()) {
            return -1;
        }
        ListIterator<?> itr = list.listIterator();
        int computedIndex = 0;
        while (itr.hasNext()) {
            int axisIndex = itr.nextIndex();
            int elemIndex = ((List) this.axes.get(axisIndex)).lastIndexOf(itr.next());
            if (elemIndex == -1) {
                return -1;
            }
            computedIndex += this.axesSizeProduct[axisIndex + 1] * elemIndex;
        }
        return computedIndex;
    }

    public ImmutableList<E> get(final int index) {
        Preconditions.checkElementIndex(index, size());
        return new ImmutableList<E>() {
            public int size() {
                return CartesianList.this.axes.size();
            }

            public E get(int axis) {
                Preconditions.checkElementIndex(axis, size());
                return ((List) CartesianList.this.axes.get(axis)).get(CartesianList.this.getAxisIndexForProductIndex(index, axis));
            }

            /* access modifiers changed from: package-private */
            public boolean isPartialView() {
                return true;
            }
        };
    }

    public int size() {
        return this.axesSizeProduct[0];
    }

    public boolean contains(@CheckForNull Object object) {
        if (!(object instanceof List)) {
            return false;
        }
        List<?> list = (List) object;
        if (list.size() != this.axes.size()) {
            return false;
        }
        int i = 0;
        for (Object o : list) {
            if (!((List) this.axes.get(i)).contains(o)) {
                return false;
            }
            i++;
        }
        return true;
    }
}

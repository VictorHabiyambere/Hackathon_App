package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    /* access modifiers changed from: package-private */
    public abstract Table.Cell<R, C, V> getCell(int i);

    /* access modifiers changed from: package-private */
    public abstract V getValue(int i);

    RegularImmutableTable() {
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    private final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        private CellSet() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        /* access modifiers changed from: package-private */
        public Table.Cell<R, C, V> get(int index) {
            return RegularImmutableTable.this.getCell(index);
        }

        public boolean contains(@CheckForNull Object object) {
            if (!(object instanceof Table.Cell)) {
                return false;
            }
            Table.Cell<?, ?, ?> cell = (Table.Cell) object;
            Object value = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
            if (value == null || !value.equals(cell.getValue())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    private final class Values extends ImmutableList<V> {
        private Values() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        public V get(int index) {
            return RegularImmutableTable.this.getValue(index);
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> cells, @CheckForNull Comparator<? super R> rowComparator, @CheckForNull Comparator<? super C> columnComparator) {
        Preconditions.checkNotNull(cells);
        if (!(rowComparator == null && columnComparator == null)) {
            Collections.sort(cells, new RegularImmutableTable$$ExternalSyntheticLambda0(rowComparator, columnComparator));
        }
        return forCellsInternal(cells, rowComparator, columnComparator);
    }

    static /* synthetic */ int lambda$forCells$0(Comparator rowComparator, Comparator columnComparator, Table.Cell cell1, Table.Cell cell2) {
        int rowCompare;
        if (rowComparator == null) {
            rowCompare = 0;
        } else {
            rowCompare = rowComparator.compare(cell1.getRowKey(), cell2.getRowKey());
        }
        if (rowCompare != 0) {
            return rowCompare;
        }
        if (columnComparator == null) {
            return 0;
        }
        return columnComparator.compare(cell1.getColumnKey(), cell2.getColumnKey());
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> cells) {
        return forCellsInternal(cells, (Comparator) null, (Comparator) null);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> cells, @CheckForNull Comparator<? super R> rowComparator, @CheckForNull Comparator<? super C> columnComparator) {
        ImmutableSet<R> rowSpace;
        ImmutableSet<C> columnSpace;
        Set<R> rowSpaceBuilder = new LinkedHashSet<>();
        Set<C> columnSpaceBuilder = new LinkedHashSet<>();
        ImmutableList<Table.Cell<R, C, V>> cellList = ImmutableList.copyOf(cells);
        for (Table.Cell<R, C, V> cell : cells) {
            rowSpaceBuilder.add(cell.getRowKey());
            columnSpaceBuilder.add(cell.getColumnKey());
        }
        if (rowComparator == null) {
            rowSpace = ImmutableSet.copyOf(rowSpaceBuilder);
        } else {
            rowSpace = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(rowComparator, rowSpaceBuilder));
        }
        if (columnComparator == null) {
            columnSpace = ImmutableSet.copyOf(columnSpaceBuilder);
        } else {
            columnSpace = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(columnComparator, columnSpaceBuilder));
        }
        return forOrderedComponents(cellList, rowSpace, columnSpace);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
        if (((long) cellList.size()) > (((long) rowSpace.size()) * ((long) columnSpace.size())) / 2) {
            return new DenseImmutableTable(cellList, rowSpace, columnSpace);
        }
        return new SparseImmutableTable(cellList, rowSpace, columnSpace);
    }

    /* access modifiers changed from: package-private */
    public final void checkNoDuplicate(R rowKey, C columnKey, @CheckForNull V existingValue, V newValue) {
        Preconditions.checkArgument(existingValue == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", rowKey, columnKey, newValue, existingValue);
    }
}

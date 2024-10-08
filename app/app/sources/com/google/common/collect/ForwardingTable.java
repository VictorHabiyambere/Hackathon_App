package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    /* access modifiers changed from: protected */
    public abstract Table<R, C, V> delegate();

    protected ForwardingTable() {
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(@ParametricNullness C columnKey) {
        return delegate().column(columnKey);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    public boolean contains(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().contains(rowKey, columnKey);
    }

    public boolean containsColumn(@CheckForNull Object columnKey) {
        return delegate().containsColumn(columnKey);
    }

    public boolean containsRow(@CheckForNull Object rowKey) {
        return delegate().containsRow(rowKey);
    }

    public boolean containsValue(@CheckForNull Object value) {
        return delegate().containsValue(value);
    }

    @CheckForNull
    public V get(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().get(rowKey, columnKey);
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CheckForNull
    public V put(@ParametricNullness R rowKey, @ParametricNullness C columnKey, @ParametricNullness V value) {
        return delegate().put(rowKey, columnKey, value);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @CheckForNull
    public V remove(@CheckForNull Object rowKey, @CheckForNull Object columnKey) {
        return delegate().remove(rowKey, columnKey);
    }

    public Map<C, V> row(@ParametricNullness R rowKey) {
        return delegate().row(rowKey);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }
}

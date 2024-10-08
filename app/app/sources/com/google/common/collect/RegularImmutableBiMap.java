package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    final transient Object[] alternatingKeysAndValues;
    private final transient RegularImmutableBiMap<V, K> inverse;
    @CheckForNull
    private final transient Object keyHashTable;
    private final transient int keyOffset;
    private final transient int size;

    private RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    RegularImmutableBiMap(Object[] alternatingKeysAndValues2, int size2) {
        this.alternatingKeysAndValues = alternatingKeysAndValues2;
        this.size = size2;
        this.keyOffset = 0;
        int tableSize = size2 >= 2 ? ImmutableSet.chooseTableSize(size2) : 0;
        this.keyHashTable = RegularImmutableMap.createHashTableOrThrow(alternatingKeysAndValues2, size2, tableSize, 0);
        this.inverse = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTableOrThrow(alternatingKeysAndValues2, size2, tableSize, 1), alternatingKeysAndValues2, size2, this);
    }

    private RegularImmutableBiMap(@CheckForNull Object valueHashTable, Object[] alternatingKeysAndValues2, int size2, RegularImmutableBiMap<V, K> inverse2) {
        this.keyHashTable = valueHashTable;
        this.alternatingKeysAndValues = alternatingKeysAndValues2;
        this.keyOffset = 1;
        this.size = size2;
        this.inverse = inverse2;
    }

    public int size() {
        return this.size;
    }

    public ImmutableBiMap<V, K> inverse() {
        return this.inverse;
    }

    @CheckForNull
    public V get(@CheckForNull Object key) {
        Object result = RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset, key);
        if (result == null) {
            return null;
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.keyOffset, this.size);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.keyOffset, this.size));
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }
}

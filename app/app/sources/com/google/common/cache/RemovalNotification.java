package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K key, @CheckForNull V value, RemovalCause cause2) {
        return new RemovalNotification<>(key, value, cause2);
    }

    private RemovalNotification(@CheckForNull K key, @CheckForNull V value, RemovalCause cause2) {
        super(key, value);
        this.cause = (RemovalCause) Preconditions.checkNotNull(cause2);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}

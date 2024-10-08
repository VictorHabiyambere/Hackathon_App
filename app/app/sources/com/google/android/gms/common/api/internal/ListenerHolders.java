package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class ListenerHolders {
    private final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    public static <L> ListenerHolder<L> createListenerHolder(L listener, Looper looper, String listenerType) {
        Preconditions.checkNotNull(listener, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(listenerType, "Listener type must not be null");
        return new ListenerHolder<>(looper, listener, listenerType);
    }

    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L listener, String listenerType) {
        Preconditions.checkNotNull(listener, "Listener must not be null");
        Preconditions.checkNotNull(listenerType, "Listener type must not be null");
        Preconditions.checkNotEmpty(listenerType, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(listener, listenerType);
    }

    public final ListenerHolder zaa(Object obj, Looper looper, String str) {
        ListenerHolder createListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        this.zaa.add(createListenerHolder);
        return createListenerHolder;
    }

    public final void zab() {
        for (ListenerHolder clear : this.zaa) {
            clear.clear();
        }
        this.zaa.clear();
    }

    public static <L> ListenerHolder<L> createListenerHolder(L listener, Executor executor, String listenerType) {
        Preconditions.checkNotNull(listener, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(listenerType, "Listener type must not be null");
        return new ListenerHolder<>(executor, listener, listenerType);
    }
}

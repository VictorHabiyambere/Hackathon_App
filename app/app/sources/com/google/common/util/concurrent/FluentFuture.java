package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return FluentFuture.super.get();
        }

        @ParametricNullness
        public final V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return FluentFuture.super.get(timeout, unit);
        }

        public final boolean isDone() {
            return FluentFuture.super.isDone();
        }

        public final boolean isCancelled() {
            return FluentFuture.super.isCancelled();
        }

        public final void addListener(Runnable listener, Executor executor) {
            FluentFuture.super.addListener(listener, executor);
        }

        public final boolean cancel(boolean mayInterruptIfRunning) {
            return FluentFuture.super.cancel(mayInterruptIfRunning);
        }
    }

    FluentFuture() {
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> future) {
        if (future instanceof FluentFuture) {
            return (FluentFuture) future;
        }
        return new ForwardingFluentFuture(future);
    }

    @Deprecated
    public static <V> FluentFuture<V> from(FluentFuture<V> future) {
        return (FluentFuture) Preconditions.checkNotNull(future);
    }

    public final <X extends Throwable> FluentFuture<V> catching(Class<X> exceptionType, Function<? super X, ? extends V> fallback, Executor executor) {
        return (FluentFuture) Futures.catching(this, exceptionType, fallback, executor);
    }

    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> exceptionType, AsyncFunction<? super X, ? extends V> fallback, Executor executor) {
        return (FluentFuture) Futures.catchingAsync(this, exceptionType, fallback, executor);
    }

    public final FluentFuture<V> withTimeout(long timeout, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        return (FluentFuture) Futures.withTimeout(this, timeout, unit, scheduledExecutor);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> function, Executor executor) {
        return (FluentFuture) Futures.transformAsync(this, function, executor);
    }

    public final <T> FluentFuture<T> transform(Function<? super V, T> function, Executor executor) {
        return (FluentFuture) Futures.transform(this, function, executor);
    }

    public final void addCallback(FutureCallback<? super V> callback, Executor executor) {
        Futures.addCallback(this, callback, executor);
    }
}

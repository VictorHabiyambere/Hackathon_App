package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

public final class FailingClientStream extends NoopClientStream {
    private final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;
    private boolean started;
    private final ClientStreamTracer[] tracers;

    public FailingClientStream(Status error2, ClientStreamTracer[] tracers2) {
        this(error2, ClientStreamListener.RpcProgress.PROCESSED, tracers2);
    }

    public FailingClientStream(Status error2, ClientStreamListener.RpcProgress rpcProgress2, ClientStreamTracer[] tracers2) {
        Preconditions.checkArgument(!error2.isOk(), "error must not be OK");
        this.error = error2;
        this.rpcProgress = rpcProgress2;
        this.tracers = tracers2;
    }

    public void start(ClientStreamListener listener) {
        Preconditions.checkState(!this.started, "already started");
        this.started = true;
        for (ClientStreamTracer tracer : this.tracers) {
            tracer.streamClosed(this.error);
        }
        listener.closed(this.error, this.rpcProgress, new Metadata());
    }

    /* access modifiers changed from: package-private */
    public Status getError() {
        return this.error;
    }

    public void appendTimeoutInsight(InsightBuilder insight) {
        insight.appendKeyValue("error", this.error).appendKeyValue("progress", this.rpcProgress);
    }
}

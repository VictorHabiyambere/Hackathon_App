package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;

final class SquelchLateMessagesAvailableDeframerListener extends ForwardingDeframerListener {
    private boolean closed;
    private final MessageDeframer.Listener delegate;

    public SquelchLateMessagesAvailableDeframerListener(MessageDeframer.Listener delegate2) {
        this.delegate = delegate2;
    }

    /* access modifiers changed from: protected */
    public MessageDeframer.Listener delegate() {
        return this.delegate;
    }

    public void messagesAvailable(StreamListener.MessageProducer producer) {
        if (!this.closed) {
            super.messagesAvailable(producer);
        } else if (producer instanceof Closeable) {
            GrpcUtil.closeQuietly((Closeable) producer);
        }
    }

    public void deframerClosed(boolean hasPartialMessage) {
        this.closed = true;
        super.deframerClosed(hasPartialMessage);
    }

    public void deframeFailed(Throwable cause) {
        this.closed = true;
        super.deframeFailed(cause);
    }
}

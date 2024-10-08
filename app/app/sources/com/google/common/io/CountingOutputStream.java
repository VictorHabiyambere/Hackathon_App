package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream out) {
        super((OutputStream) Preconditions.checkNotNull(out));
    }

    public long getCount() {
        return this.count;
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        this.count += (long) len;
    }

    public void write(int b) throws IOException {
        this.out.write(b);
        this.count++;
    }

    public void close() throws IOException {
        this.out.close();
    }
}

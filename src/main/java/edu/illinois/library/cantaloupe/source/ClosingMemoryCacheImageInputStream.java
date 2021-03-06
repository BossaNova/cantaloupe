package edu.illinois.library.cantaloupe.source;

import javax.imageio.stream.MemoryCacheImageInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Override whose {@link #close()} method also closes the wrapped
 * {@link InputStream}.
 */
class ClosingMemoryCacheImageInputStream extends MemoryCacheImageInputStream {

    /**
     * We have to maintain our own reference to this, because the one in super
     * is private.
     */
    private InputStream wrappedStream;

    ClosingMemoryCacheImageInputStream(InputStream stream) {
        super(stream);
        this.wrappedStream = stream;
    }

    @Override
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            wrappedStream.close();
        }
    }

}

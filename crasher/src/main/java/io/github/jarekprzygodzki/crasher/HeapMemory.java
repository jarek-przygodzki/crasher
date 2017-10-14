package io.github.jarekprzygodzki.crasher;

import java.util.ArrayList;
import java.util.List;

import io.dropwizard.util.Size;

public class HeapMemory {

    private static final List<byte[]> allocations = new ArrayList<>();

    private static long totalAllocatedBytes;

    public static synchronized void allocate(Size size) {
        int bytes = Math.toIntExact(size.toBytes());
        byte[] buffer = new byte[bytes];
        totalAllocatedBytes += bytes;
        allocations.add(buffer);
    }

    public static synchronized void free() {
        allocations.clear();
        totalAllocatedBytes = 0;
    }

    public static synchronized long totalAllocatedBytes() {
        return totalAllocatedBytes;
    }

    public static synchronized void triggerOOM() {
        for (;;) {
            allocate(Size.megabytes(1));
        }
    }
}

package io.github.jarekprzygodzki.crasher;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class JvmCrasher {

    public static void crashJvm(){
        try {
            getUnsafe().getByte(0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to crash JVM", e);
        }
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}

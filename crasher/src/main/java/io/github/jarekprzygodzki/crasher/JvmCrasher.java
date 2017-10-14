package io.github.jarekprzygodzki.crasher;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class JvmCrasher {

    public static void crashJvm() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().getByte(0);
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}

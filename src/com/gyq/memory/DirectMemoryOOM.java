package com.gyq.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出.
 * 由DirectMemory导致的内存溢出，一个明显的特征是在Heap Dump文件中不会看见明显的异常，
 * 如果发现OOM之后Dump文件很小，而程序中又直接或间接使用了NIO，那就可以考虑检查一下是不是这
 * 方面的原因。
 *
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M(如果不指定默认与Xmx值一致)
 * @auther gaoyaqiu
 */
public class DirectMemoryOOM {

    // 1MB
    private static final int MEMORY = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            // 分配内存
            unsafe.allocateMemory(MEMORY);
        }
    }
}

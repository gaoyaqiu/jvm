package com.gyq.gc;

/**
 * 新生代gc.
 *
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @auther gaoyaqiu
 */
public class MinorGC {

    // 1M 内存
    private static final int M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * M];
        allocation2 = new byte[2 * M];
        allocation3 = new byte[2 * M];
        // 出现一次Minor GC
        allocation4 = new byte[4 * M];
    }
}

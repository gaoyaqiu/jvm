package com.gyq.gc;

/**
 * 长期存活的对象进入老年代.
 *
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @auther gaoyaqiu
 */
public class TenuringThreshold {

    // 1M 内存
    private static final int M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[M / 4];
        // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * M];
        allocation3 = new byte[4 * M];
        allocation3 = null;
        allocation3 = new byte[4 * M];
    }
}

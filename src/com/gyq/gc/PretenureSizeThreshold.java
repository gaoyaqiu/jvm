package com.gyq.gc;

/**
 * 大对象直接进入老年代.
 * PretenureSizeThreshold参数表示大于这个设置值的对象直接在老年代中分配，这样做的目的是避免在Eden区及两个Survivor区
 * 之间发生大量的内存复制（新生代采用复制算法收集内存），注：该参数只对Serial和ParNew两款收集器有效。
 *
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 * @auther gaoyaqiu
 */
public class PretenureSizeThreshold {

    // 1M 内存
    private static final int M = 1024 * 1024;

    public static void main(String[] args) {
        // 直接分配在老年代
        byte[] allocation = new byte[4 * M];
    }
}

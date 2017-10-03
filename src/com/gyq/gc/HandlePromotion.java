package com.gyq.gc;

/**
 * 空间分配担保.
 * 在发生Minor GC之前，虚拟机会先检查老年代最大可用的连续空间是否大于新生代所有对象总空间，如果这个条件成立，那么Minor GC可以确保是安全的。
 * 如果不成立，则虚拟机会查看HandlePromotionFailures是否有设置允许担保失败。如果允许，那么会继续检查老年代中最大可用的连续空间是否大于历次
 * 晋升到老年代对象的平均大小，如果大于，将尝试一次Minor GC，如果小于，或者HandlePromotionFailures设置不允许担保，那这时会触发一次Full GC。
 *
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:HandlePromotionFailure
 * @auther gaoyaqiu
 */
public class HandlePromotion {
    // 1M 内存
    private static final int M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * M];
        allocation2 = new byte[2 * M];
        allocation3 = new byte[2 * M];
        allocation1 = null;
        allocation4 = new byte[2 * M];
        allocation5 = new byte[2 * M];
        allocation6 = new byte[2 * M];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * M];
    }
}

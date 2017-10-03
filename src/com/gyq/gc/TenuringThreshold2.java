package com.gyq.gc;

/**
 * 动态对象年龄判定.
 * 为了适应不同程序的内存状况，虚拟机并不是永远地要求对象的年龄必须达到MaxTenuringThreshold设定的值才能晋升老年代，
 * 如果在Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象就可以直接进入老年代，
 * 无需等到MaxTenuringThreshold中要求的年龄。
 *
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution
 * @auther gaoyaqiu
 */
public class TenuringThreshold2 {

    // 1M 内存
    private static final int M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[M / 4];
        // allocation1 + allocation2 大于survivor空间一半
        allocation2 = new byte[M / 4];
        allocation3 = new byte[4 * M];
        allocation4 = new byte[4 * M];
        allocation4 = null;
        allocation4 = new byte[4 * M];
    }
}

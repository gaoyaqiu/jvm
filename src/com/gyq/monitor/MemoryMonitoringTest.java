package com.gyq.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存监控（通过jconsole监控Eden区gc变化）.
 *
 * @auther gaoyaqiu
 */
public class MemoryMonitoringTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延迟， 令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        // 虽然调用了gc，但是空间并没有回收，因为list对象任然存活
        //System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        // 尝试将gc方法放在这，在观察内存变化
        System.gc();
    }
}



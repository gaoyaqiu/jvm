package com.gyq.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出异常测试.
 * 当出现这个异常时，建议使用Eclipse Memory Analyzer工具来分析是出现了内存泄漏还是内存溢出
 * 下载地址：http://www.eclipse.org/mat/downloads.php
 *
 * VM Args: -Xms:20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @auther gaoyaqiu
 */
public class HeapOOM {

    static class OOMobject{}

    public static void main(String[] args) {
        List<OOMobject> list = new ArrayList<OOMobject>();

        while (true) {
            list.add(new OOMobject());
        }
    }
}

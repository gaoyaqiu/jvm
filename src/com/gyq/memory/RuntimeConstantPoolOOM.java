package com.gyq.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常.
 * 注：该程序在jdk1.6中才会抛出java.lang.OutOfMemoryError: PermGen space 异常信息，在jdk1.7及1.7+版本while循环
 * 将一直执行下去，因为在jdk1.6及以前的版本，常量池分配在永久代中, 在jdk1.7开始常量池移到了堆中，同时在1.8中已经移除了永久代，
 * 取而代之的是元空间(Metaspace)
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @auther gaoyaqiu
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
       // 使用List保持着常量池引用， 避免Full Gc回收常量池行为
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            // 使用intern方法，将字符串添加到常量池中
            list.add(String.valueOf(i++).intern());
        }
    }
}

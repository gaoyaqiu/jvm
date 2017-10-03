package com.gyq.thread;

import java.util.Map;

/**
 * 查看线程堆栈信息.
 *
 * @auther gaoyaqiu
 */
public class GetAllStackTraces {

    public static void main(String[] args) {
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) stackTrace.getKey();
            StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }

            System.out.println("线程： " + thread.getName());
            for (StackTraceElement element : stack) {
                System.out.println(element);
            }
        }
    }
}

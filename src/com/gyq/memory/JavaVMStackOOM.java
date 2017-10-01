package com.gyq.memory;

/**
 * 虚拟机栈和本地方法栈OOM异常测试(当虚拟机在扩展栈申请不到足够的内存，则会抛出OutOfMemoryError异常，防止系统假死，测试该程序要慎重！).
 * 该种情况通过不断的创建线程，每个线程的栈分配的内存越大，可以创建的线程数自然也就越少，越容易产生内存溢出
 * <p>
 * VM Args: -Xss2M（可以设置大一点）
 *
 * @auther gaoyaqiu
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

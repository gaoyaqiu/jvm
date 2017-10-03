package com.gyq.monitor;

/**
 * 监控线程死锁.
 *
 * @auther gaoyaqiu
 */
public class ThreadDeadLockMonitoringTest {


    static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 线程交叉等待
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunable(1, 2)).start();
            new Thread(new SynAddRunable(2, 1)).start();
            new Thread(new SynAddRunable(1, 2)).start();
        }
    }
}



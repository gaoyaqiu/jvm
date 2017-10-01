package com.gyq.memory;

/**
 * 虚拟机栈和本地方法栈异常测试.
 * 当线程请求的栈深度大于虚拟机所设定的深度，则会抛出StackOverflowError异常
 *
 * VM Args: -Xss256k
 * @auther gaoyaqiu
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        // 运行之后抛出 stack length: 773 java.lang.StackOverflowError
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e) {
            // 这里捕获的是Throwable而不是Exception，因为StackOverflowError不是Exception的子类
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}

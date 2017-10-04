package com.gyq.classloading;

/**
 * 被动使用类字段演示三(被动引用).
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 *
 * @auther gaoyaqiu
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "hello world";
}

class NotInitialization {
    public static void main(String[] args) {
        // 运行之后没有输出"ConstClass init!"，因为在编译阶段通过常量优化，已将此常量值"hello world"存储到NotINitialization类的
        // 常量池中，以后NotInitialization对常量ConstClass.HELLO_WORLD的引用实际都被转化为NotInitialization类对自身常量池的引用了。
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
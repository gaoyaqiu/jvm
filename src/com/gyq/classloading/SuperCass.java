package com.gyq.classloading;

/**
 * 被动使用类字段演示一(被动引用).
 * 通过子类引用父类的静态字段，不会导致子类初始化
 *
 * @auther gaoyaqiu
 */
public class SuperCass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

}

class SubClass extends SuperCass {
    static {
        System.out.println("SubClass init!");
    }
}

/**
 * 非主动使用类字段
 */
class NotInitialization1 {
    public static void main(String[] args) {
        // 运行之后只会输出"SuperClass init!",而不会输出"SubClass init!"。 对于静态字段，只有直接定义这个字段的类才会被初始化，因为通过
        // 子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
        System.out.println(SubClass.value);
    }
}

/**
 * 被动使用类字段演示二(被动引用).
 * 通过数组定义来引用类，不会触发此类的初始化
 */
class NotInitialization2 {
    public static void main(String[] args) {
        // 运行之后没有输出任何信息
        SuperCass[] sca = new SuperCass[10];
    }
}

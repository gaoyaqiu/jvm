package com.gyq.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示.
 *
 * @auther gaoyaqiu
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream in = getClass().getResourceAsStream(fileName);
                    if (in == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.gyq.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        // 下面代码执行返回false，因为虚拟机中存在了两个ClassLoaderTest类，一个是由系统应用程序类加载器加载的，另外一个是由
        // 我们自定义的类加载器加载的，虽然都来自同一个Class文件，但依然是两个独立的类。
        System.out.println(obj instanceof com.gyq.classloading.ClassLoaderTest);
    }
}

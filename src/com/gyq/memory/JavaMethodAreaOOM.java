package com.gyq.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区内存溢出异常(运行时产生大量的类来填满方法区，直到溢出，这里借助cglib来实现, jar包在libs目录中).
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M(仅在jdk1.6及以前的版本有效)
 * @auther gaoyaqiu
 */
public class JavaMethodAreaOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        // 运行之后抛出java.lang.OutOfMemoryError: PermGen space异常
        while (true) {
            Enhancer enhancer = new Enhancer();
            // 设置代理目标
            enhancer.setSuperclass(OOMObject.class);
            // 关闭cglib缓存，否则总是生成同一个类
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
}

package com.feiyu.cglib;

//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * CGLIB实现动态代理不需要接口
 */
public class Main {
//    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();//增强器
//        enhancer.setSuperclass(Tank.class);//设置父类
//        enhancer.setCallback(new TimeMethodInterceptor());//设置回调;TimeMethodInterceptor拦截器 相当于 InvocationHandler
//        Tank tank = (Tank)enhancer.create();//动态代理的生成
//        tank.move();
//    }
}
//
//class TimeMethodInterceptor implements MethodInterceptor {
//
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//
//        System.out.println(o.getClass().getSuperclass().getName());
//        System.out.println("before");
//        Object result = null;
//        result = methodProxy.invokeSuper(o, objects);
//        System.out.println("after");
//        return result;
//    }
//}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
package com.feiyu.proxy.v08;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 参考：11分钟：https://ke.qq.com/webcourse/index.html#cid=398245&term_id=100475004&taid=3345929847837605&type=1024&vid=5285890790513768351
 * 使用jdk的动态代理（重点）
 * 
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v05:使用代理
 * v06:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator?
 * v07:代理的对象改成Movable类型-越来越像decorator了
 * v08:如果有stop方法需要代理...
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 * （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 */
public class Tank implements Movable {

    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //reflection 反射是通过二进制字节码分析类的属性和方法

        //newProxyInstance方法产生新的代理
        //参数一：哪一个ClassLoader把被代理类load内存中
        //参数二：new代理对象需要实现的什么样的接口
        //参数三：实现这个接口 InvocationHandler，写代理类自己的业务方法
        Movable m = (Movable)Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, //tank.class.getInterfaces()
                new LogHander(tank)
        );

        m.move();//执行时回调的LogHander.invoke方法
    }
}

class LogHander implements InvocationHandler {

    Tank tank;

    public LogHander(Tank tank) {
        this.tank = tank;
    }
    //getClass.getMethods[]：拿到一个类里面所有方法的数组
    
    
    //参数一：生成的代理对象，proxy这里是m
    //参数二：增强的方法，method在这里是move()方法
    //参数三：传入参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start..");
        Object o = method.invoke(tank, args);//相当于调用tank.move();
        System.out.println("method " + method.getName() + " end!");
        return o;
    }
}



interface Movable {
    void move();
}
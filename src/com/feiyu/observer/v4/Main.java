package com.feiyu.observer.v4;

/**
 * 加入多个观察者
 */

class Child {
    private boolean cry = false;
    /*引入观察者*/
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();


    public boolean isCry() {
        return cry;
    }

    /**
     * 观察者观察的方法触发之后作出的反应
     */
    public void wakeUp() {
        cry = true;
        dad.feed();
        dog.wang();
        mum.hug();
    }
}
/**
 * 观察者1
 * @author feiyu
 *
 */
class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}
/**
 * 观察者2
 * @author feiyu
 *
 */
class Mum {
    public void hug() {
        System.out.println("mum hugging...");
    }
}
/**
 * 观察者3
 * @author feiyu
 *
 */
class Dog {
    public void wang() {
        System.out.println("dog wang...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}

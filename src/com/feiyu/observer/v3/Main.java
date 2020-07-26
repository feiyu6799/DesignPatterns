package com.feiyu.observer.v3;

/**
 * 加入观察者
 */

class Child {//Child被观察者
    private boolean cry = false;
    private Dad d = new Dad();//Dad观察者

    public boolean isCry() {
        return cry;
    }
    
    /**
     * 观察者观察的方法触发之后作出的反应
     */
    public void wakeUp() {
        cry = true;
        d.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}

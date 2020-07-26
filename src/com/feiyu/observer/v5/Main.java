package com.feiyu.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }


    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        for(Observer o : observers) {
            o.actionOnWakeUp();
        }
    }
}
/**
 * 观察者接口
 * @author feiyu
 *
 */
interface Observer {
	/**
	 * 观察者观察监听的事件发生之后所作出的动作
	 */
    void actionOnWakeUp();
}
/**
 * 观察者1
 * @author feiyu
 *
 */
class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}
/**
 * 观察者2
 * @author feiyu
 *
 */
class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}
/**
 * 观察者3
 * @author feiyu
 *
 */
class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}

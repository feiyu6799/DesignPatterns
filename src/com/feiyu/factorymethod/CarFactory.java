package com.feiyu.factorymethod;
/**
 * 针对每种交通工具创建一个工厂
 * 例如：此类就是生成car的
 * @author feiyu
 *
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}

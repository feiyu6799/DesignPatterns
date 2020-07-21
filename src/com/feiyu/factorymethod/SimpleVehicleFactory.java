package com.feiyu.factorymethod;
/**
 * 简单的工厂模式
 * 通过方法调用创建使用的类
 * 
 * 简单工厂的可扩展性不好
 * @author feiyu
 *
 */
public class SimpleVehicleFactory {
	/**
	 *创建 汽车
	 * @return
	 */
    public Car createCar() {
        //before processing
        return new Car();
    }

    /**
     * 创建扫把
     * @return
     */
    public Broom createBroom() {
        return new Broom();
    }
}

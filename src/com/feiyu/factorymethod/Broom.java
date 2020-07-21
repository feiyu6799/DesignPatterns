package com.feiyu.factorymethod;
/**
 * 交通工具-扫把
 * @author feiyu
 *
 */
public class Broom implements Moveable{

    @Override
    public void go() {
        System.out.println("broom flying chuachuachua .....");
    }
}

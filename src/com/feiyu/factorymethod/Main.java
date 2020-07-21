package com.feiyu.factorymethod;
/**
 * 程序启动类
 * @author feiyu
 *
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();
    }
}

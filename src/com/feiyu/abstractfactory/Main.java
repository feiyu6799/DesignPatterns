package com.feiyu.abstractfactory;
/**32：26
 * 分为两个族
 * 1.现代组：汽车 ak47 面包
 * 2.魔法组：扫把 魔法棒 蘑菇
 * @author feiyu
 *
 */
public class Main {
    public static void main(String[] args) {
        AbastractFactory f = new ModernFactory();

        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();
    }
}

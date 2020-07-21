package com.feiyu.abstractfactory;
/**
 * 抽象工厂
 * @author feiyu
 *
 */
public abstract class AbastractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}

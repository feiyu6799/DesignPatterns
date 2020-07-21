package com.feiyu.abstractfactory;
/**
 * 生产现代组的具体实现类
 * @author feiyu
 *
 */
public class ModernFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}

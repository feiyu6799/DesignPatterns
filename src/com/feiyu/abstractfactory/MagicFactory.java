package com.feiyu.abstractfactory;
/**
 * 生产魔法组的具体实现类
 * @author feiyu
 *
 */
public class MagicFactory extends AbastractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}

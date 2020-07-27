package com.feiyu.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * 享元模式
 * @author feiyu
 *
 */
class Bullet{
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}

/**
 * 声明一个子弹池，每次子弹出了边界，也就是消失了，就设为false
 * 从池中取为false的子弹，从新指向别的坦克发出的子弹，避免多次
 * 创建重复的对象
 * 与线程池连接池类似
 * @author feiyu
 *
 */
public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();
    {
        for(int i=0; i<5; i++) bullets.add(new Bullet());//往池里塞初始量
    }

    /**
     * 取子弹
     * @return
     */
    public Bullet getBullet() {
        for(int i=0; i<bullets.size(); i++) {
            Bullet b = bullets.get(i);
            if(!b.living) return b;
        }

        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();

        for(int i=0; i<10; i++) {
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }

}

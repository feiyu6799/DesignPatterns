package com.feiyu.Iterator.v1;

/**
 * 构建一个容器，可以添加对象
 */

public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for(int i=0; i<15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}


/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class ArrayList_ {
    Object[] objects = new Object[10];
    //objects中下一个空的位置在哪儿,或者说，目前容器中有多少个元素
    private int index = 0;
    public void add(Object o) {
    	//1.判断当前数组满了，2.就新建一个数组是原来数组的两倍，3.把老的数组复制给新的数组，继续添加，4.把新的数组指向老的数组指向
        if(index == objects.length) {//1.判断当前数组满了
            Object[] newObjects = new Object[objects.length*2];//2.就新建一个数组是原来数组的两倍
            System.arraycopy(objects, 0, newObjects, 0, objects.length);//3.把老的数组复制给新的数组，继续添加
            objects = newObjects;//4.把新的数组指向老的数组指向
        }

        objects[index] = o;
        index ++;
    }

    public int size() {
        return index;
    }
}
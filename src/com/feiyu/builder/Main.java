package com.feiyu.builder;
/**
 * 构建器
 * 构建复杂的对象
 * @author feiyu
 *
 */
public class Main {
    public static void main(String[] args) {
    	/*类型一调用*/
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();
        //new Terrain(Wall w, Fort f, Mine m)
        //Effective Java

       /* 类型二调用*/
        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
                //.score(20)
                .weight(200)
                //.loc("bj", "23")
                .build();
    }
}

package com.feiyu.builder;
/**
 * 接口，里面包含复杂对象里的元素方法
 * @author feiyu
 *
 */
public interface TerrainBuilder {
	/**
	 * 给Wall赋值
	 * @return
	 */
    TerrainBuilder buildWall();
    /**
	 * 给Fort赋值
	 * @return
	 */
    TerrainBuilder buildFort();
    /**
	 * 给Mine赋值
	 * @return
	 */
    TerrainBuilder buildMine();
    /**
	 * 返回Terrain
	 * @return
	 */
    Terrain build();
}

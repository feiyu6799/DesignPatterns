package com.feiyu.Iterator.v5;
/**
 * 每个容器实现这个接口
 * 内部去自己实现自己的遍历
 * @author feiyu
 *
 */
public interface Iterator_ {
	/**
	 * 判断是否有下一个
	 * @return
	 */
    boolean hasNext();

    /**
     * 返回下一个值
     * @return
     */
    Object next();
}

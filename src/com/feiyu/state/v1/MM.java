package com.feiyu.state.v1;

/**
 * 当增加新的状态时非常不方便
 * 假设一个MM，她有三个行为：smile、cry、say，两个状态：HAPPY、SAD。
 */

public class MM {
    String name;
    private enum MMState {HAPPY, SAD}
    MMState state;

    /**
     * 下面方法都是这个类的不同的状态去只想的
     */
    public void smile() {
        //switch case

    }

    public void cry() {
        //switch case
    }

    public void say() {
        //switch case
    }
}

package com.feiyu.state.v2;

/**
 * 假设一个MM，她有三个行为：smile、cry、say，两个状态：HAPPY、SAD。
 * 当增加新的状态时非常不方便
 */

public class MM {
    String name;
    MMState state = new MMHappyState();

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }

}

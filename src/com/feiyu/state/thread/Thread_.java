package com.feiyu.state.thread;
/**
 * 模拟Thread
 * @author feiyu
 *
 */
public class Thread_ {
    ThreadState_ state;

    /**
     * 移动
     * @param input
     */
    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }


}

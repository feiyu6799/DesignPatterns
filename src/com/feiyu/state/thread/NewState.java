package com.feiyu.state.thread;
/**
 * NewState状态
 * @author feiyu
 *
 */
public class NewState extends ThreadState_ {
    private Thread_ t;

    public NewState(Thread_ t) {
        this.t = t;
    }

    /**
     * 根据当前状态（NewState）和输入参数（Action）
     * 决定动作
     */
    @Override
    void move(Action input) {
        if(input.msg == "start")
        t.state = new RunningState(t);
    }

    @Override
    void run() {

    }
}

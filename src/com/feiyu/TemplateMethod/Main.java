package com.feiyu.TemplateMethod;
/**
 * 模板方法（钩子函数）
 * @author feiyu
 *
 */
public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();//这里调用m方法自动调用了op1和op2
    }

}

abstract class F {
	/**
	 * m方法相当于模板
	 * 里面定义了先执行op1还是op2
	 */
    public void m() {
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}

class C1 extends F {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}

package com.feiyu.visitor;
/**
 * visitor访问者
 * @author feiyu
 *假设这是一台电脑，里面有cpu，memory，board这三部分组成
 *问题：针对不同的人群，出售的折扣价不同
 *前提是内部结构固定也就是  一台电脑，里面有cpu，memory，board这三部分组成是固定的不会随便新增别的部件
 *才适合使用 访问者模式 ，随意增加不同的购买人群
 */
public class Computer {
    ComputerPart cpu = new CPU();//CPU
    ComputerPart memory = new Memory();//内存
    ComputerPart board = new Board();//主板

    public void acccept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonelVisitor p = new PersonelVisitor();
        new Computer().acccept(p);
        System.out.println(p.totalPrice);
    }
}
/**
 * 主接口
 * @author feiyu
 *
 */
abstract class ComputerPart {
    abstract void accept(Visitor v);//访问者（不同的购买人群）
    //some other operations eg:getName getBrand
    abstract double getPrice();//获取价格
}

class CPU extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
/**
 * 个人购买售价
 * @author feiyu
 *
 */
class PersonelVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.95;
    }
}
/**
 * 公司购买售价
 * @author feiyu
 *
 */
class CorpVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.75;
    }
}

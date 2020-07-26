package com.feiyu.composite;

import java.util.ArrayList;
import java.util.List;
/**
 * 组合模式
 * 树状模式专用模式
 * @author feiyu
 *
 */
abstract class Node {//节点
    abstract public void p();//打印方法
}

class LeafNode extends Node {//叶子
    String content;//内容
    public LeafNode(String content) {this.content = content;}

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {//枝叶：里面有Branch也有Leaf
    List<Node> nodes = new ArrayList<>();//组合：组合自身和Node接口下的子类

    String name;
    public BranchNode(String name) {this.name = name;}

    @Override
    public void p() {
        System.out.println(name);
    }

    /**
     * 添加子节点，子节点可以是：枝Branch，也可以是叶Leaf
     * @param n
     */
    public void add(Node n) {
        nodes.add(n);
    }
}


public class Main {
    public static void main(String[] args) {

        BranchNode root = new BranchNode("root");//根节点
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node r1 = new LeafNode("r1");//叶子节点
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);//BranchNode添加枝
        root.add(chapter2);
        root.add(r1);//BranchNode添加叶
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);

    }

    /**
     * 递归打印组合结构
     * @param b
     * @param depth
     */
    static void tree(Node b, int depth) {
        for(int i=0; i<depth; i++) System.out.print("--");
        b.p();

        if(b instanceof BranchNode) {
            for (Node n : ((BranchNode)b).nodes) {
                tree(n, depth + 1);
            }
        }
    }
}

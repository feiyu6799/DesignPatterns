package com.feiyu.Iterator.v2;

/**
 * v1:构建一个容器，可以添加对象
 * v2:用链表来实现一个容器
 */

public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for(int i=0; i<15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}


/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_ {
    Node head = null;//根节点（首个）
    Node tail = null;//尾节点（最后一个）
    //目前容器中有多少个元素
    private int size = 0;

    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if(head == null) {//head == null说明一个节点都没有,就建立第一个节点
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }
//链表：一块内存中有一部分是真实数据，一部分是指向下一个内存地址，如此循环成链表
    private class Node {
        private Object o;//真实数据
        Node next;//指向下一个节点

        public Node(Object o) {
            this.o = o;
        }
    }

    public int size() {
        return size;
    }
}
package com.market.myapplication.LinkTest;


public class LinkMerge {
    static class Node{
        Integer value;
        Node next;
        Node(Integer value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static Node merge(Node head1,Node head2){
        if (head1 ==null){
            return head2;
        }
        if (head2 ==null){
            return head1;
        }
        Node newHead = new Node(null,null);
        //递归输出条件,同时为空停止递归
        if (head1==null&&head2==null){
            return null;
        }
        if (head1.value > head2.value){
            newHead = head2;
            newHead.next = merge(head1,head2.next);
        }else{
            newHead = head1;
            newHead.next = merge(head2,head1.next);
        }
        return newHead;
    }
}

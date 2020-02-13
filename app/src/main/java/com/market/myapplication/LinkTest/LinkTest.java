package com.market.myapplication.LinkTest;

//常见的单链表练习题

/**
 * 链表的基本练习题，包括了链表翻转，
 * 判断链表是否有环，判断环入口，判断两个链表是否相交，
 * 查找倒数第K个元素，从尾到头打印链表
 *
 */
public class LinkTest {
    //内部类来声明结点
    static class  Node<T>{
        T value;
        Node<T> next;

        public Node(T value,Node next){
            this.value = value;
            this.next = next;
        }
    }


    //链表翻转(递归)第一个结点即为头指针
    public static Node reverseLink(Node head){
        //可行性判断
        if (head ==null ||head.next==null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverseLink(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    //链表翻转(迭代)
    //使用2个指针，pre和next，next做临时变量
    public static Node reverseLink2(Node head){
        Node pre =null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }
    //判断链表是否有环
    public boolean isCircleLink(Node head){
        if (head==null||head.next==null){
            return false;
        }
        Node slow = head;
        Node fast =head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    //一个有环链表判断入口，从设立一个头指针，头指针和慢指针相遇的点即为入口
    public Node getInterNode(Node head) {
        //可行性判断
        if (isCircleLink(head) == false) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        //设置快慢相遇点
        Node meet = null;
        //环入口结点
        Node interNode = head;
        //找到相遇点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = slow;
                break;
            }
        }
        //快慢相遇点开始计数，再相遇则为入口点
        while(slow!=null){
            meet = meet.next;
            slow = slow.next;
            if (meet == slow){
                interNode = meet;
                break;
            }
        }
        return interNode;
    }
    //判断两个链表是否相交
    public boolean isCross(Node head1,Node head2){
        //可行性判断
        if (head1==null||head2==null){
            return false;
        }
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1.next!=null){
            temp1 = temp1.next;
        }
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        return temp1 == temp2;
    }
    //删除链表中的重复元素


    //找出单链表的倒数第k个元素(2个指针，一个先走第k-1步，然后一并走到头)
    public Node findElement(int k,Node head){
        if (k<1){
            return null;
        }
        Node h1 = head;
        Node h2 = head;
        for (int i=0;i<k-1&&h1!=null;i++){
            h1 = h1.next;
        }
        //判断为空
        if (h1==null){
            return null;
        }
        //分别往前走
        while(h1.next!=null){
            h1 = h1.next;
            h2 = h2.next;
        }
        return h2;
    }
    //从尾到头打印链表（递归）
    public static void printLinkReverse(Node head){
        if (head.next!=null){
            printLinkReverse(head.next);
            System.out.println(head.value);
        }
    }
}

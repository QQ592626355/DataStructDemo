package com.market.myapplication.LinkTest;

public class MySingleLink {
    //链表的head
    Node mHead;
    //链表数目
    int mCount;

    //内部类来声明结点
    static class  Node<T>{
        T value;
        Node<T> next;

        public Node(T value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    //构造方法
    public MySingleLink(){
        //初始化结点和数目
        mHead = new Node(null,null);
        mCount = 0;
    }
    //获取链表数目
    public int getmCount(){
        return mCount;
    }
    //判断非空
    public boolean isEmpty(){
        return mCount == 0;
    }
    //返回链表头
    public Node getmHead(){
        return mHead;
    }
    //添加元素组成链表
    public <T> void add(int index,T value){
        //合法性判断
        if (index < 0 || index > mCount) {
            throw new IllegalArgumentException("Add failed.  Illegal index.");
        }
        Node temp = mHead;
        for (int i =0;i<index;i++){
            temp = temp.next;
        }
        temp.next = new Node(value,temp.next);
        mCount++;
    }
    //查找index处结点
    public Node getNode(int index){
        //可行性校验
        if(index < 0 || index > mCount){
            throw new IllegalArgumentException();
        }
        //创建一个新节点指向第0个位置处的结点
        Node node = mHead.next;
        for (int i =0;i<index;i++){
            node = node.next;
        }
        return node;
    }
    //查找头结点(第0个位置的结点)
    public Node getFirst(){
        return getNode(0);
    }
    //在index前插入结点
    public <T> void inset(int index,T value){
        //合法性判断
        if (index < 0 || index > mCount) {
            throw new IllegalArgumentException("insert failed.  Illegal index.");
        }
        //新建结点
        Node newNode = new Node(value,null);
        if (index ==0){
            newNode.next = mHead.next;
            mHead.next = newNode;
            mCount++;
            return;
        }
        //插入的结点不为0
        Node preNode = getNode(index - 1);
        newNode.next = preNode.next;
        preNode.next = newNode;
        mCount++;
    }
    //在头结点前插入
    public <T> void insertFirst(T value){
        inset(0,value);
    }
    //删除index处结点
    public void delete(int index){
        //合法性判断
        if (index < 0 || index > mCount) {
            throw new IllegalArgumentException("delete failed.  Illegal index.");
        }
        //删除的是头结点
        if (index ==0){
            Node node = getNode(0);
            mHead.next = node.next;
            node = null;
            mCount--;
            return;
        }

        Node currentNode = getNode(index);
        Node preNode = getNode(index - 1);
        preNode.next = currentNode.next;
        currentNode = null;
        mCount--;
    }
    //删除第一个位置
    public void deleteHead(){
        mHead.next = getNode(0).next;
        mCount--;
    }
    //删除尾结点
    public void deleteEnd(){
        getNode(mCount-2).next = null;
        mCount--;
    }

}

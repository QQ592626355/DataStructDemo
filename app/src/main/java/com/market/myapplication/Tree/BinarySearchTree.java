package com.market.myapplication.Tree;

public class BinarySearchTree{
    //二叉树结构
    private class Node{
        int value;
        Node left;
        Node right;
    }
    // 树根节点
    private Node root;
    //构造二叉查找树
    private void insert(int key){
        //创建要插入的结点
        Node p = new Node();
        p.value = key;
        //如果为空树，则插入结点为树根
        if (root==null){
            root = p;
        }else{//不是空树
            Node parent ;
            Node current = root;
            //循环判断
            while(true){
                parent = current;
                if (key>current.value){//右子树
                    current = current.right;
                    //跳出条件
                    if (current == null){
                        parent.right = p;
                        return;
                    }
                }else{//左子树
                    current = current.left;
                    //跳出条件
                    if (current ==null){
                        parent.left = p;
                        return;
                    }
                }
            }
        }
    }
    //前序遍历
    private void preOrder(Node root){
        if (root!=null){
            System.out.print(root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // 中序遍历
    private void midOrder(Node root){
        if (root!=null){
            midOrder(root.left);
            System.out.print(root.value+" ");
            midOrder(root.right);
        }
    }
    // 后序遍历
    private void postOrder(Node root){
        if (root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value+" ");
        }
    }
    private void traverse(int traverseType)
    {    // 选择以何种方式遍历
        switch (traverseType)
        {
            case 1:
                System.out.print("preOrder traversal: ");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("inOrder traversal: ");
                midOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("postOrder traversal: ");
                postOrder(root);
                System.out.println();
                break;
        }
    }
    //查找结点
    public Node find(int key){
        Node current = root;
        while(current.value!=key){

         if (key>current.value){//在右子树查找
            current = current.right;
         }else{//在左子树查找
            current = current.left;
         }
         //循环退出条件
         if (current==null){
             return null;
         }
        }
        return current;
    }
    //打印函数
    public void show(Node node) {
        if(node!=null){
            System.out.println(node.value);
        }else{
            System.out.println("null");
        }
    }
    /**
     *  二叉查找树的删除比较复杂,需要分为三种情况进行讨论：
     *  1.删除点没有子节点(叶子结点):
     *      思路：只需要将parent.left(或者是parent.right)设置为null
     *  2.删除点有一个子节点:
     *      思路：只需要将parent.left(或者是parent.right)设置为curren.right(或者是current.left)即可
     *  3.删除点有两个子节点：
     *    引入后继结点的概念：successor:如果将一棵二叉树按照中序遍历的方式输出，则任一节点的下一个节点就是该节点的后继节点。
     *    后继结点分为两种情况：
     *    1.后继节点为待删除节点的右子
     *      思路：只需要将curren用successor替换即可，注意处理好current.left和successor.right.
     *    2.后继节点为待删除结点的右孩子的左子树
     *      思路：
     *      1. successorParent.left=successor.right
     *      2. successor.left=current.left
     *      3. parent.left=seccessor
     */
//        //搜索删除结点的后续结点
//        public Node getSuccessor(Node delNode){
//            Node successorParent = delNode;
//            Node successor = delNode;
//            Node current = delNode.right;
//
//            //用来寻找后继结点
//            while(current!=null){
//                successorParent=successor;
//                successor=current;
//                current=current.left;
//            }
//
//            //如果后继结点为要删除结点的右子树的左子，需要预先调整一下要删除结点的右子树
//            if(successor!=delNode.right) {
//                successorParent.left=successor.right;
//                successor.right=delNode.right;
//            }
//            return successor;
//        }
//
//    public boolean delete(int key) // 删除结点
//    {
//        Node current = root;
//        Node parent = new Node();
//        boolean isRightChild = true;
//        while (current.value != key)
//        {
//            parent = current;
//            if (key > current.value)
//            {
//                current = current.right;
//                isRightChild = true;
//            }
//            else
//            {
//                current = current.left;
//                isRightChild = false;
//            }
//            if (current == null) return false; // 没有找到要删除的结点
//        }
//        // 此时current就是要删除的结点,parent为其父结点
//        // 要删除结点为叶子结点
//        if (current.right == null && current.left == null)
//        {
//            if (current == root)
//            {
//                root = null; // 整棵树清空
//            }
//            else
//            {
//                if (isRightChild)
//                    parent.right = null;
//                else
//                    parent.left = null;
//            }
//            return true;
//        }
//        //要删除结点有一个子结点
//        else if(current.left==null)
//        {
//            if(current==root)
//                root=current.right;
//            else if(isRightChild)
//                parent.right=current.right;
//            else
//                parent.left=current.right;
//            return true;
//        }
//        else if(current.right==null)
//        {
//            if(current==root)
//                root=current.left;
//            else if(isRightChild)
//                parent.right=current.left;
//            else
//                parent.left=current.left;
//            return true;
//        }
//        //要删除结点有两个子结点
//        else
//        {
//            Node successor=getSuccessor(current);    //找到要删除结点的后继结点
//
//            if(current==root)
//                root=successor;
//            else if(isRightChild)
//                parent.right=successor;
//            else
//                parent.left=successor;
//
//            successor.left=current.left;
//            return true;
//        }
//    }

    //unitTest
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(39);
        tree.insert(24);
        tree.insert(64);
        tree.insert(23);
        tree.insert(30);
        tree.insert(53);
        tree.insert(60);
        //三种遍历
        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
    }

}

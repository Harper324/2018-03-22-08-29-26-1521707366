package com.thoughtworks.collection;

public abstract class SingleLinkList<T> implements SingleLink {
    private static class Node<T>{
        public T date;  //数据域
        Node<T> next;   //后指针
        @SuppressWarnings("unused")
        public Node(T d,Node<T> n){
            date = d;
            next = n;
        }
        public Node(T d){
            date = d;
            next = null;
        }
    }

    private int theSize;
    private Node<T> head;

    public void SingleLinkedListType()
    {
        clear();
    }
    //清除
    public void clear(){
        theSize = 0;
        head = null;
    }

    //大小
    public int size(){
        return theSize;
    }

    //添加结点
    public void add(T x){
        Node<T> newNode = new Node<T>(x);
        if(head == null){
            head = newNode ;
        }else {
            Node<T> pNode = head;
            while(pNode.next!=null){
                pNode = pNode.next;
            }
            pNode.next = newNode;
        }
        theSize++;
    }

    //插入节点
    public void add(int index ,T x){
        checkRange(index);
        Node<T> pNode = getNode(index);
        Node<T> newNode = new Node<T>(x);
        newNode.next = pNode.next;
        pNode.next = newNode;
        theSize++;
    }

    //加在头节点
    public void addFirst(T x){
        Node<T> newNode = new Node<T>(x);
        newNode.next = head;
        head =newNode;
        theSize++;
    }

    //检查index是否越界
    public void checkRange(int index){
        if (index<0 || index > size())
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }

    //获取节点数据
    public T get(int index){
        Node<T> pNode = getNode(index);
        return pNode.date;
    }

    //获取节点
    public Node<T> getNode(int index){
        checkRange(index);
        Node<T> pNode = head;
        for(int i=0;i<index;i++){
            pNode = pNode.next;
        }
        return pNode;
    }

    //删除尾节点
    public void removeTail(){
        remove(size()-1);
        theSize--;
    }

    //删除节点
    public void remove(int index){
        checkRange(index);

        Node<T> pNode = getNode(index);
        Node<T> temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        temp.next = pNode.next;
        pNode.next = null;
        theSize--;
    }

}




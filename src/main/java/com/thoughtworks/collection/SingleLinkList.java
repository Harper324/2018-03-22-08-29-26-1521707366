package com.thoughtworks.collection;

public class SingleLinkList<T> implements SingleLink {
    //    保存链表的头节点
    private Node header;
    //    保存链表的尾节点
    private Node tail;
    //    保存节点数
    int length = 0;

    //    创建一个空的单项链表
    public SingleLinkList() {
        header = null;
        tail = null;
    }

    //    指定某一个元素创建一个单项链表
    public SingleLinkList(Object element) {
        header = new Node(element, null);
//        头和尾都指向同一个
        tail = header;
        length++;
    }

    //    返回链表长度

    @Override
    public int size() {
        return length;
    }

//    采用尾插入法为链表添加新节点

    @Override
    public void addTailPointer(Object data) {
        if (header == null) {
            header = new Node(data, null);
            tail = header;
        } else {
            Node newNode = new Node(data, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    @Override
    public void addHeadPointer(Object data) {
        if (header == null) {
            addTailPointer(data);
        } else {
            header = new Node(data, header);
        }
        length++;
    }

    @Override
    public Object getTailData() {
        return tail.getData();
    }

    @Override
    public Object getNode(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("索引越界！");
        }
        Node current = header;
        for (int i = 0; i < length; i++, current = current.getNext()) {
            if (i == index) {
                return current.getData();
            }
        }
        return null;
    }

    public Node getIndex(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("索引越界！");
        }
        Node current = header;
        for (int i = 0; i < length; i++, current = current.getNext()) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    @Override
    public Object getHeaderData() {
        return header.getData();
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteLast() {
        if (length != 0) {
            Node prev = getIndex(length - 1);
            prev.setNext(null);
            length--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteFirst() {
        if (length != 0) {
            header = header.getNext();
            length--;
            return true;
        } else {
            return false;
        }
    }
}







package org.nik.datastructure;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;
    private static class Node<T> {
        private T data;
        private Node next;
        private Node previous;

        Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public boolean add(T data){
        Node last = tail;
        Node<T> newNode = new Node<T>(data, null, last);
        if(head == null){
            head = newNode;
        }else {
            last.next = newNode;
        }
        tail = newNode;
        ++size;
        return true;
    }

    public boolean remove(T data){
        if(head == null){
            return false;
        }
        if(head.data.equals(data)){
            return removeHead();
        }
        if(tail.data.equals(data)){
            return removeTail();
        }
        Node moving = head;
        while(moving != null){
            if(moving.data.equals(data)){
                moving.previous.next = moving.next;
                moving.next.previous = moving.previous.next;
                --size;
                return true;
            }
            moving = moving.next;
        }
        return false;
    }

    private boolean removeHead() {
        head = head.next;
        head.previous = null;
        --size;
        return true;
    }

    private boolean removeTail() {
        tail.previous.next = null;
        --size;
        return true;
    }

    public void display(){
        Node moving = head;
        while(moving != null){
            System.out.println(moving.data);
            moving = moving.next;
        }
    }

    public int getSize(){
        return size;
    }

}

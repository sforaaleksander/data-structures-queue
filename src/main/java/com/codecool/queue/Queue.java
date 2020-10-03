package com.codecool.queue;

public class Queue {

    private class Node {
        private final String value;
        private Node nextNode;

        public Node(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }

        public Node getNextNode(){
            return this.nextNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }
    private Node head;
    private Node tail;

    public void enqueue (String value){
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }
        Node preTail = tail;
        tail = new Node(value);
        preTail.setNextNode(tail);
    }

    public String peek() throws IndexOutOfBoundsException{
        checkIfNotEmpty();
        return head.getValue();
    }

    private void checkIfNotEmpty() {
        if (head == null) throw new NullPointerException("The queue is empty");
    }

    public String dequeue() throws IndexOutOfBoundsException{
        checkIfNotEmpty();
        if (head.getNextNode() != null){
            head = head.getNextNode();
        }
        return head.getValue();
    };
}

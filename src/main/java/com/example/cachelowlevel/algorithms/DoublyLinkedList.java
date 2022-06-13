package com.example.cachelowlevel.algorithms;

import com.example.cachelowlevel.exceptions.InvalidElementException;

public class DoublyLinkedList<E> {
    private DoublyLinkedListNode<E> dummyHead;
    private DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if(node != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public DoublyLinkedListNode getLastNode() {
        if(!isItemPresent()) {
            return null;
        }
        return dummyTail.prev;
    }

    public DoublyLinkedListNode getFirstNode() {
        if(!isItemPresent()) {
            return null;
        }
        return dummyHead.next;
    }

    public void addNodeAtLast(DoublyLinkedListNode<E>node) {
        DoublyLinkedListNode prevNode = dummyTail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) throws InvalidElementException{
        if(element == null){
            throw new InvalidElementException("Element is invalid");
        }

        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public boolean isItemPresent(){
        return dummyHead != dummyTail;
    }

}

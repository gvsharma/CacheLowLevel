package com.example.cachelowlevel.algorithms;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;
    E element;
    public DoublyLinkedListNode(E ele){
        this.element = ele;
        prev = null;
        next = null;
    }
}

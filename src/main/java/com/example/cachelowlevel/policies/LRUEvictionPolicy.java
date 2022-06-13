package com.example.cachelowlevel.policies;

import com.example.cachelowlevel.algorithms.DoublyLinkedList;
import com.example.cachelowlevel.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode> map;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        map = new HashMap<>();
    }
    @Override
    public Key evictKey() {
       DoublyLinkedListNode<Key> node =  dll.getFirstNode();
       if(node == null){
           return null;
       }
       dll.detachNode(node);
       return node.getElement();
    }

    @Override
    public void keyAccessed(Key key) {
        if(map.containsKey(key)) {
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        } else {
            DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key);
            map.put(key, node);
        }
    }
}

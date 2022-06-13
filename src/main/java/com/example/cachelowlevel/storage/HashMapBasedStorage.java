package com.example.cachelowlevel.storage;

import com.example.cachelowlevel.exceptions.NotFoundException;
import com.example.cachelowlevel.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{
    Map<Key, Value>map;
    private final Integer capacity;
    public HashMapBasedStorage(Integer capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }


    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(isStorageFull()) throw new StorageFullException("Storage is full");
        map.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!map.containsKey(key)) {
            throw new NotFoundException("Key not found");
        }
        map.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!map.containsKey(key)) throw new NotFoundException("Key not found");
        return map.get(key);
    }

    private boolean isStorageFull(){
        return map.size() == capacity;
    }
}

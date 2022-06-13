package com.example.cachelowlevel;

import com.example.cachelowlevel.exceptions.NotFoundException;
import com.example.cachelowlevel.exceptions.StorageFullException;
import com.example.cachelowlevel.policies.EvictionPolicy;
import com.example.cachelowlevel.policies.LRUEvictionPolicy;
import com.example.cachelowlevel.storage.HashMapBasedStorage;
import com.example.cachelowlevel.storage.Storage;

public class Cache<Key, Value> {
    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key, Value> storage;

    public Cache(LRUEvictionPolicy<Key> keyLRUEvictionPolicy, HashMapBasedStorage<Key, Value> keyValueHashMapBasedStorage) {
        this.evictionPolicy = keyLRUEvictionPolicy;
        this.storage = keyValueHashMapBasedStorage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}

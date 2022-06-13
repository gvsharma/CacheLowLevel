package com.example.cachelowlevel.factories;

import com.example.cachelowlevel.Cache;
import com.example.cachelowlevel.policies.LRUEvictionPolicy;
import com.example.cachelowlevel.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }

}

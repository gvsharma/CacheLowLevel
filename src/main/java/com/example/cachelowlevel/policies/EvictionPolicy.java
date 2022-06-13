package com.example.cachelowlevel.policies;

public interface EvictionPolicy<Key> {
    Key evictKey();
    void keyAccessed(Key key);
}

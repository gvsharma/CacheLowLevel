package com.example.cachelowlevel.storage;

import com.example.cachelowlevel.exceptions.NotFoundException;
import com.example.cachelowlevel.exceptions.StorageFullException;

public interface Storage<Key, Value> {
        void add(Key key, Value value) throws StorageFullException;
        void remove(Key key);
        Value get(Key key) throws NotFoundException;
}

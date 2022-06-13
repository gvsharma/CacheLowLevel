package com.example.cachelowlevel.exceptions;

public class StorageFullException extends Exception{
    public StorageFullException(String message){
        super(message);
    }
}

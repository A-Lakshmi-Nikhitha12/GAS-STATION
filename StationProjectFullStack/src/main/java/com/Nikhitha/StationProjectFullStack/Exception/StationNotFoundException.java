package com.Nikhitha.StationProjectFullStack.Exception;

public class StationNotFoundException extends RuntimeException{
    public StationNotFoundException(Long id)
    {
        super("Could not find station by id " + id);
    }
}

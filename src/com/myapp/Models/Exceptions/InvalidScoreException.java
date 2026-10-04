package com.myapp.Models.Exceptions;
public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(String message){
        super(message);
    }    
}
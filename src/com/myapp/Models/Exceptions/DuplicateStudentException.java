package com.myapp.Models.Exceptions;

public class DuplicateStudentException extends RuntimeException {
    public DuplicateStudentException(String message){
        super(message);
    }    
}
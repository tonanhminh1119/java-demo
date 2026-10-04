package com.myapp.Models.Entities.SchoolObjects;

import com.myapp.Models.Exceptions.InvalidScoreException;

public class Student {
    
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    private int score;
    public int getScore() {return score;}
    public void setScore(int score) {
        if(score <0 || score > 100){
            throw new InvalidScoreException("Score must be between 0 and 100, got: " + score);
        }
        this.score = score;
    }

    public Student(String name, int score){
        this.name = name;
        setScore(score);
        // try{
        //     setScore(score);
        // }catch(InvalidScoreException ex){
        //     System.out.println("Exception: "+ex.getMessage());
        // }
    }
}
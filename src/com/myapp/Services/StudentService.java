package com.myapp.Services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.myapp.Application.*;
import com.myapp.Models.Entities.SchoolObjects.Student;
import com.myapp.Models.Exceptions.StudentNotFoundException;
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void getPassedStudents(){
        var list = repository.findAll();
        List<Student> passedStudents = list.stream()
            .filter(n -> n.getScore() > 50)
            // .map(n -> n.getName().toUpperCase())
            .collect(Collectors.toList());
        
        System.out.println("Total passed students is: "+ passedStudents.size());
        passedStudents.forEach(x -> System.out.println("Honoring student \"" + x.getName() + "\"" + "scoring " + x.getScore()));
    }
    public void getAverageScore(){
        var list = repository.findAll();
        System.out.println("Class avarage score: " + list.stream().mapToInt(Student::getScore).average().orElse(0.0));
    }
    public void getTop(int n){
        var list = repository.findAll();
        var topList = list.stream().sorted(Comparator.comparingInt(Student::getScore).reversed()).limit(n);
        System.out.println("Top " +n+ " students are:");
        topList.forEach(x -> System.out.println("Student \"" + x.getName() + "\"" + "scoring " + x.getScore()));
    }
    public void getByName(String name){
        repository.findByName(name).orElseThrow(() -> new StudentNotFoundException("Student " + name + " not found"));
    }
}

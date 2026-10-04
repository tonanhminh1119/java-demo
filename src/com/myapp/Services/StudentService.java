package com.myapp.Services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.myapp.Applications.*;
import com.myapp.Models.Entities.SchoolObjects.Student;
import com.myapp.Models.Exceptions.StudentNotFoundException;
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public List <Student> getPassedStudents() {
        return repository.findAll().stream()
            .filter(n -> n.getScore() >= 50)
            // .map(n -> n.getName().toUpperCase())
            .collect(Collectors.toList());
    }

    public double getAverageScore() {
        return repository.findAll().stream().mapToInt(Student::getScore).average().orElse(0.0);
    }
    public List < Student > getTop(int n) {
        return repository.findAll().stream().sorted(Comparator.comparingInt(Student::getScore).reversed()).
        limit(n)
            .collect(Collectors.toList());
    }

    public Student getByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new StudentNotFoundException("Student " + name + " not found"));
    }

    public void removeStudentByName(String name){
        repository.remove(name);
    }
}
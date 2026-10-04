package com.myapp.Services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.myapp.Application.*;
import com.myapp.Models.Entities.SchoolObjects.Student;
import com.myapp.Models.Exceptions.DuplicateStudentException;
import com.myapp.Models.Exceptions.StudentNotFoundException;

public class InMemoryStudentRepository implements StudentRepository{
    public Map<String, Student> StudentList;
    public InMemoryStudentRepository() {
        StudentList = new HashMap<>();
    }

    @Override
    public void add(Student student) {

        String name = student.getName();
        if(StudentList.containsKey(name)){
            throw new DuplicateStudentException("Student \"" + name + "\" already exist");
        }
        StudentList.put(name, student);
    }

    @Override
    public Optional<Student> findByName(String name) {
        // if(!StudentList.containsKey(name)){
        //     throw new StudentNotFoundException("Student " + name + " not found");
        // }
        return Optional.ofNullable(StudentList.get(name));
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        StudentList.entrySet().stream().forEach(x -> list.add(x.getValue()));
        return list;
    }

    @Override
    public void remove(String name) {
        if(!StudentList.containsKey(name)){
            throw new StudentNotFoundException("Student \\\"" + name + "\\\" not found");
        }
        StudentList.remove(name);
    }
    
}

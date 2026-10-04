package com.myapp;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.myapp.Application.StudentRepository;
import com.myapp.Models.*;
import com.myapp.Models.Entities.SchoolObjects.Student;
import com.myapp.Models.Exceptions.DuplicateStudentException;
import com.myapp.Models.Exceptions.InvalidScoreException;
import com.myapp.Services.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Random rand = new Random();

        InMemoryStudentRepository repo = new InMemoryStudentRepository();
        AddStudentToMap(repo, "A",rand.nextInt(50,101));
        AddStudentToMap(repo, "Q",rand.nextInt(50,101));
        AddStudentToMap(repo, "W",rand.nextInt(50,101));
        AddStudentToMap(repo, "A",rand.nextInt(50,101));
        AddStudentToMap(repo, "R",rand.nextInt(50,101));
        AddStudentToMap(repo, "E",rand.nextInt(50,101));
        StudentService students = new StudentService(repo);
        students.getPassedStudents();
        students.getAverageScore();
        students.getTop(3);
        students.getByName("A");

        //#region exception
        // try{
        
        //     int resullt = 10/0;
        // }catch(ArithmeticException  ex){
        //     System.out.println("Exception: "+ex.getMessage());
        // }finally{
        //     System.out.println("Always run");
        // }
        //#endregion
        //#region List


        // List<Student> list = new ArrayList<>();
        // AddStudent(list,"Minh",rand.nextInt(50,101));
        // AddStudent(list,"Khoa",101);// rand.nextInt(101)));
        // AddStudent(list,"Anh", -1);///rand.nextInt(101)));
        // AddStudent(list,"Hoa", rand.nextInt(101));
        // AddStudent(list,"Mai", rand.nextInt(101));


        // ListStudent(list);
        // List<String> result = list.stream()
        // .filter(n -> n.getScore() > 50)
        // .map(n -> n.getName().toUpperCase())
        // .collect(Collectors.toList());

        // Honoring(result);
        // System.out.println("Class avarage score: " + list.stream().mapToInt(Student::getScore).average().getAsDouble());
        //#endregion
        //#region done
        // Circle circle = new Circle();
        // circle.setRadius(3);
        // circle.describe();

        // Rectangle rectangle = new Rectangle();
        // rectangle.setHeight(5);
        // rectangle.setWidth(4);
        // rectangle.describe();

        // System.out.println("Add: " + Calculator.add(5, 3));
        // System.out.println("Subtract: " + Calculator.subtract(5, 3));
        // System.out.println("Multiply: " + Calculator.multiply(5, 3));
        // System.out.println("Divide: " + Calculator.divide(5, 3));
        //#endregion
    }
    public static void Honoring(List<String> list){
        list.forEach(x -> System.out.println("Honoring student \"" + x + "\""));
    }
    public static void ListStudent(List<Student> list){
        list.forEach(x -> System.out.println("Student " + x.getName() + " scoring " + x.getScore() ));
    }
    
    public static void AddStudentToMap(InMemoryStudentRepository repo, String name, int score){
        try{
            repo.add(new Student(name, score));
        }catch(InvalidScoreException ex){
            System.out.println("Exception: "+ex.getMessage());
        }catch(DuplicateStudentException ex){
            System.out.println("Exception: "+ex.getMessage());
        }
    }
    public static void AddStudent(List<Student> list, String name, int score){
        try{
            list.add(new Student(name, score));
        }catch(InvalidScoreException ex){
            System.out.println("Exception: "+ex.getMessage());
        }
    }
}

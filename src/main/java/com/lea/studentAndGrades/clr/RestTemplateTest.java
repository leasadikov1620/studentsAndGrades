package com.lea.studentAndGrades.clr;

import com.lea.studentAndGrades.beans.Grade;
import com.lea.studentAndGrades.beans.Student;
import com.lea.studentAndGrades.beans.Topic;
import com.lea.studentAndGrades.exceptions.SchoolSystemException;
import com.lea.studentAndGrades.util.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class RestTemplateTest implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8080/students";

    @Override
    public void run(String... args) throws Exception {
        //ADD A STUDENT
//        addStudent(Student.builder()
//                .name("Lea")
//                .birthday(Date.valueOf(LocalDate.now()))
//                .isActive(true)
//                .grades(List.of(Grade.builder()
//                        .topic(Topic.PROJECT1)
//                        .score(100)
//                        .build()))
//                .build());

        //ADD A GRADE TO THE STUDENT
//        addGrade(1,Grade.builder()
//                        .topic(Topic.PROJECT1)
//                        .score(95)
//                        .build());

        //DELETE STUDENT
      //  deleteStudent(1);

      // getAll();
       // getById(2);
      //  getByName("Lea");

   //     getAvg(2);
    }

    private void addStudent(Student student) {
        restTemplate.postForEntity(url + "/addStudent", student, Student.class);
        System.out.println("Student added successfully!");
    }

    private void addGrade(long id, Grade grade) {
        try {
        restTemplate.put(url + "/addGrade/" + id, grade);
        System.out.println("Student grades were updated successfully!");
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    private void deleteStudent(long id) {
        try {
            restTemplate.delete(url + "/deleteStudent/" + id);
            System.out.println("Student deleted successfully!");
        }catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    private void getAll() {
        ResponseEntity<Student[]> allStudents=restTemplate.getForEntity(url+"/getAll",Student[].class);
        List<Student> studentList = Arrays.asList(allStudents.getBody());
        TablePrinter.print(studentList);
    }

    private Student getById(long id){
        try {
            Student student = restTemplate.getForObject(url + "/getById/" + id, Student.class);
            TablePrinter.print(student);
            return student;
        } catch (Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }

    private void getByName(String name){
        ResponseEntity<Student[]> allStudentsByName =restTemplate.getForEntity(url+"/getByName/"+name , Student[].class);
        List<Student> studentList = Arrays.asList(allStudentsByName.getBody());
        TablePrinter.print(studentList);
    }

    private void getAvg(long id){
        double avg = restTemplate.getForObject(url+"/getAvg/"+id , Double.class);
        System.out.println(avg);
    }
}
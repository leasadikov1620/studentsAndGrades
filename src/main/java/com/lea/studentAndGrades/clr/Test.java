package com.lea.studentAndGrades.clr;

import com.lea.studentAndGrades.beans.Grade;
import com.lea.studentAndGrades.beans.Student;
import com.lea.studentAndGrades.beans.Topic;
import com.lea.studentAndGrades.repositories.StudentRepository;
import com.lea.studentAndGrades.services.StudentService;
import com.lea.studentAndGrades.util.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Test implements CommandLineRunner {
   // private final StudentRepository studentRepository;
    private final StudentService studentService;
    @Override
    public void run(String... args) throws Exception {

//        Student student = Student.builder()
//                .name("Lea")
//                .birthday(Date.valueOf(LocalDate.now()))
//                .isActive(true)
//                .grades(List.of(Grade.builder()
//                        .topic(Topic.PROJECT1)
//                        .score(100)
//                        .build()))
//                .build();
        //studentRepository.save(student);

//        studentService.addStudent(Student.builder()
//                .name("Oren")
//                .birthday(Date.valueOf(LocalDate.now()))
//                .isActive(true)
//                .grades(List.of(Grade.builder()
//                        .topic(Topic.PROJECT2)
//                        .score(100)
//                        .build()))
//                .build());

//        studentService.addGrade(1,Grade.builder()
//                        .topic(Topic.PROJECT1)
//                        .score(95)
//                        .build());

       // studentService.deleteStudent(2);

      //  TablePrinter.print(studentService.getAllStudents());
      //  TablePrinter.print(studentService.getStudentById(1));

     //   TablePrinter.print(studentService.getStudentsByName("Lea"));

       // System.out.println(studentService.getStudentGradesAvg(1));
    }
}

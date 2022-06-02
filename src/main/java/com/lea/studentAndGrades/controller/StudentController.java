package com.lea.studentAndGrades.controller;

import com.lea.studentAndGrades.beans.Grade;
import com.lea.studentAndGrades.beans.Student;
import com.lea.studentAndGrades.exceptions.SchoolSystemException;
import com.lea.studentAndGrades.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/addStudent")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping ("/addGrade/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addGrade(@PathVariable long id , @RequestBody Grade grade) throws SchoolSystemException {
        studentService.addGrade(id, grade);
    }

    @DeleteMapping("/deleteStudent/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable long id) throws SchoolSystemException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents(){
       return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id) throws SchoolSystemException {
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        return new ResponseEntity<>(studentService.getStudentsByName(name),HttpStatus.OK);
    }

    @GetMapping("/getAvg/{id}")
    public ResponseEntity<?> getAvg(@PathVariable long id){
        return new ResponseEntity<>(studentService.getStudentGradesAvg(id),HttpStatus.OK);
    }
}
